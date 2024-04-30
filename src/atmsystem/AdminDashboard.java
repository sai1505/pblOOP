package atmsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AdminDashboard extends javax.swing.JFrame {

    public AdminDashboard() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jLabel1.setText("Bank Code");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, -1, -1));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jLabel2.setText("Bank Address");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, -1, -1));

        jTextField1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 170, -1));

        jTextField2.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 360, 170, -1));

        jButton1.setBackground(new java.awt.Color(255, 255, 102));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jButton1.setText("Debit card Details");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, -1, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 102));
        jButton2.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jButton2.setText("Logout");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, 150, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 102));
        jButton3.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jButton3.setText("ATM Details");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 470, -1, -1));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 30)); // NOI18N
        jLabel4.setText("Provide the following details : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("/home/saivenkat/NetBeansProjects/AtmSystem/src/resources/AdminDashboard.jpg")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(evt.getSource()==jButton3){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/saivenkat";
                String name = "sai2005";
                String pass = "sai@2005";
                Connection con = DriverManager.getConnection(url, name, pass);
                PreparedStatement pstmt=con.prepareStatement("select bankCode from admin where bankcode=?");
                pstmt.setString(1,jTextField1.getText());
                ResultSet rset = pstmt.executeQuery();
                String bankcode="";
                while(rset.next())
                {
                    bankcode=rset.getString("bankCode");
                }
                if("".equals(jTextField1.getText()) || "".equals(jTextField2.getText())){
                    JOptionPane.showMessageDialog(this,"The bankcode/location is not entered!!\nPlease try again!\n");
                }
                else if(bankcode.equals(jTextField1.getText())==false){
                    JOptionPane.showMessageDialog(this,"The entered bancode/location is incorrect!!\nPlease try again!\n");
                }
                else{
                    this.dispose();
                    ATMDetails obj=new ATMDetails();
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new ATMDetails().setVisible(true);
                        }
                    });
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(evt.getSource()==jButton2){
            this.dispose();
            MainScreenPage obj3=new MainScreenPage();
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreenPage().setVisible(true);
            }
        });
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(evt.getSource()==jButton1){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/saivenkat";
                String name = "sai2005";
                String pass = "sai@2005";
                Connection con = DriverManager.getConnection(url, name, pass);
                PreparedStatement pstmt=con.prepareStatement("select bankCode from admin where bankcode=?");
                pstmt.setString(1,jTextField1.getText());
                ResultSet rset = pstmt.executeQuery();
                String bankcode="";
                while(rset.next())
                {
                    bankcode=rset.getString("bankCode");
                }
                if("".equals(jTextField1.getText()) || "".equals(jTextField2.getText())){
                    JOptionPane.showMessageDialog(this,"The bankcode/location is not entered!!\nPlease try again!\n");
                }
                else if(bankcode.equals(jTextField1.getText())==false){
                    JOptionPane.showMessageDialog(this,"The entered bankcode/location is incorrect!!\nPlease try again!\n");
                }
                else{
                    this.dispose();
                    debitCardDetails obj=new debitCardDetails();
                    java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                    new debitCardDetails().setVisible(true);
                    }
                });
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        AdminDashboard obj=new AdminDashboard();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
