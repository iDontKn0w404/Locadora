/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao.Consultar;

import DAO.*;
import Modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Will
 */
public class ConsultarFilme extends javax.swing.JFrame {

    /**
     * Creates new form ConsultarFilme
     */
    public ConsultarFilme() {
        initComponents();
        
        setTitle("Video Locadora");
        setSize(970, 380);
        AtualizaTable();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(this);
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
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jtTitulo = new javax.swing.JTextField();
        btTitulo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtCod = new javax.swing.JTextField();
        btCod = new javax.swing.JButton();
        btTodos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Filme", "Ano", "Duração", "Categoria", "Classificação"
            }
        ));
        jScrollPane1.setViewportView(jTable);

        jLabel1.setText("Pesquisa por título:");

        btTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.jpg"))); // NOI18N
        btTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTituloActionPerformed(evt);
            }
        });

        jLabel2.setText("Pesquisa por código");

        btCod.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/pesquisar.jpg"))); // NOI18N
        btCod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCodActionPerformed(evt);
            }
        });

        btTodos.setText("Todos");
        btTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTodosActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCod, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(btTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btTodos)
                    .addComponent(btCod, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTituloActionPerformed
        String titulo = jtTitulo.getText();
        Connection con = Conexao.AbrirConexao();
        FilmeDAO bd = new FilmeDAO(con);
        List<Filme> lista = new ArrayList<>();
        lista = bd.Pesquisar_Titulo_Filme(titulo);
        DefaultTableModel tbm =
                (DefaultTableModel) jTable.getModel();
        while (tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }            
        int i = 0;
        for (Filme tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getTitulo(), i, 1);
            jTable.setValueAt(tab.getAno(), i, 2);
            jTable.setValueAt(tab.getDuracao(), i, 3);
            jTable.setValueAt(tab.getCod_categoria(), i, 4);
            jTable.setValueAt(tab.getCod_classificacao(), i, 5);
            i++;
        
        }
        Conexao.FecharConexao(con);
    
    }//GEN-LAST:event_btTituloActionPerformed

    private void btTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTodosActionPerformed
        Connection con = Conexao.AbrirConexao();
        FilmeDAO bd = new FilmeDAO(con);
        List<Filme> lista = new ArrayList<>();
        lista = bd.ListarFilme();
        DefaultTableModel tbm =
                (DefaultTableModel) jTable.getModel();
        while (tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }
        int i = 0;
        for (Filme tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getTitulo(), i, 1);
            jTable.setValueAt(tab.getAno(), i, 2);
            jTable.setValueAt(tab.getDuracao(), i, 3);
            jTable.setValueAt(tab.getCod_categoria(), i, 4);
            jTable.setValueAt(tab.getCod_classificacao(), i, 5);
            i++;
        }
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_btTodosActionPerformed

    private void btCodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCodActionPerformed
        int cod = Integer.parseInt(jtCod.getText());
        Connection con = Conexao.AbrirConexao();
        FilmeDAO bd = new FilmeDAO(con);
        List<Filme> lista = new ArrayList<>();
        lista = bd.Pesquisar_Cod_Filme(cod);
        DefaultTableModel tbm =
                (DefaultTableModel) jTable.getModel();
        while (tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }            
        int i = 0;
        for (Filme tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getTitulo(), i, 1);
            jTable.setValueAt(tab.getAno(), i, 2);
            jTable.setValueAt(tab.getDuracao(), i, 3);
            jTable.setValueAt(tab.getCod_categoria(), i, 4);
            jTable.setValueAt(tab.getCod_classificacao(), i, 5);
            i++;
        
        }
        Conexao.FecharConexao(con);
    }//GEN-LAST:event_btCodActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultarFilme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCod;
    private javax.swing.JButton btTitulo;
    private javax.swing.JButton btTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jtCod;
    private javax.swing.JTextField jtTitulo;
    // End of variables declaration//GEN-END:variables

    private void AtualizaTable() {
        Connection con = Conexao.AbrirConexao();
        FilmeDAO bd = new FilmeDAO(con);
        List<Filme> lista = new ArrayList<>();
        lista = bd.ListarFilme();
        DefaultTableModel tbm =
                (DefaultTableModel) jTable.getModel();
        while (tbm.getRowCount() > 0){
            tbm.removeRow(0);
        }
        int i = 0;
        for (Filme tab : lista) {
            tbm.addRow(new String[i]);
            jTable.setValueAt(tab.getCodigo(), i, 0);
            jTable.setValueAt(tab.getTitulo(), i, 1);
            jTable.setValueAt(tab.getAno(), i, 2);
            jTable.setValueAt(tab.getDuracao(), i, 3);
            jTable.setValueAt(tab.getCod_categoria(), i, 4);
            jTable.setValueAt(tab.getCod_classificacao(), i, 5);
            i++;
        }
        Conexao.FecharConexao(con);
    }
}
