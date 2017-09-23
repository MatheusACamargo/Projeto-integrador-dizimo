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
public class DBPagamento {
    private Integer codigoFicha;
    private Integer intDataReferencia;
    private Timestamp dataReferencia;
    private float valor;
    private Integer intDataPagamento;
    private Timestamp dataPagamento;

    public DBPagamento() {
    }

    public Integer getCodigoFicha() {
        return codigoFicha;
    }

    public void setCodigoFicha(Integer codigoFicha) {
        this.codigoFicha = codigoFicha;
    }

    public Integer getIntDataReferencia() {
        return intDataReferencia;
    }

    public void setIntDataReferencia(Integer intDataReferencia) {
        this.intDataReferencia = intDataReferencia;
    }

    public Timestamp getDataReferencia() {
        return dataReferencia;
    }

    public void setDataReferencia(Timestamp dataReferencia) {
        this.dataReferencia = dataReferencia;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Integer getIntDataPagamento() {
        return intDataPagamento;
    }

    public void setIntDataPagamento(Integer intDataPagamento) {
        this.intDataPagamento = intDataPagamento;
    }

    public Timestamp getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Timestamp dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    
}
