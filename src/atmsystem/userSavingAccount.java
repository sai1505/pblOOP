/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package atmsystem;

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
 * @author saivenkat
 */
public class userSavingAccount extends javax.swing.JFrame {
    public userSavingAccount() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        jLabel1.setText("Account Number");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        jTextField1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 220, 180, 40));

        jButton3.setBackground(new java.awt.Color(255, 255, 204));
        jButton3.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jButton3.setText("BACK");
        jButton3.setBorderPainted(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jButton1.setText("Withdraw");
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 204));
        jButton2.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jButton2.setText("Transfer");
        jButton2.setBorderPainted(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, -1, -1));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("SAVING ACCOUNT");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("/home/saivenkat/NetBeansProjects/AtmSystem/src/resources/userSavingAccount.jpg")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(evt.getSource()==jButton1){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/saivenkat";
                String name = "sai2005";
                String pass = "sai@2005";
                Connection con = DriverManager.getConnection(url, name, pass);
                PreparedStatement pstmt=con.prepareStatement("select accountNumber from users where accountNumber=?");
                pstmt.setString(1, jTextField1.getText());
                ResultSet rset = pstmt.executeQuery();
                String accountnumber="";
                while(rset.next()){
                    accountnumber=rset.getString("accountNumber");
                }
                if("".equals(jTextField1.getText())){
                    JOptionPane.showMessageDialog(this,"The account number is not entered!!\nPlease try again!\n");
                }
                else if(accountnumber.equals(jTextField1.getText())==false){
                    JOptionPane.showMessageDialog(this,"The account number is incorrect!!\nPlease try again!\n");
                }
                else{
                    this.dispose();
                    moneyWithdraw obj=new moneyWithdraw();
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new moneyWithdraw().setVisible(true);
                        }
                    });
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(userSavingAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(evt.getSource()==jButton2){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/saivenkat";
                String name = "sai2005";
                String pass = "sai@2005";
                Connection con = DriverManager.getConnection(url, name, pass);
                PreparedStatement pstmt=con.prepareStatement("select accountNumber from users where accountNumber=?");
                pstmt.setString(1, jTextField1.getText());
                ResultSet rset = pstmt.executeQuery();
                String accountnumber="";
                while(rset.next()){
                    accountnumber=rset.getString("accountNumber");
                }
                if("".equals(jTextField1.getText())){
                    JOptionPane.showMessageDialog(this,"The account number is not entered!!\nPlease try again!\n");
                }
                else if(accountnumber.equals(jTextField1.getText())==false){
                    JOptionPane.showMessageDialog(this,"The account number is incorrect!!\nPlease try again!\n");
                }
                else{
                    this.dispose();
                    moneyTransfer obj=new moneyTransfer();
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new moneyTransfer().setVisible(true);
                        }
                    });
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(userSavingAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(evt.getSource()==jButton3){
            this.dispose();
            UserDashboard obj=new UserDashboard();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new UserDashboard().setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        userSavingAccount obj=new userSavingAccount();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userSavingAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
