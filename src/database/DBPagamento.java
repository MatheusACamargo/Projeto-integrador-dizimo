/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Lucas
 */
@DBMNomeTabela(nome = "Pagamento")
public class DBPagamento {
    @DBMPK
    private Integer codigoFicha;
    @DBMPK
    private String strDataReferencia;
    @DBMExcluido
    private Date dataReferencia;
    private float valor;
    private String strDataPagamento;
    @DBMExcluido
    private Date dataPagamento;

    public DBPagamento() {
    }

    public Integer getCodigoFicha() {
        return codigoFicha;
    }

    public void setCodigoFicha(Integer codigoFicha) {
        this.codigoFicha = codigoFicha;
    }

    public String getStrDataReferencia() {
        return strDataReferencia;
    }

    public void setStrDataReferencia(String strDataReferencia) {
        this.strDataReferencia = strDataReferencia;
        dataReferencia = Conexao.getInstance().stringToDate(strDataReferencia);
    }

    public Date getDataReferencia() {
        return dataReferencia;
    }

    public void setDataReferencia(Date dataReferencia) {
        this.dataReferencia = dataReferencia;
        strDataReferencia = Conexao.getInstance().dateToString(dataReferencia);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getStrDataPagamento() {
        return strDataPagamento;
    }

    public void setStrDataPagamento(String strDataPagamento) {
        this.strDataPagamento = strDataPagamento;
        dataPagamento = Conexao.getInstance().stringToDate(strDataPagamento);
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
        strDataPagamento = Conexao.getInstance().dateToString(dataPagamento); 
    }
    
}
