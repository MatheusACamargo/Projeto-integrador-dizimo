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
@DBMNomeTabela(nome = "FichaPessoa")
public class DBFichaPessoa {
    @DBMPK
    private Integer codigo;
    private Integer intFicha;
    @DBMExcluido
    private DBFicha ficha;
    private Integer intDBPessoa;
    @DBMExcluido
    private DBPessoa pessoa;
    private String strDataInicial;
    @DBMExcluido
    private Date dataInicial;
    private String strDataFinal;
    @DBMExcluido
    private Date dataFinal;

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

    public String getStrDataInicial() {
        return strDataInicial;
    }

    public void setstrDataInicial(String strDataInicial) {
        this.strDataInicial = strDataInicial;
        dataInicial = Conexao.getInstance().stringToDate(strDataInicial);
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
        strDataInicial = Conexao.getInstance().dateToString(dataInicial);
    }

    public String getStrDataFinal() {
        return strDataFinal;
    }

    public void setStrDataFinal(String strDataFinal) {
        this.strDataFinal = strDataFinal;
        dataFinal = Conexao.getInstance().stringToDate(strDataFinal);
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
        strDataFinal = Conexao.getInstance().dateToString(dataFinal); 
    }
    
}
