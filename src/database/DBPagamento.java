/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.Date;

/**
 *
 * @author Lucas
 */
@DBMNomeTabela(nome = "Pagamento")
public class DBPagamento {
    @DBMPK
    private Integer codigoFicha = 0;
    @DBMPK
    private String strDataReferencia = "";
    @DBMExcluido
    private Date dataReferencia = null;
    private double valor = 0;
    private String strDataPagamento = "";
    @DBMExcluido
    private Date dataPagamento = null;
    @DBMExcluido
    private DBFicha ficha = null;
    
    //Dados para preenchimento do objeto
    @DBMExcluido
    private DBMLocalizador<DBFicha> lFicha;    

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
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
    
    public DBFicha getFicha(){
        return ficha;
    }
    
    public void preencheObjeto(){
        try {
            lFicha = new DBMLocalizador<>(DBFicha.class);
            ficha = lFicha.procuraRegistro(codigoFicha);
            if(ficha == null){
                ficha = new DBFicha();
                ficha.preencheObjeto();
            }
        } catch (DBMException ex) {
            
        }
    }
    
    
}
