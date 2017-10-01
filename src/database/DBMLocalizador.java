/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//'T' é como se fosse um modelo. 'T' é qualquer coisa que extende object
public class DBMLocalizador<T extends Object>{
    //Utiliza classe pois não precisará de todo o objeto instanciado para fazer as buscas
    private Class<?> obj;
    private Connection cnx;

    private StringBuilder cmd;
    private String nome;
    private ArrayList<Field> atributos;
    private Method[] metodos;
	
    private ArrayList<Field> pk;

    //Campos para rodar o comando SQL
    private PreparedStatement ps;
    private int indCampo;
    	
    public DBMLocalizador( Class<?> obj ) throws DBMException {
        this.obj = obj;
        try {
            cnx = Conexao.getInstance().getCnx();
        } catch (Exception e) {
            throw new DBMException(e);
        };
        DBMNomeTabela nomeTab = obj.getAnnotation( DBMNomeTabela.class );//tenta conseguir a anotação com o nome da tabela
        nome = nomeTab != null ? nomeTab.nome() : obj.getClass().getSimpleName();//carrega o nome a utilizar para o banco
        Field[] vetorAtributos = obj.getDeclaredFields();//obtêm a lista de campos da classe
        metodos = obj.getMethods();//obtêm a lista de métodos da classe
        pk = new ArrayList<Field>();
        for( Field atributo : vetorAtributos ) {
            //Se tem anotação da chave da tabela
            if(atributo.getAnnotation(DBMPK.class) != null){
                pk.add(atributo);
            }
            //Se não tem anotação para excluir do das colunas do banco de dados
            if(atributo.getAnnotation(DBMExcluido.class) == null){
                atributos.add(atributo);
            }
        }
        if(atributos.isEmpty()){//se não encontrou nenhum atributo que vá para o banco
            throw new DBMException(new Exception());
        }
        if(pk.isEmpty()){//se não encontrou nenhum atributo que compõe a chave
            pk.add(atributos.get(0));//assume o primeiro atributo como chave primária
        }

    }
	
    public List<T> procuraRegistros(String clausulaWhere) throws DBMException{
        return procuraRegistros(clausulaWhere, (Object[]) null);
    }
	
    @SuppressWarnings("unchecked")//sempre vai retornar o tipo T
    public List<T> procuraRegistros(String clausulaWhere, Object... prms) throws DBMException{
        ArrayList<T> result = new ArrayList<T>();
        preparaSelect();
        //gera Statement para execução do comando e substitui todos os curingas
        cmd.append(" WHERE " + clausulaWhere);
        preparaStatement(cmd.toString());
        if(prms != null){
            for(Object o: prms){
                try {
                    ps.setObject(++indCampo, o);
                } catch (SQLException e) {
                    throw new DBMException(e);
                }
            }
        }
	//tenta localizar registros	
        try {
            ResultSet rs;
            rs = ps.executeQuery();
            if(!rs.next()){
                return null;
            }
            //obtém o construtor da classe
            Constructor<?> c = obj.getDeclaredConstructor((Class<?>[]) null);
            Object novo;
            //para cada registro retornado, cria um novo objeto
            do{
                novo = c.newInstance( (Object[]) null);
                preencheObjeto(novo, rs);
                result.add( (T) novo);
            }while(rs.next());

        } catch (SQLException | NoSuchMethodException | SecurityException | InstantiationException |
                 IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new DBMException(e);
        }
        return result;
    }
	
    //A chave primária pode ser qualquer coisa. O tipo retornado 'T', definido na declaração da classe, fará com que retorne o mesmo tipo de classe usada no construtor
    @SuppressWarnings("unchecked")//sempre vai retornar o tipo T
    public T procuraRegistro(Object... vlChave) throws DBMException{
        preparaSelect();
        pushWhere();
        //Gera Statement para execução do comando e substitui todos os curingas
        preparaStatement(cmd.toString());
        for(Object o: vlChave){
            try {
                ps.setObject(++indCampo, o);
            } catch (SQLException e) {
                throw new DBMException(e);
            }
        }
        //lista o comando no banco
        System.out.println(ps.toString());
        try {
            ResultSet rs;
            rs = ps.executeQuery();
            if(!rs.next()){
                return null;
            }
            //Cria somente um novo objeto, pois fez filtro em todos os campos chave
            Constructor<?> c = obj.getDeclaredConstructor((Class<?>[]) null);
            Object novo = c.newInstance( (Object[]) null);
            preencheObjeto(novo, rs);
            return (T) novo;
        } catch (SQLException | NoSuchMethodException | SecurityException | InstantiationException |
                 IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new DBMException(e);
        }

    }
	
    public void preparaSelect(){
        cmd = new StringBuilder();//prepara montagem do comando
        cmd.append( "SELECT " );
        for (Field f : atributos) {
            cmd.append(f.getName() + ", ");
        }
        cmd.delete( cmd.length() - 2, cmd.length() );
        cmd.append( " FROM " + nome);
    }

    private void preencheObjeto(Object novo, ResultSet rs) throws DBMException, SQLException {
        indCampo = 0;
        for (Field f : atributos) {
            Object vl = rs.getObject(++indCampo);
            if(vl == null)continue;//ignora colunas retornadas sem conteúdo
            for (Method met : metodos) {
                if(met.getName().equalsIgnoreCase("set" + f.getName())){
                    try {
                        met.invoke(novo, vl);
                    } catch (Exception e) {
                        throw new DBMException(e);
                    }
                    break;
                }
            }
        }
    }

    private void pushWhere() {
        cmd.append( " WHERE ");
        for( Field pkField : pk ) {
            cmd.append(pkField.getName() + " = ? AND ");
        }
        cmd.delete( cmd.length() - 4, cmd.length() );
    }

    private void preparaStatement(String cmd) throws DBMException{
        try {
            indCampo = 0;
            ps = cnx.prepareStatement(cmd);
        } catch (Exception e) {
            throw new DBMException(e);
        }
    }

}
