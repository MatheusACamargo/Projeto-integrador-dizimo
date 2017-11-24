/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import database.DBFicha;
import database.DBFichaPessoa;
import database.DBPessoa;
import dizimo.Funcao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 0132945
 */
public class TelaPessoasFicha extends javax.swing.JDialog {

    private ArrayList<DBFichaPessoa> aFichaPessoa;
    private DefaultTableModel dtm;
    private DBPessoa responsavel;
    private boolean OK;
    private DBFicha ficha;
    private DateFormat editaData;
    private Funcao fun;

    /**
     * Creates new form TelaPessoasFicha
     * @param parent
     * @param modal
     * @param aFichaPessoa
     */
    public TelaPessoasFicha(java.awt.Dialog parent, boolean modal, DBFicha ficha, ArrayList<DBFichaPessoa> aFichaPessoa, Funcao fun) {
        super(parent, modal);
        this.aFichaPessoa = aFichaPessoa;
        this.ficha = ficha;
        this.fun = fun;
        editaData = new SimpleDateFormat("dd/MM/yyyy");
        OK = false;
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tPessoasFicha = new javax.swing.JTable();
        pbIncluir = new javax.swing.JButton();
        pbExcluir = new javax.swing.JButton();
        pbOk = new javax.swing.JButton();
        pbAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pessoas da ficha");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tPessoasFicha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Pessoa", "Data Inicial", "Data Final"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tPessoasFicha);

        pbIncluir.setText("Incluir");
        pbIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbIncluirActionPerformed(evt);
            }
        });

        pbExcluir.setText("Excluir");
        pbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbExcluirActionPerformed(evt);
            }
        });

        pbOk.setText("OK");
        pbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbOkActionPerformed(evt);
            }
        });

        pbAlterar.setText("Alterar");
        pbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pbOk))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pbIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbExcluir)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pbIncluir)
                    .addComponent(pbExcluir)
                    .addComponent(pbAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pbOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pbIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbIncluirActionPerformed
        TelaVinculacao tVinculacao = new TelaVinculacao(this, true, Funcao.INCLUSAO, ficha, null, aFichaPessoa);
        tVinculacao.setVisible(true);
        if(tVinculacao.isOK()){
            aFichaPessoa.add(tVinculacao.getFichaPessoa());
            dtm.insertRow(tPessoasFicha.getRowCount(), toRow(tVinculacao.getFichaPessoa()));
        }
    }//GEN-LAST:event_pbIncluirActionPerformed

    private void pbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbExcluirActionPerformed
        int row = tPessoasFicha.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Selecione um registro na tabela abaixo primeiro!");
            return;
        }
        TelaVinculacao tVinculacao = new TelaVinculacao(this, true, Funcao.EXCLUSAO, ficha, aFichaPessoa.get(row), aFichaPessoa);
        tVinculacao.setVisible(true);
        if(tVinculacao.isOK()){
            aFichaPessoa.remove(row);
            dtm.removeRow(row);
        }
    }//GEN-LAST:event_pbExcluirActionPerformed

    private void pbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbOkActionPerformed
        OK = true;
        int row = tPessoasFicha.getSelectedRow();
        if(row != -1){
            responsavel = aFichaPessoa.get(tPessoasFicha.getSelectedRow()).getPessoa();
        }
        dispose();
    }//GEN-LAST:event_pbOkActionPerformed

    private void pbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbAlterarActionPerformed
        int row = tPessoasFicha.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Selecione um registro na tabela abaixo primeiro!");
            return;
        }
        TelaVinculacao tVinculacao = new TelaVinculacao(this, true, Funcao.ALTERACAO, ficha, aFichaPessoa.get(row), aFichaPessoa);
        tVinculacao.setVisible(true);
        if(tVinculacao.isOK()){
            dtm.removeRow(row);
            dtm.insertRow(row, toRow(tVinculacao.getFichaPessoa()));
        }
    }//GEN-LAST:event_pbAlterarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        dtm = (DefaultTableModel) tPessoasFicha.getModel();
        atualizaGrid();
        if(fun == Funcao.CONSULTA){
            pbIncluir.setEnabled(false);
            pbAlterar.setEnabled(false);
            pbExcluir.setEnabled(false);
            pbOk.setEnabled(false);
        }
    }//GEN-LAST:event_formWindowOpened

    private void atualizaGrid(){
        tPessoasFicha.removeAll();
        for (DBFichaPessoa fichaPessoa : aFichaPessoa) {
            dtm.insertRow(tPessoasFicha.getRowCount(), toRow(fichaPessoa));
        }
    }

    private Object[] toRow(DBFichaPessoa fichaPessoa){
        Object[] dados = new Object[tPessoasFicha.getColumnCount()];
        dados[0] = fichaPessoa.getPessoa().getNome();
        if(fichaPessoa.getDataInicial() != null){
            dados[1] = editaData.format(fichaPessoa.getDataInicial());            
        }
        if(fichaPessoa.getDataFinal() != null){
            dados[2] = editaData.format(fichaPessoa.getDataFinal());
        }
        return dados;
    }

    public DBPessoa getResponsavel(){
        return responsavel;
    }

    public boolean isOK (){
        return OK;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pbAlterar;
    private javax.swing.JButton pbExcluir;
    private javax.swing.JButton pbIncluir;
    private javax.swing.JButton pbOk;
    private javax.swing.JTable tPessoasFicha;
    // End of variables declaration//GEN-END:variables
}
