/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Locacao;

import DAO.*;
import Modelo.Aluguel;
import Modelo.Classificacao;
import Modelo.Cliente;
import Modelo.DVD;
import Modelo.Filme;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Will
 */
public class EfetuarDevolucao extends javax.swing.JFrame {

    /**
     * Creates new form EfetuarDevolucao
     */
    public EfetuarDevolucao() {
        initComponents();
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

        jLabel1 = new javax.swing.JLabel();
        jTF_Cod = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTF_CodD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTF_Filme = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTF_Cliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTF_Categoria = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTF_Classificacao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTF_Valor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTF_Locacao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTF_Devolucao = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTF_Horas = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbCapa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Código Aluguel:");

        jTF_Cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_CodActionPerformed(evt);
            }
        });

        jLabel2.setText("Código DVD:");

        jLabel3.setText("Filme:");

        jLabel4.setText("Cliente:");

        jLabel5.setText("Categoria:");

        jLabel6.setText("Classificação:");

        jLabel7.setText("Valor do Aluguel:");

        jLabel8.setText("Locação:");

        jTF_Locacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_LocacaoActionPerformed(evt);
            }
        });

        jLabel9.setText("Devolução:");

        jTF_Devolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTF_DevolucaoActionPerformed(evt);
            }
        });

        jLabel10.setText("Horas:");

        jButton1.setText("Devolver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbCapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/DVD_VIDEO_logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jButton1)
                        .addGap(64, 64, 64)
                        .addComponent(jButton2))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTF_Locacao, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTF_Devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel10)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTF_Horas))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_Classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTF_Filme, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                    .addComponent(jTF_Cliente)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(103, 103, 103)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTF_CodD, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addComponent(lbCapa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbCapa))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTF_Cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jTF_CodD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTF_Filme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jTF_Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTF_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jTF_Classificacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTF_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTF_Locacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jTF_Devolucao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jTF_Horas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTF_LocacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_LocacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_LocacaoActionPerformed

    private void jTF_DevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_DevolucaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTF_DevolucaoActionPerformed

    private void jTF_CodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTF_CodActionPerformed
        int cod = Integer.parseInt(jTF_Cod.getText());
        Connection con = Conexao.AbrirConexao();
        AluguelDAO sql = new AluguelDAO(con);
        if (sql.Testar_Aluguel(cod) == false) {
            JOptionPane.showMessageDialog(null, "Codigo não Encontrado no Banco",
                "Video Locadora", JOptionPane.ERROR_MESSAGE);
            Conexao.FecharConexao(con);
        }
        jTF_CodD.setText("");
        jTF_Filme.setText("");
        jTF_Categoria.setText("");
        jTF_Classificacao.setText("");
        jTF_Cliente.setText("");
        jTF_Valor.setText("");
        jTF_Locacao.setText("");
        jTF_Devolucao.setText("");
        jTF_Horas.setText("");

        InserirDados(cod);
    }//GEN-LAST:event_jTF_CodActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String codigo = jTF_Cod.getText();
        String nome = jTF_Filme.getText();
        String codigodvd = jTF_CodD.getText();
        Connection con = Conexao.AbrirConexao();
        AluguelDAO sql = new AluguelDAO(con);
        Aluguel a = new Aluguel();
        DVDDAO dvd = new DVDDAO(con);
        DVD c = new DVD();
        if (codigo.equals("")) {
            JOptionPane.showMessageDialog(null, "Nenhum Nome Selecionado",
                    "Video Locadora", JOptionPane.WARNING_MESSAGE);
        } else {
        int b = JOptionPane.showConfirmDialog(null, "Deseja realmente Devolver"
                + " \n ( " + codigo + " ) ( " + nome + " ) ", "Video Locadora",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (b == 0) {
                int cod = Integer.parseInt(codigo);
                int coddvd = Integer.parseInt(codigodvd);
                a.setCod(cod);
                String situacao = "Disponivel";
                c.setCodigo(coddvd);
                c.setSituacao(situacao);
                dvd.Atualizar_Situacao(c);
                sql.Excluir_Aluguel(a);
                Conexao.FecharConexao(con);
                dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(EfetuarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EfetuarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EfetuarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EfetuarDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EfetuarDevolucao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTF_Categoria;
    private javax.swing.JTextField jTF_Classificacao;
    private javax.swing.JTextField jTF_Cliente;
    private javax.swing.JTextField jTF_Cod;
    private javax.swing.JTextField jTF_CodD;
    private javax.swing.JTextField jTF_Devolucao;
    private javax.swing.JTextField jTF_Filme;
    private javax.swing.JTextField jTF_Horas;
    private javax.swing.JTextField jTF_Locacao;
    private javax.swing.JTextField jTF_Valor;
    private javax.swing.JLabel lbCapa;
    // End of variables declaration//GEN-END:variables

//    private void InserirDados(int cod) {
//        
//        Connection con = Conexao.AbrirConexao();
//        AluguelDAO sql = new AluguelDAO(con);
//        List<Aluguel> lista = new ArrayList<>();
//        lista = sql.CapturarAluguel(cod);
//        
//        for (Aluguel a : lista) {
//            
//            jTF_Cod.setText("" + a.getCodigo());
//            jTF_CodD.setText(a.getNome());
//            jTF_CEP.setText(a.getCEP());
//            jTF_Numero.setText("" + a.getNumero());
//            jTF_Bairro.setText(a.getBairro());
//            jTF_Email.setText(a.getEmail());
//            jTF_Telefone.setText(a.getTelefone());
//            jTF_Rua.setText(a.getRua());
//            jTF_Nascimento.setText(a.getNascimento());
//            jTF_RG.setText(a.getRG());
//            jTF_CPF.setText(a.getCPF());
//            
//        }
//        
//        Conexao.FecharConexao(con);
//    }
    

    private void InserirDados(int cod) {
        
        Connection con = Conexao.AbrirConexao();
        DVDDAO dvd = new DVDDAO(con);
        FilmeDAO filme = new FilmeDAO(con);
        AluguelDAO aluguel = new AluguelDAO(con);
        ClienteDAO cliente = new ClienteDAO(con);
        List<DVD> listaDVD = new ArrayList<>();
        List<Filme> listaFIL = new ArrayList<>();
        List<Aluguel> listaAlu = new ArrayList<>();
        List<Cliente> listaCli = new ArrayList<>();
        listaAlu = aluguel.CapturarAluguel(cod);
        for (Aluguel a : listaAlu) {
            jTF_Horas.setText("" + a.getHorario());
            jTF_Devolucao.setText("" + a.getData_devolucao());
            jTF_Locacao.setText("" + a.getData_aluguel());
            jTF_CodD.setText("" + a.getCoddvd());
           
        listaCli = cliente.Pesquisar_Cod_Cliente(a.getCodcliente());
        for (Cliente d : listaCli) {
            jTF_Cliente.setText("" + d.getNome());
        }
        
        listaDVD = dvd.ListarCodFilme(a.getCoddvd());
        for (DVD b : listaDVD) {
        listaFIL = filme.Pesquisar_Cod_Filme(b.getCod_filme());
        }
        }
        
        for (Filme c : listaFIL) {
            jTF_Filme.setText(c.getTitulo());
            jTF_Categoria.setText("" + c.getCod_categoria());
            jTF_Classificacao.setText("" + c.getCod_classificacao());
            lbCapa.setIcon(new ImageIcon 
        ("/C:/Users/Will/Documents/NetBeansProjects/Locadora/src/imagens/"+ c.getCapa() + "/"));
        }
        
        ClassificacaoDAO cla = new ClassificacaoDAO(con);
        List<Classificacao> listaCLA = new ArrayList<>();
        String b = jTF_Classificacao.getText();
        int codigo = Integer.parseInt(b);
        listaCLA = cla.ListarPrecoClassificacao(codigo);
        for (Classificacao a : listaCLA) {
            double preco = a.getPreco();
            jTF_Valor.setText("" + preco + "0");
        }
        
        Conexao.FecharConexao(con);
    }
    

}
