/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dizimo;

import java.awt.Frame;
import javax.swing.JOptionPane;
import database.Conexao;
import database.DBEndereco;
import database.DBMException;
import database.DBMPersistor;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Testes {
    public static void main(String[] args) {
        Connection cnx = Conexao.getInstance().getCnx();
        if(cnx == null) {
            System.exit(0);
        }

        DBEndereco end = new DBEndereco();
        end.setCodigo(1);
        end.setLogradouro("Rua tal e tal");
        end.setCep(93351120);
        end.setDescricaoComplementar("Nro 999");
        end.setVila("nome da vila");
        end.setBairro("Roselandia");

        DBMPersistor pEnd;
        try {
            pEnd = new DBMPersistor(end);
            pEnd.insere();
        } catch (DBMException e) {
        }
//			persistor.altera(6);
//			persistor.exclui(6);

        JOptionPane.showMessageDialog(new Frame(), "Aguardando..");
        Conexao.getInstance().closeConnection();
    }  
}
