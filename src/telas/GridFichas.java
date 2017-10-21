/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import database.DBEndereco;
import database.DBFicha;
import database.DBMException;
import database.DBMLocalizador;
import database.DBPessoa;
import dizimo.Funcao;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lucas
 */
public class GridFichas extends javax.swing.JDialog {
    private DefaultTableModel dtm;
    private DBMLocalizador<DBFicha> loc;
    private DBPessoa pessoa;
    private DBMLocalizador<DBPessoa> lPessoa;
    private DBEndereco endereco;
    private DBMLocalizador<DBEndereco> lEndereco;
    
    private List<DBFicha> listFicha;



    /**
     * Creates new form GridFichas
     */
    public GridFichas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        dtm = (DefaultTableModel) tFichas.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pbConsultar = new javax.swing.JButton();
        pbExcluir = new javax.swing.JButton();
        lbFiltro = new javax.swing.JLabel();
        tfFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tFichas = new javax.swing.JTable();
        pbIncluir = new javax.swing.JButton();
        pbAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabela de fichas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pbConsultar.setText("Consultar");
        pbConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbConsultarActionPerformed(evt);
            }
        });

        pbExcluir.setText("Excluir");
        pbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbExcluirActionPerformed(evt);
            }
        });

        lbFiltro.setText("Filtro");

        tfFiltro.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfFiltroFocusLost(evt);
            }
        });
        tfFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfFiltroActionPerformed(evt);
            }
        });

        tFichas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número", "Responsável", "Endereço", "Observações"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tFichas);

        pbIncluir.setText("Incluir");
        pbIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbIncluirActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pbIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(lbFiltro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFiltro)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pbConsultar)
                    .addComponent(pbExcluir)
                    .addComponent(lbFiltro)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbIncluir)
                    .addComponent(pbAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pbConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbConsultarActionPerformed
        int row = tFichas.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Selecione um registro na tabela abaixo primeiro!");
            return;
        }
        TelaFicha tf = new TelaFicha(this, true, Funcao.CONSULTA, (int) tFichas.getValueAt(row, 0));
        tf.setVisible(true);
    }//GEN-LAST:event_pbConsultarActionPerformed

    private void pbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbExcluirActionPerformed
        int row = tFichas.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Selecione um registro na tabela abaixo primeiro!");
            return;
        }
        TelaFicha tf = new TelaFicha(this, true, Funcao.EXCLUSAO, (int) tFichas.getValueAt(row, 0));
        tf.setVisible(true);
        if(tf.isOK()){
            dtm.removeRow(row);
        }
    }//GEN-LAST:event_pbExcluirActionPerformed

    private void pbIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbIncluirActionPerformed
        TelaFicha tf = new TelaFicha(this, true, Funcao.INCLUSAO, 0);
        tf.setVisible(true);
        if(tf.isOK()){
            dtm.insertRow(tFichas.getRowCount(), toRow(tf.getFicha()));
        }
    }//GEN-LAST:event_pbIncluirActionPerformed

    private void pbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbAlterarActionPerformed
        int row = tFichas.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Selecione um registro na tabela abaixo primeiro!");
            return;
        }
        System.out.println((int) tFichas.getValueAt(tFichas.getSelectedRow(), 0) + "/n");
        TelaFicha tf = new TelaFicha(this, true, Funcao.ALTERACAO, (int) tFichas.getValueAt(tFichas.getSelectedRow(), 0));
        tf.setVisible(true);
        if(tf.isOK()){
            dtm.removeRow(row);
            dtm.insertRow(row, toRow(tf.getFicha()));
        }
    }//GEN-LAST:event_pbAlterarActionPerformed

    private void tfFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfFiltroActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            lPessoa = new DBMLocalizador<>(DBPessoa.class);
            lEndereco = new DBMLocalizador<>(DBEndereco.class);
            loc = new DBMLocalizador<>(DBFicha.class);
            listFicha = loc.procuraRegistros("");
            carregaGrid();
        } catch (DBMException e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void tfFiltroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfFiltroFocusLost
        try {
            limpaGrid();
            if(!tfFiltro.getText().isEmpty()){
                String busca = "%" + tfFiltro.getText() + "%";
                listFicha = loc.procuraRegistros("observacoes LIKE ? OR "
                        + "intResponsavel IN (SELECT codigo FROM Pessoa WHERE nome LIKE ? OR "
                        + "intEndereco IN (SELECT codigo FROM Endereco WHERE logradouro LIKE ?))", busca, busca, busca);
            }else{
                listFicha = loc.procuraRegistros("");
            }
            carregaGrid();
        } catch (DBMException ex) {
            Logger.getLogger(GridPessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tfFiltroFocusLost

    //Limpa a tabela caso existam registros
    private void limpaGrid(){
        if (dtm.getRowCount() > 0) {
            for (int i = dtm.getRowCount() - 1; i > -1; i--) {
                dtm.removeRow(i);
            }
        }
    }    
    
    private void carregaGrid(){
        if(listFicha != null){
            for(DBFicha ficha : listFicha){
                dtm.insertRow(tFichas.getRowCount(), toRow(ficha));
            }
        }
    }    
    
    private Object[] toRow(DBFicha ficha){
        Object[] dados = new Object[tFichas.getColumnCount()];
        dados[0] = ficha.getCodigo();
        dados[1] = ficha.getResponsavel().getNome();
        dados[2] = ficha.getResponsavel().getEndereco().getLogradouro();
        //Responsável
        //dados[1] = ficha.getLogradouro();
        //Endereço
        //dados[2] = ficha.getDescricaoComplementar();
        dados[3] = ficha.getObservacoes();
        return dados;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbFiltro;
    private javax.swing.JButton pbAlterar;
    private javax.swing.JButton pbConsultar;
    private javax.swing.JButton pbExcluir;
    private javax.swing.JButton pbIncluir;
    private javax.swing.JTable tFichas;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
