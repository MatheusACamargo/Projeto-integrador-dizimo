/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBMPersistor {
    private Object obj;
    private Connection cnx;
    private StringBuilder cmd;
    private ArrayList<Field> atributos;
    private Method[] metodos;
    private String nome;
    private ArrayList<Field> pk;
    //Campos para rodar o comando SQL
    private PreparedStatement ps;
    private int indCampo;
    private Object vlCampo;
	
    public DBMPersistor( Object obj ) throws DBMException {
        this.obj = obj;
        try {
            cnx = Conexao.getInstance().getCnx();
        } catch (Exception e) {
            throw new DBMException(e);
        }
        Field[] vetorAtributos = obj.getClass().getDeclaredFields();//obtêm a lista de campos da classe
        atributos = new ArrayList<>();
        metodos = obj.getClass().getMethods();//obtêm a lista de métodos da classe
        DBMNomeTabela nomeTab = obj.getClass().getAnnotation( DBMNomeTabela.class );//tenta conseguir a anotação com o nome da tabela
        nome = nomeTab != null ? nomeTab.nome() : obj.getClass().getSimpleName();//carrega o nome a utilizar para o banco
        pk = new ArrayList<>();
        for( Field atributo : vetorAtributos ) {
            //Se tem anotação de chave primária
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
    
//        // SQL statement for creating a new table
//        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
//                + "	id integer PRIMARY KEY,\n"
//                + "	name text NOT NULL,\n"
//                + "	capacity real\n"
//                + ");";    
    public void criarTabela() throws DBMException{
        String nomeColuna;
        cmd = new StringBuilder();//prepara montagem do comando
        cmd.append( "CREATE TABLE IF NOT EXISTS " );
        cmd.append( nome );
        cmd.append( " (\n" );
	//Monta lista de campos	
        for( Field atributo : atributos ) {//varre os atributos montando seu nome no comando
            cmd.append( atributo.getName() );
            cmd.append( " " );
            nomeColuna = atributo.getType().getSimpleName();
            switch(nomeColuna){
                case "String":
                    cmd.append("TEXT");
                    break;
                case "float":
                    cmd.append("REAL");
                    break;
                default:
                    cmd.append(nomeColuna.toUpperCase());
                    break;
            }
            //Se for um campo chave da tabela
            if(pk.contains(atributo) && pk.size() == 1){
                cmd.append(" PRIMARY KEY");
            }
            cmd.append( ",\n" );
        }
        //Se a tabela tem chave primária múltipla
        if(pk.size() > 1){
            cmd.append("PRIMARY KEY (");
            for( Field atributo : pk ) {//varre os atributos chave
                cmd.append(atributo.getName());
                cmd.append(",");
            }
            cmd.delete( cmd.length() - 1, cmd.length() );
            cmd.append( ")\n" );
        }else{
            cmd.delete( cmd.length() - 2, cmd.length() );
        }
        cmd.append( "\n);" );
        
        try {
            Statement stmt = cnx.createStatement();
            stmt.execute(cmd.toString());
        } catch (SQLException e) {
            throw new DBMException(e);
        }
    }

    public void insere() throws DBMException{
        cmd = new StringBuilder();//prepara montagem do comando
		
        cmd.append( "INSERT INTO " );
        cmd.append( nome );
        cmd.append( " ( " );
	//Monta lista de campos	
        int qtPrms = 0;
        for( Field atributo : atributos ) {//varre os atributos montando seu nome no comando
            cmd.append( atributo.getName() );
            cmd.append( "," );
            qtPrms++;
        }
        cmd.delete( cmd.length() - 1, cmd.length() );
        cmd.append( ") VALUES(" );
	//Monta lista de valores a substituir
        for( int i = 0; i < qtPrms; i++ ) {
            cmd.append( "?," );
        }
        cmd.delete( cmd.length() - 1, cmd.length() );
        cmd.append( ")" );
		
        preparaStatement(cmd.toString());//gera Statement para execução do comando e substitui todos os curingas
        //substitui o valor de todos os campos
        for( Field atributo : atributos ) {
            substituiVlCampo(atributo);
        }

        //lista o comando no banco
        System.out.println( ps.toString() );
        try {
            ps.execute();
        } catch (SQLException e) {
            throw new DBMException(e);
        }
    }

    public void altera() throws DBMException{
        cmd = new StringBuilder();//prepara montagem do comando
        cmd.append( "UPDATE " + nome + " SET " );
        //monta lista de campos a atualizar
        for( Field atributo : atributos ) {
            //Ignora atributos chave da tabela pois não podem ser atualizados
            if(pk.contains(atributo))continue;
            cmd.append( atributo.getName() );
            cmd.append( " = ?, " );
        }
        cmd.delete( cmd.length() - 2, cmd.length() );
        pushWhere();
        //gera Statement para execução do comando e substitui todos os curingas
        preparaStatement(cmd.toString());
        for( Field atributo : atributos ) {
            //ignora atributos que sejam chave primária da tabela pois subtiui-os ao final, no where
            if(pk.contains(atributo))continue;
            substituiVlCampo(atributo);
        }
        //substitui os campos chave do where
        for( Field pkField : pk ) {
            substituiVlCampo(pkField);
        }
        //lista o comando no banco
        System.out.println( ps.toString() );
        try {
            ps.execute();
        } catch (SQLException e) {
            throw new DBMException(e);
        }
    }

    public void exclui() throws DBMException {
        //prepara montagem do comando	
        cmd = new StringBuilder();
        cmd.append( "DELETE FROM " + nome);
        pushWhere();
        //substitui os campos chave do where
        preparaStatement(cmd.toString());
        for( Field pkField : pk ) {
                substituiVlCampo(pkField);
        }
        //lista o comando no banco
        System.out.println( ps.toString() );
        try {
            ps.execute();
        } catch (SQLException e) {
            throw new DBMException(e);
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

    private void substituiVlCampo(Field atributo) throws DBMException {
        vlCampo = getvlCampo(atributo);
        try {
            ps.setObject(++indCampo, vlCampo);
        } catch (Exception e) {
            throw new DBMException(e);
        }
    }
	
    private Object getvlCampo(Field campo) throws DBMException {
        for (Method met : metodos) {
            if(met.getName().equalsIgnoreCase("get" + campo.getName())){
                try {
                    //tenta invocar o método indicando quais os argumentos a usar (como é get, não tem nenhum)
                    return met.invoke(obj, (Object[]) null);
                } catch (Exception e) {
                    throw new DBMException(e);
                }
            }
        }
        return null;
    }
}
