/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Conexao {
    private static Conexao mySelf;
    private Connection cnx;
    
    private Conexao(){
        try {
            //Obtém o caminho atual de omde está sendo executado o projeto
            String path = System.getProperty("user.dir");
            path = path.replace('\\', '/');
            // db parameters
            String url = "jdbc:sqlite:" + path + "/dizimo.db";
            // cria a conexão com a base de dados
            cnx = DriverManager.getConnection(url);
            
            JOptionPane.showMessageDialog(new Frame(), "Conexão com SQLite estabelecida com sucesso!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

        }
    }

    public static Conexao getInstance() throws DBMException{
        if(mySelf == null){//se ainda não há instância criada
            mySelf = new Conexao();
            new DBMPersistor(new DBEndereco()   ).criarTabela();
            new DBMPersistor(new DBFicha()      ).criarTabela();
            new DBMPersistor(new DBFichaPessoa()).criarTabela();
            new DBMPersistor(new DBPagamento()  ).criarTabela();
            new DBMPersistor(new DBPessoa()     ).criarTabela();
        }
        return mySelf;
    }

    public Connection getCnx() {
        return cnx;
    }

    public void closeConnection(){
        try {
            if (cnx != null) {
                cnx.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new Frame(), ex.getMessage());
        }        
    }
}
