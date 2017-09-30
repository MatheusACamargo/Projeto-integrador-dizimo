/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.integrador.dizimo.database;

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
    private Connection conn;
    
    private Conexao(){
        try {
            //Obtém o caminho atual de omde está sendo executado o projeto
            String path = System.getProperty("user.dir");
            path = path.replace('\\', '/');
            // db parameters
            String url = "jdbc:sqlite:" + path + "/dizimo.db";
            // cria a conexão com a base de dados
            conn = DriverManager.getConnection(url);
            
            JOptionPane.showMessageDialog(new Frame(), "Conexão com SQLite estabelecida com sucesso!");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {

        }
    }

    public static Conexao getInstance(){
        if(mySelf == null){//se ainda não há instância criada
            mySelf = new Conexao();
        }
        return mySelf;
    }

    public void closeConnection(){
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new Frame(), ex.getMessage());
        }        
    }
}
