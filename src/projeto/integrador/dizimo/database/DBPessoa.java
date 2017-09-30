package projeto.integrador.dizimo.database;

import java.sql.Timestamp;

/**
 *
 * @author Usuario
 */
public class DBPessoa {
    private Integer codigo = 0;
    private Integer numFichaAtual = 0;
    private String nome = "";
    private Integer intEndereco = 0;
    private DBEndereco endereco = null;
    private Integer numCasa = 0;
    private Integer telefone = 0;
    private String estadoCivil = "";
    private boolean casamentoCivil = false;
    private boolean casamentoReligioso = false;
    private String casa = "";
    private String salario = "";
    private Integer intNascimento = 0;
    private Timestamp nascimento = null;
    private Integer intDataSocio = 0;
    private Timestamp dataSocio = null;
    private String natural = "";
    private String religiao = "";
    private boolean primeiraComunhao = false;
    private boolean crisma = false;
    private boolean praticante = false;
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

    public DBEndereco getEndereco() {
        return endereco;
    }

    public void setEndereco(DBEndereco endereco) {
        this.endereco = endereco;
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
    }

    public boolean isCasamentoReligioso() {
        return casamentoReligioso;
    }

    public void setCasamentoReligioso(boolean casamentoReligioso) {
        this.casamentoReligioso = casamentoReligioso;
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

    public Integer getIntNascimento() {
        return intNascimento;
    }

    public void setIntNascimento(Integer intNascimento) {
        this.intNascimento = intNascimento;
    }

    public Timestamp getNascimento() {
        return nascimento;
    }

    public void setNascimento(Timestamp nascimento) {
        this.nascimento = nascimento;
    }

    public Integer getIntDataSocio() {
        return intDataSocio;
    }

    public void setIntDataSocio(Integer intDataSocio) {
        this.intDataSocio = intDataSocio;
    }

    public Timestamp getDataSocio() {
        return dataSocio;
    }

    public void setDataSocio(Timestamp dataSocio) {
        this.dataSocio = dataSocio;
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
    }

    public boolean isCrisma() {
        return crisma;
    }

    public void setCrisma(boolean crisma) {
        this.crisma = crisma;
    }

    public boolean isPraticante() {
        return praticante;
    }

    public void setPraticante(boolean praticante) {
        this.praticante = praticante;
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
