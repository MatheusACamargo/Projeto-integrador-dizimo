/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import database.DBEndereco;
import database.DBMException;
import database.DBMLocalizador;
import database.DBPessoa;
import dizimo.Funcao;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class GridPessoas extends javax.swing.JDialog {
    private DefaultTableModel dtm;
    private DBMLocalizador<DBPessoa> lPessoa;
    private Funcao fun;
    private List<DBPessoa> listPes;
    private DBPessoa pessoa;
    private boolean selected;


    /**
     * Creates new form GridPessoas
     */
    public GridPessoas(java.awt.Frame parent, boolean modal, Funcao fun) {
        super(parent, modal);
        this.fun = fun;
        initComponents();
        dtm = (DefaultTableModel) tPessoas.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfFiltro = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPessoas = new javax.swing.JTable();
        btIncluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btSelecionar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabela de Pessoas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Filtro");

        tfFiltro.setText(" ");

        tPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome ", "Endereço", "Ficha Atual"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tPessoas);

        btIncluir.setText("Incluir");
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btSelecionar.setText("Selecionar");
        btSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSelecionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btConsultar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFiltro, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                    .addComponent(btSelecionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btIncluir)
                    .addComponent(btAlterar)
                    .addComponent(btConsultar)
                    .addComponent(btExcluir)
                    .addComponent(jLabel1)
                    .addComponent(tfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSelecionar))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed
        TelaPessoa tp = new TelaPessoa(this, true, Funcao.INCLUSAO, 0);
        tp.setVisible(true);
        if(tp.isOK()){
            dtm.insertRow(tPessoas.getRowCount(), toRow(tp.getPes()));
        }
    }//GEN-LAST:event_btIncluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        int row = tPessoas.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Selecione um registro na tabela abaixo primeiro!");
            return;
        }
        TelaPessoa tp = new TelaPessoa(this, true, Funcao.ALTERACAO, (int) tPessoas.getValueAt(row, 0));
        tp.setVisible(true);
        if(tp.isOK()){
            dtm.removeRow(row);
            dtm.insertRow(row, toRow(tp.getPes()));
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        int row = tPessoas.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Selecione um registro na tabela abaixo primeiro!");
            return;
        }
        TelaPessoa tp = new TelaPessoa(this, true, Funcao.CONSULTA, (int) tPessoas.getValueAt(row, 0));
        tp.setVisible(true);
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int row = tPessoas.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Selecione um registro na tabela abaixo primeiro!");
            return;
        }
        TelaPessoa tp = new TelaPessoa(this, true, Funcao.EXCLUSAO, (int) tPessoas.getValueAt(row, 0));
        tp.setVisible(true);
        if(tp.isOK()){
            dtm.removeRow(row);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            //para demais funções busca o registro no banco
            lPessoa = new DBMLocalizador<>(DBPessoa.class);
            listPes = lPessoa.procuraRegistros("");
            if(listPes != null){
                for(DBPessoa pes : listPes){
                    dtm.insertRow(tPessoas.getRowCount(), toRow(pes));
                }
            }
        } catch (DBMException e) {
        }
        if(fun != Funcao.PESQUISA){
            btSelecionar.setVisible(false);
        }else{
            selected = false;
        }
    }//GEN-LAST:event_formWindowOpened

    private void btSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSelecionarActionPerformed
        int row = tPessoas.getSelectedRow();
        if(row == -1){
            JOptionPane.showMessageDialog(this, "Selecione um registro na tabela acima!");
            return;
        }
        int codigo = (int) tPessoas.getValueAt(row, 0);
        for(DBPessoa pes : listPes){
            if(pes.getCodigo() == codigo){
                pessoa = pes;
                break;
            }
        }
    }//GEN-LAST:event_btSelecionarActionPerformed

    private Object[] toRow(DBPessoa pes){
        DBEndereco end = pes.getEndereco();
        Object[] dados = new Object[tPessoas.getColumnCount()];
        dados[0] = pes.getCodigo();
        dados[1] = pes.getNome();
        if (end != null){
            dados[2] = end.getLogradouro();
        }
        dados[3] = pes.getNumFichaAtual();
        return dados;
    }

    public DBPessoa getPessoa() {
        return pessoa;
    }

    public boolean isSelected() {
        return selected;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btIncluir;
    private javax.swing.JButton btSelecionar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tPessoas;
    private javax.swing.JTextField tfFiltro;
    // End of variables declaration//GEN-END:variables
}
