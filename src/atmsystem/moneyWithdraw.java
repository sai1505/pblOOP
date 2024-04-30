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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class moneyWithdraw extends javax.swing.JFrame {

    public moneyWithdraw() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        jLabel1.setText("Account number");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, -1, -1));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 25)); // NOI18N
        jLabel2.setText("Amount");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 110, 40));

        jButton4.setBackground(new java.awt.Color(255, 102, 102));
        jButton4.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("BACK");
        jButton4.setBorderPainted(false);
        jButton4.setFocusable(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Withdraw");
        jButton3.setBorderPainted(false);
        jButton3.setFocusable(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 1, 35)); // NOI18N
        jLabel3.setText("WITHDRAW");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        jTextField1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 250, -1));

        jTextField2.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 250, -1));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jLabel6.setText("2. Only 10 transactions can be done here.");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 450, -1));

        jLabel5.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jLabel5.setText("Note : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, -1, -1));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jLabel7.setText("3. The maximum transaction amount is 30000/-");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 600, 510, -1));

        jLabel9.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jLabel9.setText("1. The transactions are limited here.");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, 450, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon("/home/saivenkat/NetBeansProjects/AtmSystem/src/resources/moneyWithdraw.jpg")); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusLost

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(evt.getSource()==jButton3){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/saivenkat";
                String name = "sai2005";
                String pass = "sai@2005";
                Connection con = DriverManager.getConnection(url, name, pass);
                PreparedStatement pstmt=con.prepareStatement("select accountNumber,amount,countTransac,saDebit from users where accountNumber=?");
                pstmt.setString(1, jTextField1.getText());
                ResultSet rset = pstmt.executeQuery();
                String accountnumber="";
                int amount=0;
                int count=0;
                int saDebit=0;
                while(rset.next()){
                    accountnumber=rset.getString("accountNumber");
                    amount=rset.getInt("amount");
                    count=rset.getInt("countTransac");
                    saDebit=rset.getInt("saDebit");
                }
                if("".equals(jTextField1.getText()) || "".equals(jTextField2.getText())){
                    JOptionPane.showMessageDialog(this,"The account number/amount is not entered!!\nPlease try again!\n");
                }
                else if(accountnumber.equals(jTextField1.getText())==false){
                    JOptionPane.showMessageDialog(this,"The account number is incorrect!!\nPlease try again!\n");
                }
                else{
                    if(Integer.parseInt(jTextField2.getText())>amount){
                        JOptionPane.showMessageDialog(this,"Insufficient Balance!!\nPlease try again!\n");
                    }
                    else if(Integer.parseInt(jTextField2.getText())>30000){
                        JOptionPane.showMessageDialog(this,"The transaction amount is limited!!\nPlease try again!\n");
                    }
                    else if(Integer.parseInt(jTextField2.getText())<0){
                        JOptionPane.showMessageDialog(this,"Invalid Entry!!\nPlease try again!\n");
                    }
                    else if(count>9){
                        JOptionPane.showMessageDialog(this,"Transaction count is ended!!Wait for next month!!\nPlease try again!\n");
                    }
                    else{
                        int amount1=amount-Integer.parseInt(jTextField2.getText());
                        count=count+1;
                        saDebit=saDebit+Integer.parseInt(jTextField2.getText());
                        String msg="WITHDRAW SUCESSFUL!!"+"\n\n"+" CURRENT BALANCE : "+amount1+"\n\n"+
                                "TRANSACTION COUNT : "+count+"\n\n\n";
                        JOptionPane.showMessageDialog(this,msg);
                        pstmt=con.prepareStatement("update users set amount=?,countTransac=?,saDebit=? where accountNumber=?");
                        pstmt.setString(1, String.valueOf(amount1));
                        pstmt.setString(2, String.valueOf(count));
                        pstmt.setString(3, String.valueOf(saDebit));
                        pstmt.setString(4, jTextField1.getText());
                        pstmt.execute();
                        LocalDate local=LocalDate.now();
                        DateTimeFormatter date3=DateTimeFormatter.ofPattern("dd-MM-YYYY");
                        String date1=date3.format(local);
                        pstmt=con.prepareStatement("insert into atm(accountNumber,date,transferAccountNumber,type,amount)"
                                + "values(?,?,?,?,?)");
                        pstmt.setInt(1, Integer.parseInt(jTextField1.getText()));
                        pstmt.setString(2, date1);
                        pstmt.setInt(3, 0);
                        pstmt.setString(4, "withdrawal");
                        pstmt.setInt(5, Integer.parseInt(jTextField2.getText()));
                        pstmt.execute();
                    }
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(moneyWithdraw.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(evt.getSource()==jButton4){
            this.dispose();
            userSavingAccount obj=new userSavingAccount();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new userSavingAccount().setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    public static void main(String args[]) {
        moneyWithdraw obj=new moneyWithdraw();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new moneyWithdraw().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
