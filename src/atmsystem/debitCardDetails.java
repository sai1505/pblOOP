package atmsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class debitCardDetails extends javax.swing.JFrame {

    public debitCardDetails() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Card Number");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 130, -1));

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("BACK");
        jButton3.setBorderPainted(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Check details");
        jButton1.setBorderPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 430, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Access account");
        jButton2.setBorderPainted(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Provide User DebitCard Details : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 550, -1));

        jTextField1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 200, -1));

        jTextField2.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 240, 200, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon("/home/saivenkat/NetBeansProjects/AtmSystem/src/resources/debitCardDetails.jpg")); // NOI18N
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
                PreparedStatement pstmt=con.prepareStatement("select name,locationAddress,dateOfBirth,cardNumber from users where cardNumber=?");
                pstmt.setString(1, jTextField2.getText());
                ResultSet rset = pstmt.executeQuery();
                String cardnumber1="";
                String checkname="";
                String locationaddress="";
                String dateofbirth="";
                while(rset.next()){
                    cardnumber1=rset.getString("cardNumber");
                    checkname=rset.getString("name");
                    locationaddress=rset.getString("locationAddress");
                    dateofbirth=rset.getString("dateOfBirth");
                }
                if("".equals(jTextField1.getText()) || "".equals(jTextField2.getText())){
                    JOptionPane.showMessageDialog(this,"The cardnumber/name is not entered!!\nPlease try again!\n");
                }
                else if(cardnumber1.equals(jTextField2.getText())==false){
                    
                    JOptionPane.showMessageDialog(this,"The cardnumber/name is incorrect!!\nPlease try again!\n");
                }
                else{
                    String msg="NAME : "+checkname+"\n\n"+"LOCATION : "+locationaddress+"\n\n"+"DATE OF BIRTH : "+dateofbirth+"\n\n\n";
                    JOptionPane.showMessageDialog(this,msg);
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(debitCardDetails.class.getName()).log(Level.SEVERE, null, ex);
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
                PreparedStatement pstmt=con.prepareStatement("select name,locationAddress,dateOfBirth,cardNumber from users where cardNumber=?");
                pstmt.setString(1, jTextField2.getText());
                ResultSet rset = pstmt.executeQuery();
                String cardnumber1="";
                String checkname="";
                String locationaddress="";
                String dateofbirth="";
                while(rset.next()){
                    cardnumber1=rset.getString("cardNumber");
                    checkname=rset.getString("name");
                    locationaddress=rset.getString("locationAddress");
                    dateofbirth=rset.getString("dateOfBirth");
                }
                if("".equals(jTextField1.getText()) || "".equals(jTextField2.getText())){
                    JOptionPane.showMessageDialog(this,"The cardnumber/name is not entered!!\nPlease try again!\n");
                }
                else if(cardnumber1.equals(jTextField2.getText())==false){
                    
                    JOptionPane.showMessageDialog(this,"The cardnumber/name is incorrect!!\nPlease try again!\n");
                }
                else{
                    this.dispose();
                    accessAccount obj=new accessAccount();
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new accessAccount().setVisible(true);
                        }
                    });
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(debitCardDetails.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(evt.getSource()==jButton3){
            this.dispose();
            AdminDashboard obj=new AdminDashboard();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new AdminDashboard().setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {
        debitCardDetails obj=new debitCardDetails();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new debitCardDetails().setVisible(true);
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
