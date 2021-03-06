/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import database.DBMException;
import database.DBMLocalizador;
import database.DBPagamento;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author 0132945
 */
public class GridPagamentos extends javax.swing.JDialog {
    private DefaultTableModel dtm;
    private DBMLocalizador<DBPagamento> lPagamento;
    private ArrayList<DBPagamento> listPagamentos;
    private DateFormat editaData;
    private DateFormat editaDataDigitada;
    private DateFormat editaPeriodo;
    private DateFormat editaPeriodoDigitado;
    private DateFormat editaAno;
    /**
     * Creates new form GridPagamentos
     */
    public GridPagamentos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        dtm = (DefaultTableModel) tPagamentos.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfFiltro = new javax.swing.JTextField();
        lbFiltro = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPagamentos = new javax.swing.JTable();
        jExpXls = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabela de pagamentos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tfFiltro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfFiltroFocusLost(evt);
            }
        });

        lbFiltro.setText("Filtro");

        tPagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ficha", "Nome", "Data pagamento", "Valor", "Conferido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tPagamentos);
        if (tPagamentos.getColumnModel().getColumnCount() > 0) {
            tPagamentos.getColumnModel().getColumn(0).setPreferredWidth(20);
            tPagamentos.getColumnModel().getColumn(4).setResizable(false);
            tPagamentos.getColumnModel().getColumn(4).setPreferredWidth(30);
        }

        jExpXls.setText("Exportar XLS");
        jExpXls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jExpXlsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jExpXls))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFiltro)
                    .addComponent(jExpXls))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfFiltroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfFiltroFocusLost
        try {
            limpaGrid();
            if(!tfFiltro.getText().isEmpty()){
                Date dataDigitada = null;
                String buscaData = "";
                String buscaPeriodo = "";
                String buscaAno = "";
                String buscaNome = "%" + tfFiltro.getText() + "%";
                try {
                    dataDigitada = editaData.parse(tfFiltro.getText());
                    buscaData = editaDataDigitada.format(dataDigitada);
                } catch (ParseException ex) {
                    try {
                        //se parse da data não funcionou então tenta identificar como um período
                        dataDigitada = editaPeriodo.parse(tfFiltro.getText());
                        buscaPeriodo = editaPeriodoDigitado.format(dataDigitada) + "%";
                    } catch (ParseException ex1) {
                        try {
                            //se parse de período não funcionou então tenta identificar como um ano
                            editaAno.parse(tfFiltro.getText());
                            buscaAno = "%" + tfFiltro.getText() + "%";
                        } catch (ParseException ex2) {
                            //Se nenhum parse funcionou não se trata de uma data
                        }
                    }
                }
                
                listPagamentos = lPagamento.procuraRegistros("strDataReferencia LIKE ? OR codigoFicha = ? OR "
                        + "strDataReferencia LIKE ? OR strDataReferencia LIKE ? OR "
                        + "codigoFicha IN (SELECT codigo FROM Ficha WHERE codigo = codigoFicha AND "
                        + "intResponsavel IN (SELECT codigo FROM pessoa WHERE codigo = intResponsavel AND nome LIKE ?)) "
                        + "ORDER BY strDataReferencia", 
                        buscaData, tfFiltro.getText(), buscaPeriodo, buscaAno, buscaNome);
            }else{
                //Precisa do 1=1 para funcionar como um WHERE
                listPagamentos = lPagamento.procuraRegistros("1=1 ORDER BY strDataReferencia");
            }
            carregaGrid();
        } catch (DBMException ex) {
        }        
    }//GEN-LAST:event_tfFiltroFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        editaData = new SimpleDateFormat("dd/MM/yyyy");
        editaPeriodo = new SimpleDateFormat("MM/yyyy");
        editaAno = new SimpleDateFormat("yyyy");
        editaDataDigitada = new SimpleDateFormat("yyyy-MM-dd");
        editaPeriodoDigitado = new SimpleDateFormat("yyyy-MM");
        try {
            //para demais funções busca o registro no banco
            lPagamento = new DBMLocalizador<>(DBPagamento.class);
            listPagamentos = lPagamento.procuraRegistros("1=1 ORDER BY strDataReferencia");
            carregaGrid();
        } catch (DBMException e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void jExpXlsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jExpXlsActionPerformed
        File arqDestino = abreDestino();
        if(arqDestino == null)return;
        
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        Row row = sheet.createRow(0);
        TableModel model = tPagamentos.getModel();
            //Ignora última coluna pois não deve aparecer na listagem
        for (int i = 0; i < model.getColumnCount() - 1; i++) {
            row.createCell(i).setCellValue(model.getColumnName(i));
        }
        Object cell;
        for (int i = 0; i < model.getRowCount(); i++) {
            row = sheet.createRow(i + 1);
            //Ignora última coluna pois não deve aparecer na listagem
            for (int j = 0; j < model.getColumnCount() - 1; j++) {
                cell = model.getValueAt(i, j);
                if(cell instanceof Integer) row.createCell(j).setCellValue((Integer) cell);
                else if(cell instanceof Double) row.createCell(j).setCellValue((Double) cell);
                else row.createCell(j).setCellValue(cell.toString());
            }
        }
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(arqDestino);
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GridPagamentos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GridPagamentos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jExpXlsActionPerformed

    private File abreDestino() {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileSelectionMode( JFileChooser.FILES_ONLY );
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel", "xls");
        fileChooser.setSelectedFile(new File("pagamentos.xls"));
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showSaveDialog( null );
        if( result == JFileChooser.CANCEL_OPTION ) {
                return null;
        }
        File file = fileChooser.getSelectedFile();
        if(file.toString().substring(file.toString().length() - 4).equals(".xls")) return file;
        else return new File(fileChooser.getSelectedFile().toString() + ".xls");
    }	
    
    
    
    //Limpa a tabela caso existam registros
    private void limpaGrid(){
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
    }    

    private void carregaGrid(){
        if(listPagamentos != null){
            for(DBPagamento pag : listPagamentos){
                dtm.insertRow(tPagamentos.getRowCount(), toRow(pag));
            }
        }
    }

    private Object[] toRow(DBPagamento pag){
        Object[] dados = new Object[tPagamentos.getColumnCount()];
        dados[0] = pag.getCodigoFicha();
        dados[1] = pag.getFicha().getResponsavel().getNome();
        dados[2] = editaData.format(pag.getDataReferencia());
        dados[3] = pag.getValor();
        dados[4] = false;
        return dados;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GridPagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GridPagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GridPagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GridPagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GridPagamentos dialog = new GridPagamentos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jExpXls;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFiltro;
    private javax.swing.JTable tPagamentos;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
