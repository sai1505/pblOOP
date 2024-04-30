package atmsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Random;
import javax.swing.JOptionPane;

public class CreateAccount extends javax.swing.JFrame {

    public CreateAccount() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Serif", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREATE ACCOUNT");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 643, 149));

        jLabel2.setFont(new java.awt.Font("Mandali", 0, 25)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Username");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 140, 72));

        jLabel3.setFont(new java.awt.Font("Mandali", 0, 25)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("New Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 180, 59));

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setFont(new java.awt.Font("Liberation Sans", 0, 26)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Create");
        jButton2.setBorderPainted(false);
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 600, 140, 50));

        jLabel4.setFont(new java.awt.Font("Mandali", 0, 25)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Re-Enter Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, 250, 59));

        jPasswordField1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 190, -1));

        jPasswordField2.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 190, -1));

        jTextField1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 190, -1));

        jButton3.setBackground(new java.awt.Color(102, 102, 102));
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
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 130, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon("/home/saivenkat/NetBeansProjects/AtmSystem/src/resources/createAccount.jpg")); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (evt.getSource() == jButton2) {
            String username=jTextField1.getText();
            char[] password=jPasswordField1.getPassword();
            char[] repassword=jPasswordField2.getPassword();
            char[] empty="".toCharArray();
            String password1=String.valueOf(password);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/saivenkat";
                String name = "sai2005";
                String pass = "sai@2005";
                Connection con = DriverManager.getConnection(url, name, pass);
                PreparedStatement pstmt;
                pstmt=con.prepareStatement("select username from users where username=?");
                pstmt.setString(1,jTextField1.getText());
                ResultSet rset = pstmt.executeQuery();
                String username1="";
                Random rand=new Random();
                String cardnumber=Long.toString(rand.nextLong(10000000,99999999));
                String accountnumber=Long.toString(rand.nextLong(10000000,99999999));
                while(rset.next())
                {
                    username1=rset.getString("username");
                }
                if("".equals(username)){
                            JOptionPane.showMessageDialog(this,"The username/password/re-password is not entered\n");
                            jTextField1.setText("");
                }
                else if(username.equals(username1)){
                            JOptionPane.showMessageDialog(this,"This username already exists\n");
                            jTextField1.setText("");
                }
                else{
                    if(Arrays.equals(password, repassword)==false)
                    {
                        JOptionPane.showMessageDialog(this,"The entered Re-Passowrd is wrong");
                        jPasswordField1.setText("");
                        jPasswordField2.setText("");
                    }
                    else if(Arrays.equals(password, empty)==true){
                        JOptionPane.showMessageDialog(this,"Please enter the password");
                        jPasswordField1.setText("");
                        jPasswordField2.setText("");
                    }
                    else{
                        try {

                            if(username.equals(username1)){
                                JOptionPane.showMessageDialog(this,"This username already exists\n");
                                jTextField1.setText("");
                            }else{
                                String msg="ACCOUNT NUMBER : "+accountnumber+"\n\n"+"CARD NUMBER : "+cardnumber+"\n\n\n";
                                JOptionPane.showMessageDialog(this,msg);
                                this.dispose();
                                pstmt=con.prepareStatement("insert into users"+"(username,password,cardNumber,name,locationAddress,dateOfBirth,"
                                        + "accountNumber,saCredit,saDebit,caCredit,caDebit,countTransac,amount)"+"values "
                                        + "(?,?,?,?,?,?,?,?,?,?,?,?,?)");
                                pstmt.setString(1, username);
                                pstmt.setString(2, password1);
                                pstmt.setString(3, cardnumber);
                                pstmt.setString(4, "");
                                pstmt.setString(5, "");
                                pstmt.setString(6, "");
                                pstmt.setString(7, accountnumber);
                                pstmt.setInt(8, 0);
                                pstmt.setInt(9, 0);
                                pstmt.setInt(10, 0);
                                pstmt.setInt(11, 0);
                                pstmt.setInt(12, 0);
                                pstmt.setInt(13, 100000);
                                pstmt.execute();
                                con.close();
                            }
                        } catch (SQLException ex) {
                            Logger.getLogger(CreateAccount.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        MainScreenPage obj = new MainScreenPage();
                        java.awt.EventQueue.invokeLater(new Runnable() {
                            public void run() {
                                new MainScreenPage().setVisible(true);
                            }
                        });
                    }
                }
                }catch (ClassNotFoundException ex) {
                Logger.getLogger(CreateAccount.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CreateAccount.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(evt.getSource()==jButton3){
            this.dispose();
            MainScreenPage obj3=new MainScreenPage();
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new MainScreenPage().setVisible(true);
                }
            });
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    public static void main(String args[]) {
        CreateAccount obj = new CreateAccount();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new CreateAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
