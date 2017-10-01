package database;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Usuario
 */
@DBMNomeTabela(nome = "Pessoa")
public class DBPessoa {
    @DBMPK
    private Integer codigo = 0;
    private Integer numFichaAtual = 0;
    private String nome = "";
    private Integer intEndereco = 0;
    private Integer numCasa = 0;
    private Integer telefone = 0;
    private String estadoCivil = "";
    @DBMExcluido
    private boolean casamentoCivil = false;
    private Integer intCasamentoCivil = 0;
    @DBMExcluido
    private boolean casamentoReligioso = false;
    private Integer intCasamentoReligioso = 0;
    private String casa = "";
    private String salario = "";
    private String strNascimento = "";
    @DBMExcluido
    private Date nascimento = null;
    private String strDataSocio = "";
    @DBMExcluido
    private Date dataSocio = null;
    private String natural = "";
    private String religiao = "";
    @DBMExcluido
    private boolean primeiraComunhao = false;
    private Integer intPrimeiraComunhao = 0;
    @DBMExcluido
    private boolean crisma = false;
    private Integer intCrisma = 0;
    @DBMExcluido
    private boolean praticante = false;
    private Integer intPraticante = 0;
    private String instrucao = "";
    private String profissao = "";
    
    public DBPessoa(){
        
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getNumFichaAtual() {
        return numFichaAtual;
    }

    public void setNumFichaAtual(Integer numFichaAtual) {
        this.numFichaAtual = numFichaAtual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIntEndereco() {
        return intEndereco;
    }

    public void setIntEndereco(Integer intEndereco) {
        this.intEndereco = intEndereco;
    }

    public Integer getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(Integer numCasa) {
        this.numCasa = numCasa;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public boolean isCasamentoCivil() {
        return casamentoCivil;
    }

    public void setCasamentoCivil(boolean casamentoCivil) {
        this.casamentoCivil = casamentoCivil;
        intCasamentoCivil = casamentoCivil? 1 : 0;
    }

    public Integer getIntCasamentoCivil() {
        return intCasamentoCivil;
    }

    public void setIntCasamentoCivil(Integer intCasamentoCivil) {
        this.intCasamentoCivil = intCasamentoCivil;
        casamentoCivil = intCasamentoCivil == 1;
    }

    public boolean isCasamentoReligioso() {
        return casamentoReligioso;
    }

    public void setCasamentoReligioso(boolean casamentoReligioso) {
        this.casamentoReligioso = casamentoReligioso;
        intCasamentoReligioso = casamentoReligioso? 1 : 0;
    }

    public Integer getIntCasamentoReligioso() {
        return intCasamentoReligioso;
    }

    public void setIntCasamentoReligioso(Integer intCasamentoReligioso) {
        this.intCasamentoReligioso = intCasamentoReligioso;
        casamentoReligioso = intCasamentoReligioso == 1;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String casa) {
        this.casa = casa;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getStrNascimento() {
        return strNascimento;
    }

    public void setStrNascimento(String strNascimento) {
        this.strNascimento = strNascimento;
        nascimento = Conexao.getInstance().stringToDate(strNascimento);
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
        strNascimento = Conexao.getInstance().dateToString(nascimento);
    }

    public String getStrDataSocio() {
        return strDataSocio;
    }

    public void setStrDataSocio(String strDataSocio) {
        this.strDataSocio = strDataSocio;
        dataSocio = Conexao.getInstance().stringToDate(strDataSocio);
    }

    public Date getDataSocio() {
        return dataSocio;
    }

    public void setDataSocio(Date dataSocio) {
        this.dataSocio = dataSocio;
        strDataSocio = Conexao.getInstance().dateToString(dataSocio);
    }

    public String getNatural() {
        return natural;
    }

    public void setNatural(String natural) {
        this.natural = natural;
    }

    public String getReligiao() {
        return religiao;
    }

    public void setReligiao(String religiao) {
        this.religiao = religiao;
    }

    public boolean isPrimeiraComunhao() {
        return primeiraComunhao;
    }

    public void setPrimeiraComunhao(boolean primeiraComunhao) {
        this.primeiraComunhao = primeiraComunhao;
        intPrimeiraComunhao = primeiraComunhao? 1 : 0;
        
    }

    public Integer getIntPrimeiraComunhao() {
        return intPrimeiraComunhao;
    }

    public void setIntPrimeiraComunhao(Integer intPrimeiraComunhao) {
        this.intPrimeiraComunhao = intPrimeiraComunhao;
        primeiraComunhao = intPrimeiraComunhao == 1;
    }

    public boolean isCrisma() {
        return crisma;
    }

    public void setCrisma(boolean crisma) {
        this.crisma = crisma;
    }

    public Integer getIntCrisma() {
        return intCrisma;
    }

    public void setIntCrisma(Integer intCrisma) {
        this.intCrisma = intCrisma;
    }

    public boolean isPraticante() {
        return praticante;
    }

    public void setPraticante(boolean praticante) {
        this.praticante = praticante;
    }

    public Integer getIntPraticante() {
        return intPraticante;
    }

    public void setIntPraticante(Integer intPraticante) {
        this.intPraticante = intPraticante;
    }

    public String getInstrucao() {
        return instrucao;
    }

    public void setInstrucao(String instrucao) {
        this.instrucao = instrucao;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

        
}
