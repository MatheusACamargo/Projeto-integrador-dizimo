/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import database.DBFicha;
import database.DBFichaPessoa;
import database.DBMException;
import database.DBMLocalizador;
import database.DBPessoa;
import dizimo.Funcao;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.text.NumberFormatter;
import sun.awt.CausedFocusEvent;

/**
 *
 * @author 0132945
 */
public class TelaVinculacao extends javax.swing.JDialog {
    private Funcao fun;
    private DBFichaPessoa fichaPessoa;
    private DBMLocalizador<DBPessoa> lPessoa;
    private DBMLocalizador<DBFichaPessoa> lFichaPessoa;

    private DBPessoa pessoa;
    private DBFicha ficha;
    private ArrayList<DBFichaPessoa> aFichaPessoa;
    private ArrayList<DBFichaPessoa> aFichaPessoa_vinculos;

    private boolean OK;
    
    /**
     * Creates new form TelaVinculacao
     */
    public TelaVinculacao(java.awt.Dialog parent, boolean modal, Funcao fun, DBFicha ficha, DBFichaPessoa fichaPessoa, ArrayList<DBFichaPessoa> aFichaPessoa) {
        super(parent, modal);
        this.fun = fun;
        this.fichaPessoa = fichaPessoa;
        this.ficha = ficha;
        this.aFichaPessoa = aFichaPessoa;
        OK = false;
        try {     
            lPessoa = new DBMLocalizador<>(DBPessoa.class);
            lFichaPessoa = new DBMLocalizador<>(DBFichaPessoa.class);
        } catch (DBMException ex) {
            Logger.getLogger(TelaVinculacao.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        lbDataInicial = new javax.swing.JLabel();
        lbDataFinal = new javax.swing.JLabel();
        ftDataFinal = new javax.swing.JFormattedTextField();
        pbOk = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ftDataInicial = new javax.swing.JFormattedTextField();
        pbBuscar = new javax.swing.JButton();
        tfNomePessoa = new javax.swing.JTextField();
        tfPessoa = new javax.swing.JFormattedTextField(new NumberFormatter(NumberFormat.getInstance()));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vinculação de pessoa na ficha");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lbDataInicial.setText("Data Inicial");

        lbDataFinal.setText("Data Final");

        ftDataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        ftDataFinal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftDataFinalFocusLost(evt);
            }
        });

