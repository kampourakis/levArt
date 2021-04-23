/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sirag
 */
public class View_Reservation extends javax.swing.JFrame {
String room;
    /**
     * Creates new form View_Reservation
     */
    public View_Reservation() {
        initComponents();
        show_user();
        jTextField_id.setEditable(false);
    }
    
    public ArrayList<User> userList(){
        ArrayList<User> usersList = new ArrayList<>();
        
        try{
            String myDriver = "com.mysql.cj.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/hotel_system";
            Class.forName(myDriver);
            Connection con = DriverManager.getConnection(myUrl, "root", "");
                         
            String query ="SELECT * FROM reservations";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            User user;
            while(rs.next()){
                user=new User(rs.getInt("id"), rs.getString("first_name"),rs.getString("last_name"),rs.getString("email"),rs.getString("check_in"),rs.getString("check_out"),rs.getString("Persons"),rs.getString("Room_Type"));
                usersList.add(user);
                
            }
        
        }
        
        catch (Exception e)
            {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            }
        
        return usersList;
        }
    
    public void show_user(){
        ArrayList<User> list = userList();
        DefaultTableModel model = (DefaultTableModel)jTable_Display.getModel();
        Object[] row = new Object[8];
        for(int i=0; i<list.size(); i++)
        {
            row[0] = list.get(i).getid();
            row[1] = list.get(i).getfname();
            row[2] = list.get(i).getlname();
            row[3] = list.get(i).getemail();
            row[4] = list.get(i).getcheck_in();
            row[5] = list.get(i).getcheck_out();
            row[6] = list.get(i).getpersons();
            row[7] = list.get(i).gettype();
            model.addRow(row);
        }
        
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
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display = new javax.swing.JTable();
        jTextField_lname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField_fname = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooser_In = new com.toedter.calendar.JDateChooser();
        jDateChooser_Out = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSpinner_persons = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jTextField_id = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jRadioButton_Luxury = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        jRadioButton_Standard = new javax.swing.JRadioButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("VIEW RESERVATION");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(459, 459, 459)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(27, 27, 27))
        );

        jTable_Display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reservation Code", "First Name", "Last Name", "Email", "Check In", "Check Out", "Persons", "Room Type"
            }
        ));
        jTable_Display.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_DisplayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("No.Of Persons:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Last Name:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Check In:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Check Out:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Change Your Reservation Info!");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("First Name:");

        jButton1.setBackground(new java.awt.Color(51, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Update Reservation");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Your Reservation id is: ");

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton_Luxury);
        jRadioButton_Luxury.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton_Luxury.setText("Luxury Room");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Type of Room:");

        buttonGroup1.add(jRadioButton_Standard);
        jRadioButton_Standard.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton_Standard.setText("Standard Room");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(150, 150, 150)
                                                .addComponent(jRadioButton_Standard))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(181, 181, 181)
                                                .addComponent(jRadioButton_Luxury)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSpinner_persons, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser_Out, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser_In, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(45, 45, 45)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)))))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 636, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_fname, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_lname, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSpinner_persons, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel6)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel8))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jDateChooser_In, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser_Out, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(jButton2)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jRadioButton_Standard)
                                        .addComponent(jRadioButton_Luxury)))
                                .addGap(57, 57, 57))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        
        
         String fname = jTextField_fname.getText();
         String lname = jTextField_lname.getText();
         String email = jTextField_email.getText();
         String check_in = (df.format(jDateChooser_In.getDate()));
         String check_out = (df.format(jDateChooser_Out.getDate()));
         int persons = (Integer) jSpinner_persons.getValue();
         String id = jTextField_id.getText();
         String str1 = Integer.toString(persons);
         
          if(jRadioButton_Standard.isSelected()){
                         room = "Standard";
                     }
          if(jRadioButton_Luxury.isSelected()){
                         room = "Luxury";
                     }
                  
         if(verifyFields())
         {  

             PreparedStatement ps ;
                 ResultSet rs; 
                 //String registerUserQuery = "INSERT INTO `reservations`(`first_name`, `last_name`, `email`, `check_in`, `check_out`, `Persons`) VALUES (?,?,?,?,?,?)";
                 String registerUserQuery = "UPDATE reservations SET first_name = ?, last_name = ?, email=? , check_in = ? , check_out=?, Persons=?, Room_Type=? WHERE id =?";
                 try {
                     ps = My_CNX.getConnection().prepareStatement(registerUserQuery);
                     
                     ps.setString(1, fname);
                     ps.setString(2, lname);
                     ps.setString(3, email);
                     ps.setString(4, check_in);
                     ps.setString(5, check_out);
                     ps.setString(6, str1);
                     ps.setString(7,room);
                     ps.setString(8, id);
                     if(ps.executeUpdate() != 0)
                     {
                         DefaultTableModel model = (DefaultTableModel)jTable_Display.getModel();
                         model.setRowCount(0);
                         show_user();
                        JOptionPane.showMessageDialog(null, "Your Reservation has been Updated " );
     
                       }
                     else{
                         JOptionPane.showMessageDialog(null, "Error: Check Your Information");
                     }
                   
                 } catch (SQLException ex) {
                     Logger.getLogger(Register_form.class.getName()).log(Level.SEVERE, null, ex);
                 }
     
         }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable_DisplayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_DisplayMouseClicked
      
        
        int i = jTable_Display.getSelectedRow();
        TableModel model = jTable_Display.getModel();
        jTextField_id.setText(model.getValueAt(i,0).toString());
        jTextField_fname.setText(model.getValueAt(i,1).toString());
        jTextField_lname.setText(model.getValueAt(i,2).toString());
        jTextField_email.setText(model.getValueAt(i,3).toString());
        
       try{
           Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i,4).toString());
           jDateChooser_In.setDate(date);
       }
       catch (Exception e)
        {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
         }
         
       try{
           Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(i,5).toString());
           jDateChooser_Out.setDate(date);
       }
       catch (Exception e)
        {
        System.err.println("Got an exception! ");
        System.err.println(e.getMessage());
         }
       
      jSpinner_persons.setValue(Integer.parseInt((String)model.getValueAt(i,6)));
      
      String r_type =(model.getValueAt(i,7).toString());
        if (r_type.equals("Standard")){
            jRadioButton_Standard.setSelected(true);
        }
        else{
            jRadioButton_Luxury.setSelected(true);
        }
    }//GEN-LAST:event_jTable_DisplayMouseClicked

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Menu mn = new Menu();
        mn.setVisible(true);
        mn.pack();
        mn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
     public boolean verifyFields()
    {
        
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         String fname = jTextField_fname.getText();
         String lname = jTextField_lname.getText();
         String email = jTextField_email.getText();
         String check_in = (df.format(jDateChooser_In.getDate()));
         String check_out = (df.format(jDateChooser_Out.getDate()));
         int persons = (Integer) jSpinner_persons.getValue();
         
         String str1 = Integer.toString(persons);
        
        //check empty fields
        if(fname.trim().equals("") || lname.trim().equals("") || email.trim().equals("") 
                || check_in.trim().equals("") || check_out.trim().equals("") || str1.trim().equals("0")|| (!jRadioButton_Standard.isSelected() && !jRadioButton_Luxury.isSelected() ))
            
        {
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty","Empty Fields",2);
            return false;
        }
        else {
            
            return true;
        }
    }
    
    
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
            java.util.logging.Logger.getLogger(View_Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View_Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View_Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View_Reservation.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View_Reservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser_In;
    private com.toedter.calendar.JDateChooser jDateChooser_Out;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton_Luxury;
    private javax.swing.JRadioButton jRadioButton_Standard;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner_persons;
    private javax.swing.JTable jTable_Display;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField jTextField_fname;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_lname;
    // End of variables declaration//GEN-END:variables
}
