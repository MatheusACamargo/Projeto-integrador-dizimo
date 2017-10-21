/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
@DBMNomeTabela(nome = "Ficha")
public class DBFicha {
    @DBMPK
    private Integer codigo = 0;
    private Integer intResponsavel = 0;
    @DBMExcluido
    private DBPessoa responsavel = null;
    private String observacoes = "";
    
    //Dados para preenchimento do objeto
    @DBMExcluido
    private DBMLocalizador<DBPessoa> lPessoa;
    
    public DBFicha() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getIntResponsavel() {
        return intResponsavel;
    }

    public void setIntResponsavel(Integer intResponsavel) {
        this.intResponsavel = intResponsavel;
    }

    public DBPessoa getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(DBPessoa responsavel) {
        this.responsavel = responsavel;
        intResponsavel = responsavel.getCodigo();
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public void preencheObjeto(){
        try {
            lPessoa = new DBMLocalizador<>(DBPessoa.class);
            responsavel = lPessoa.procuraRegistro(intResponsavel);
            if(responsavel == null){
                responsavel = new DBPessoa();
            }
            responsavel.preencheObjeto();
        } catch (DBMException ex) {
            Logger.getLogger(DBFicha.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