        pbOk.setText("OK");
        pbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbOkActionPerformed(evt);
            }
        });

        jLabel1.setText("Pessoa");

        ftDataInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        ftDataInicial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftDataInicialFocusLost(evt);
            }
        });

        pbBuscar.setText("Buscar");
        pbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pbBuscarActionPerformed(evt);
            }
        });

        tfNomePessoa.setEditable(false);
        tfNomePessoa.setFocusable(false);

        tfPessoa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        tfPessoa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfPessoaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lbDataInicial)
                    .addComponent(lbDataFinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tfPessoa)
                    .addComponent(ftDataInicial, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ftDataFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomePessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pbBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(pbOk)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(pbBuscar)
                    .addComponent(tfNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDataInicial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDataFinal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pbOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbBuscarActionPerformed
        GridPessoas gPessoas = new GridPessoas(this, true, Funcao.PESQUISA);
        gPessoas.setVisible(true);
        if(gPessoas.getPessoa()!=null){
            pessoa = gPessoas.getPessoa();
            tfPessoa.setText(pessoa.getCodigo().toString());
            tfNomePessoa.setText(pessoa.getNome());
            fichaPessoa.setPessoa(pessoa);
        }
    }//GEN-LAST:event_pbBuscarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(fun==Funcao.INCLUSAO){
            fichaPessoa = new DBFichaPessoa();
            fichaPessoa.setFicha(ficha);
        //Busca ano atual
            fichaPessoa.setDataInicial(Calendar.getInstance().getTime());
        }else{
            pessoa = fichaPessoa.getPessoa();
            tfPessoa.setText(pessoa.getCodigo().toString());
            tfNomePessoa.setText(pessoa.getNome());
        }
        ftDataInicial.setValue(fichaPessoa.getDataInicial());
        ftDataFinal.setValue(fichaPessoa.getDataFinal());
        if(fun==Funcao.ALTERACAO){
            tfPessoa.setEnabled(false);
            pbBuscar.setEnabled(false);
        }
        ftDataInicial.setValue(fichaPessoa.getDataInicial());
        ftDataFinal.setValue(fichaPessoa.getDataFinal());
    }//GEN-LAST:event_formWindowOpened

    private void tfPessoaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfPessoaFocusLost
        if(evt.isTemporary())return;
        if(((CausedFocusEvent) evt).getCause() == CausedFocusEvent.Cause.CLEAR_GLOBAL_FOCUS_OWNER)return;
        if(tfPessoa.getText().isEmpty()){
            tfPessoa.setValue(null);
            fichaPessoa.setPessoa(null);
            return;
        }
        int codigoPessoa = Integer.parseInt(tfPessoa.getText());
        try {
            pessoa = lPessoa.procuraRegistro(codigoPessoa);
            if(pessoa == null){
                JOptionPane.showMessageDialog(this, "Pessoa de código " + codigoPessoa + " não foi lida corretamente do banco!");
                tfPessoa.requestFocus();
                return;
            }else{
                if(pessoa.getNumFichaAtual() != 0){
                    JOptionPane.showMessageDialog(this, "Pessoa de código " + codigoPessoa + " ainda está cadastrada na ficha " + pessoa.getNumFichaAtual() + "!");
                    tfPessoa.requestFocus();
                    return;
                }
                tfNomePessoa.setText(pessoa.getNome());
                fichaPessoa.setPessoa(pessoa);
            }
        } catch (DBMException ex) {
            Logger.getLogger(TelaVinculacao.class.getName()).log(Level.SEVERE, null, ex);
        }                
        
        for(DBFichaPessoa ficpes : aFichaPessoa){
            if(ficpes.getIntDBPessoa() == codigoPessoa){
                JOptionPane.showMessageDialog(this, "Pessoa de código " + codigoPessoa + " já está informada para esta ficha!");
                tfPessoa.requestFocus();

            }
        }
        
    }//GEN-LAST:event_tfPessoaFocusLost

    private void pbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pbOkActionPerformed
        OK = true;
        fichaPessoa.setDataInicial((Date)ftDataInicial.getValue());
        fichaPessoa.setDataFinal((Date)ftDataFinal.getValue());
        if(fichaPessoa.getPessoa() == null){
            JOptionPane.showMessageDialog(this, "Pessoa deve ser informada!");
            ftDataInicial.requestFocus();
            return;
        }
        if(fichaPessoa.getDataInicial()== null){
            JOptionPane.showMessageDialog(this, "Data inicial deve ser informada!");
            ftDataInicial.requestFocus();
            return;
        }
        if(fichaPessoa.getDataFinal() != null && fichaPessoa.getDataFinal().before(fichaPessoa.getDataInicial())){
            JOptionPane.showMessageDialog(this, "Data final não pode ser anterior à data inicial!");
            ftDataFinal.requestFocus();
            return;
        }
        try {
            aFichaPessoa_vinculos = lFichaPessoa.procuraRegistros(
                                            "intDBPessoa = ? AND intFicha != ? AND "
                                          + "((strDataInicial <= ? AND (strDataFinal >= ? OR strDataFinal = '')) OR "
                                          + "(strDataInicial > ? AND (strDataFinal < ? OR ? = '')))",
                                          fichaPessoa.getPessoa().getCodigo(),
                                          fichaPessoa.getFicha().getCodigo(),
                                          fichaPessoa.getStrDataInicial(),
                                          fichaPessoa.getStrDataInicial(),
                                          fichaPessoa.getStrDataInicial(),
                                          fichaPessoa.getStrDataFinal(),
                                          fichaPessoa.getStrDataFinal()
            );
            if(aFichaPessoa_vinculos!=null && !aFichaPessoa_vinculos.isEmpty()){
                JOptionPane.showMessageDialog(this, "Pessoa já está na ficha " + aFichaPessoa_vinculos.get(0).getIntFicha() + " no período entre " + aFichaPessoa_vinculos.get(0).getStrDataInicial()+ " e " + aFichaPessoa_vinculos.get(0).getStrDataFinal() + "!");
                ftDataInicial.requestFocus();
                return;
            }
        } catch (DBMException ex) {
            Logger.getLogger(TelaVinculacao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        dispose();
    }//GEN-LAST:event_pbOkActionPerformed

    private void ftDataInicialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftDataInicialFocusLost
        if(ftDataInicial.getText().isEmpty()){
            ftDataInicial.setValue(null);
            fichaPessoa.setDataInicial(null);
        }
    }//GEN-LAST:event_ftDataInicialFocusLost

    private void ftDataFinalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftDataFinalFocusLost
        if(ftDataFinal.getText().isEmpty()){
            ftDataFinal.setValue(null);
            fichaPessoa.setDataFinal(null);
        }
    }//GEN-LAST:event_ftDataFinalFocusLost
    
    public DBFichaPessoa getFichaPessoa(){
        return fichaPessoa;
    }
    
    public boolean isOK(){
        return OK;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField ftDataFinal;
    private javax.swing.JFormattedTextField ftDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbDataFinal;
    private javax.swing.JLabel lbDataInicial;
    private javax.swing.JButton pbBuscar;
    private javax.swing.JButton pbOk;
    private javax.swing.JTextField tfNomePessoa;
    private javax.swing.JFormattedTextField tfPessoa;
    // End of variables declaration//GEN-END:variables
}
