package atmsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class createProfile extends javax.swing.JFrame {

    public createProfile() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jLabel1.setText("Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jLabel2.setText("Address Location");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, -1, -1));

        jLabel3.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jLabel3.setText("Date OF Birth (dd-mm-yyyy)");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, -1, -1));

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jButton1.setText("Update");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 560, -1, -1));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 0, 32)); // NOI18N
        jLabel4.setText("Enter Profile Details : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, -1, -1));

        jTextField1.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 450, -1));

        jTextField2.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 450, -1));

        jTextField3.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 450, 450, -1));

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        jLabel6.setText(" User name (existing)");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, -1, -1));

        jTextField4.setFont(new java.awt.Font("Liberation Sans", 0, 23)); // NOI18N
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 450, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("/home/saivenkat/NetBeansProjects/AtmSystem/src/resources/createProfile.jpg")); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 770));

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
                PreparedStatement pstmt=con.prepareStatement("select username from users where username=?");
                pstmt.setString(1,jTextField4.getText());
                ResultSet rset = pstmt.executeQuery();
                String username1="";
                while(rset.next())
                {
                    username1=rset.getString("username");
                }
                if("".equals(jTextField1.getText()) || "".equals(jTextField2.getText()) ||"".equals(jTextField3.getText()) ||"".equals(jTextField4.getText())){
                    JOptionPane.showMessageDialog(this,"Required feilds are missing!!\nPlease try again!\n");
                }
                else if(username1.equals(jTextField4.getText())==false){
                    JOptionPane.showMessageDialog(this,"The entered username doesn't exist!!\nPlease try again!\n");
                }
                else{
                    pstmt=con.prepareStatement("update users set name=?,locationAddress=?,dateOfBirth=? where username=?");
                    pstmt.setString(1,jTextField1.getText());
                    pstmt.setString(2,jTextField2.getText());
                    pstmt.setString(3,jTextField3.getText());
                    pstmt.setString(4,jTextField4.getText());
                    pstmt.execute();
                    this.dispose();
                    UserDashboard obj=new UserDashboard();
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new UserDashboard().setVisible(true);
                        }
                    });
                } 
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(createProfile.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        createProfile obj=new createProfile();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
