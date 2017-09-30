/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.integrador.dizimo;

import java.awt.Frame;
import javax.swing.JOptionPane;
import projeto.integrador.dizimo.database.Conexao;

/**
 *
 * @author Usuario
 */
public class Testes {
    public static void main(String[] args) {
        Conexao.getInstance();
        JOptionPane.showMessageDialog(new Frame(), "Aguardando..");
        Conexao.getInstance().closeConnection();
    }  
}
