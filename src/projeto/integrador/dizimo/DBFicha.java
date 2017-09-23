/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.integrador.dizimo;

/**
 *
 * @author Lucas
 */
public class DBFicha {
    private Integer codigo;
    private Integer intResponsavel;
    private DBPessoa responsavel;
    private String observacoes;

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
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
}
