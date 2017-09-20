/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.integrador.dizimo;

import java.sql.Timestamp;

/**
 *
 * @author Lucas
 */
public class DBFichaPessoa {
    private Integer codigo;
    private Integer intFicha;
    private DBFicha ficha;
    private Integer intDBPessoa;
    private DBPessoa pessoa;
    private Integer intDataInicial;
    private Timestamp dataInicial;
    private Integer intDataFinal;
    private Timestamp dataFinal;

    public DBFichaPessoa() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getIntFicha() {
        return intFicha;
    }

    public void setIntFicha(Integer intFicha) {
        this.intFicha = intFicha;
    }

    public DBFicha getFicha() {
        return ficha;
    }

    public void setFicha(DBFicha ficha) {
        this.ficha = ficha;
    }

    public Integer getIntDBPessoa() {
        return intDBPessoa;
    }

    public void setIntDBPessoa(Integer intDBPessoa) {
        this.intDBPessoa = intDBPessoa;
    }

    public DBPessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(DBPessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Integer getIntDataInicial() {
        return intDataInicial;
    }

    public void setIntDataInicial(Integer intDataInicial) {
        this.intDataInicial = intDataInicial;
    }

    public Timestamp getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Timestamp dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Integer getIntDataFinal() {
        return intDataFinal;
    }

    public void setIntDataFinal(Integer intDataFinal) {
        this.intDataFinal = intDataFinal;
    }

    public Timestamp getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Timestamp dataFinal) {
        this.dataFinal = dataFinal;
    }
    
}
