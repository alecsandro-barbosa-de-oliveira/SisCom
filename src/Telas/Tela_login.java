/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import com.mysql.jdbc.Driver;
import java.awt.event.KeyEvent;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alex
 */
public class Tela_login extends javax.swing.JFrame {

    /**
     * Creates new form Tela_login
     */
    public Tela_login() {
        initComponents();
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
        jLabel2 = new javax.swing.JLabel();
        jTextField_login = new javax.swing.JTextField();
        jPasswordField_senha = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Login");

        jLabel1.setText("Login:");

        jLabel2.setText("Senha:");

        jTextField_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_loginKeyPressed(evt);
            }
        });

        jPasswordField_senha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField_senhaKeyPressed(evt);
            }
        });

        jButton1.setText("Conectar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_login))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(95, 95, 95)
                                .addComponent(jButton2))
                            .addComponent(jPasswordField_senha, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField_login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField_senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(89, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(488, 416));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(jTextField_login.getText().equals("")|| jPasswordField_senha.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Preencha os campos obrigatorios!");
        }else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/siscon?useSSL=false","root","root");
                String query = "SELECT * FROM usuario where login='"+jTextField_login.getText()+"'";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                if (jTextField_login.getText().equals(login)&& jPasswordField_senha.getText().equals(senha)){
                    
                    Principal tela_princi = new Principal();
                    tela_princi.setExtendedState(Principal.MAXIMIZED_BOTH);
                    tela_princi.setVisible(true);
                    dispose();
                
                }else{
                
                    JOptionPane.showMessageDialog(this, "Senha ivalida!");
                    
                }
                stmt.close();
                conn.close();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Tela_login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Falha na conexao do class for name");
            } catch (SQLException ex) {
                Logger.getLogger(Tela_login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Usuario não cadastrado");
            }
        
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPasswordField_senhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField_senhaKeyPressed
       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){ 
        
        if(jTextField_login.getText().equals("")|| jPasswordField_senha.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Preencha os campos obrigatorios!");
        }else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/siscon?useSSL=false","root","root");
                String query = "SELECT * FROM usuario where login='"+jTextField_login.getText()+"'";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                if (jTextField_login.getText().equals(login)&& jPasswordField_senha.getText().equals(senha)){
                    
                    Principal tela_princi = new Principal();
                    tela_princi.setExtendedState(Principal.MAXIMIZED_BOTH);
                    tela_princi.setVisible(true);
                    dispose();
                
                }else{
                
                    JOptionPane.showMessageDialog(this, "Senha ivalida!");
                    
                }
                stmt.close();
                conn.close();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Tela_login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Falha na conexao do class for name");
            } catch (SQLException ex) {
                Logger.getLogger(Tela_login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Usuario não cadastrado");
            }
        
        }
        }
        
    }//GEN-LAST:event_jPasswordField_senhaKeyPressed

    private void jTextField_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_loginKeyPressed
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){ 
        
        if(jTextField_login.getText().equals("")|| jPasswordField_senha.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Preencha os campos obrigatorios!");
        }else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/siscon?useSSL=false","root","root");
                String query = "SELECT * FROM usuario where login='"+jTextField_login.getText()+"'";
                PreparedStatement stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery(query);
                rs.next();
                String login = rs.getString("login");
                String senha = rs.getString("senha");
                if (jTextField_login.getText().equals(login)&& jPasswordField_senha.getText().equals(senha)){
                    
                    Principal tela_princi = new Principal();
                    tela_princi.setExtendedState(Principal.MAXIMIZED_BOTH);
                    tela_princi.setVisible(true);
                    dispose();
                
                }else{
                
                    JOptionPane.showMessageDialog(this, "Senha ivalida!");
                    
                }
                stmt.close();
                conn.close();
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Tela_login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Falha na conexao do class for name");
            } catch (SQLException ex) {
                Logger.getLogger(Tela_login.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Usuario não cadastrado");
            }
        
        }
        }
        
        
    }//GEN-LAST:event_jTextField_loginKeyPressed

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
            java.util.logging.Logger.getLogger(Tela_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jPasswordField_senha;
    private javax.swing.JTextField jTextField_login;
    // End of variables declaration//GEN-END:variables
}
