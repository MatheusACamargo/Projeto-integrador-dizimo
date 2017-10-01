/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.awt.Frame;
import javax.swing.JOptionPane;

public class DBMException extends Exception{

	public DBMException(String msg) {
            super();
	}

	public DBMException(Exception e) {
            super();
            e.printStackTrace();
            JOptionPane.showMessageDialog(new Frame(), e.getMessage());
	}

}
