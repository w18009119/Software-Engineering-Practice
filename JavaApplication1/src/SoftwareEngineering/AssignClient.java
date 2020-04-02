/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoftwareEngineering;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author lang
 */
public class AssignClient extends javax.swing.JFrame {
    /**
     * Creates new form AssignClient
     */
    public AssignClient() {
        initComponents();
        
    try{
       Connection conn = null;          
       String url = "jdbc:sqlite:C:\\Users\\lang\\Desktop\\SQLite\\booking.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url); 
   
    tblQueue.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {

            // print column value from selected row
            String session = tblQueue.getValueAt(tblQueue.getSelectedRow(), 0).toString();
            txtQueueID.setText(session);
            
             session = tblQueue.getValueAt(tblQueue.getSelectedRow(), 1).toString();
            txtClientID.setText(session);
            
             String category  = tblQueue.getValueAt(tblQueue.getSelectedRow(), 2).toString();
            txtCategory.setText(category);
            
             session = tblQueue.getValueAt(tblQueue.getSelectedRow(), 3).toString();
            txtForename.setText(session);
            
             session = tblQueue.getValueAt(tblQueue.getSelectedRow(), 4).toString();
            txtSurname.setText(session);


        }
    }); 

    DefaultTableModel model = new DefaultTableModel(new String[]{"Queue_id", "Client_id", "Category", "First_name", "Last_name"}, 0);

    Statement stmt = conn.createStatement( );
    String sql="SELECT * FROM queue ORDER BY queue_id";
    ResultSet rs = stmt.executeQuery(sql);
     
    while(rs.next())
 {
     String queueID = rs.getString("queue_id");
     String clientID = rs.getString("client_id");
     String category = rs.getString("category");
     String forename = rs.getString("first_name");
     String surname = rs.getString("last_name");
     model.addRow(new Object[]{queueID, clientID, category, forename, surname});
 }  
    tblQueue.setModel(model); 


    
    
    tblVolunteer.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        public void valueChanged(ListSelectionEvent event) {

            // print column value from selected row
            String session = tblVolunteer.getValueAt(tblVolunteer.getSelectedRow(), 0).toString();
            txtSessionID.setText(session);
            
             session = tblVolunteer.getValueAt(tblVolunteer.getSelectedRow(), 1).toString();
            txtVolunteerID.setText(session);
            
             session = tblVolunteer.getValueAt(tblVolunteer.getSelectedRow(), 2).toString();
            txtDate.setText(session);
            
             session = tblVolunteer.getValueAt(tblVolunteer.getSelectedRow(), 3).toString();
            txtTime.setText(session);
            
             session = tblVolunteer.getValueAt(tblVolunteer.getSelectedRow(), 4).toString();
            txtRoom.setText(session);
            
            session = tblVolunteer.getValueAt(tblVolunteer.getSelectedRow(), 5).toString();
            txtVolCategory.setText(session);       
        }
    }); 
    
    conn.close();

 } catch(SQLException e) {
     System.err.println("SQL Exception caught " + e);
     
 }

    txtCategory.getDocument().addDocumentListener(new DocumentListener() {  
    public void changedUpdate(DocumentEvent e) {
    }
    public void removeUpdate(DocumentEvent e) {
    }        
    
    public void insertUpdate(DocumentEvent e) {
                    
        try{
        Connection conn = null;
        String url = "jdbc:sqlite:C:\\Users\\lang\\Desktop\\SQLite\\booking.db";
        // create a connection to the database
        conn = DriverManager.getConnection(url); 

        Statement stmt = conn.createStatement( );

        DefaultTableModel model = new DefaultTableModel(new String[]{"sessionID", "volunteerID", "date", "time", "room", "category"}, 0);

        String category = txtCategory.getText();


        String field[] ={"Benefits", "Debt", "Housing", "Employment"};
        String specialise[] ={"specialiseBenefits","specialiseDebt","specialiseHousing","specialiseEmployment"};
        String categorys[] ={"Benefits","Debt","Housing","Employment"};

        for(int i = 0; i<3; i++){
            if(category.equals(field[i])){

            String sql="SELECT * FROM VolunteerAvailability WHERE "+specialise[i]+"='Yes'";
            ResultSet rs = stmt.executeQuery(sql);

                while(rs.next())
                {
                int z = rs.getInt("sessionID");
                int y = rs.getInt("volunteerID");

                String f = rs.getString("specialiseBenefits");
                String g = rs.getString("specialiseDebt");
                String h = rs.getString("specialiseHousing");
                String grw = rs.getString("specialiseEmployment");

                String j = rs.getString("date");
                String k = rs.getString("time");
                int l = rs.getInt("room");
                String m = categorys[i];
                model.addRow(new Object[]{z, y, j, k, l, m});
                }  

            }
        }

        tblVolunteer.setModel(model); 

        }
        catch(SQLException z) {
        System.err.println("SQL Exception caught " + e);
        }
    }
});    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnBack5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtClientID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtForename = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSurname = new javax.swing.JTextField();
        txtCategory = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtQueueID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVolunteer = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtSessionID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtVolunteerID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtTime = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtRoom = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblQueue = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSelectedSessionID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSelectedVolunteerID = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtSelectedClientID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtSelectedCategory = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtSelectedDate = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtSelectedTime = new javax.swing.JTextField();
        txtSelectedRoom = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        btnChoose = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        txtVolCategory = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(251, 199, 123));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));
        jPanel7.setForeground(new java.awt.Color(0, 0, 4));

        jLabel12.setFont(new java.awt.Font("Tahoma", 2, 60)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Assign Client ");

        btnBack5.setText("Back");
        btnBack5.setToolTipText("");
        btnBack5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack5btnBackActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(219, 253, 253));
        jButton2.setLabel("Help");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200)
                .addComponent(jButton2)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(251, 199, 123));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("ClientID");

        txtClientID.setEditable(false);
        txtClientID.setBackground(new java.awt.Color(255, 255, 255));
        txtClientID.setName("txtPostcode"); // NOI18N
        txtClientID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClientIDKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Category");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Forename");

        txtForename.setEditable(false);
        txtForename.setBackground(new java.awt.Color(255, 255, 255));
        txtForename.setName("txtPostcode"); // NOI18N
        txtForename.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtForenameKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Surname");

        txtSurname.setEditable(false);
        txtSurname.setBackground(new java.awt.Color(255, 255, 255));
        txtSurname.setName("txtPostcode"); // NOI18N
        txtSurname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSurnameKeyReleased(evt);
            }
        });

        txtCategory.setEditable(false);
        txtCategory.setBackground(new java.awt.Color(255, 255, 255));
        txtCategory.setName("txtPostcode"); // NOI18N
        txtCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCategoryKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("QueueID");

        txtQueueID.setEditable(false);
        txtQueueID.setBackground(new java.awt.Color(255, 255, 255));
        txtQueueID.setName("txtPostcode"); // NOI18N
        txtQueueID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQueueIDActionPerformed(evt);
            }
        });
        txtQueueID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtQueueIDKeyReleased(evt);
            }
        });

        tblVolunteer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "SessionID", "VolunteerID", "Date", "Time", "Room", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVolunteer);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("SessionID");

        txtSessionID.setEditable(false);
        txtSessionID.setBackground(new java.awt.Color(255, 255, 255));
        txtSessionID.setName("txtPostcode"); // NOI18N
        txtSessionID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSessionIDActionPerformed(evt);
            }
        });
        txtSessionID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSessionIDKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("VolunteerID");

        txtVolunteerID.setEditable(false);
        txtVolunteerID.setBackground(new java.awt.Color(255, 255, 255));
        txtVolunteerID.setName("txtPostcode"); // NOI18N
        txtVolunteerID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVolunteerIDKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Date");

        txtDate.setEditable(false);
        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setName("txtPostcode"); // NOI18N
        txtDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDateKeyReleased(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Time");

        txtTime.setEditable(false);
        txtTime.setBackground(new java.awt.Color(255, 255, 255));
        txtTime.setName("txtPostcode"); // NOI18N
        txtTime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimeKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel13.setText("Room");

        txtRoom.setEditable(false);
        txtRoom.setBackground(new java.awt.Color(255, 255, 255));
        txtRoom.setName("txtPostcode"); // NOI18N
        txtRoom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRoomKeyReleased(evt);
            }
        });

        tblQueue.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "QueueID", "ClientID", "Category", "Forename", "Surname"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblQueue);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("SessionID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("VolunteerID");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setText("ClientID");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setText("Category");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel16.setText("Date");

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel17.setText("Time");

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setText("Room");

        btnChoose.setText("Choose");
        btnChoose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChooseActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel19.setText("Category");

        txtVolCategory.setEditable(false);
        txtVolCategory.setBackground(new java.awt.Color(255, 255, 255));
        txtVolCategory.setName("txtPostcode"); // NOI18N
        txtVolCategory.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtVolCategoryKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtSelectedSessionID, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtSelectedVolunteerID, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(txtSelectedClientID, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(txtSelectedCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(txtSelectedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(txtSelectedTime, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txtSelectedRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(txtVolCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtQueueID, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(41, 41, 41)
                                            .addComponent(txtClientID, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtForename, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(31, 31, 31)
                                                .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtSessionID, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel10))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtVolunteerID, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                                        .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(273, 273, 273))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(jScrollPane2)))))
                        .addGap(52, 52, 52))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtQueueID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtClientID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(txtCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtForename, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSurname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSessionID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtVolunteerID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtRoom, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnChoose, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVolCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtSelectedSessionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(txtSelectedVolunteerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(txtSelectedClientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtSelectedCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(txtSelectedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(txtSelectedTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(txtSelectedRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack5btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack5btnBackActionPerformed
        // TODO add your handling code here:
        ControlPanel ul =new ControlPanel();
        ul.setVisible(true);
        
        dispose();
    }//GEN-LAST:event_btnBack5btnBackActionPerformed

    private void txtSurnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSurnameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSurnameKeyReleased

    private void txtForenameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtForenameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtForenameKeyReleased

    private void txtClientIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClientIDKeyReleased
        // TODO add your handling code here:

        
    }//GEN-LAST:event_txtClientIDKeyReleased

    private void txtCategoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCategoryKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoryKeyReleased

    private void txtQueueIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtQueueIDKeyReleased

    }//GEN-LAST:event_txtQueueIDKeyReleased

    private void txtQueueIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQueueIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQueueIDActionPerformed

    private void txtSessionIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSessionIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSessionIDActionPerformed

    private void txtSessionIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSessionIDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSessionIDKeyReleased

    private void txtVolunteerIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVolunteerIDKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVolunteerIDKeyReleased

    private void txtDateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDateKeyReleased

    private void txtTimeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimeKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimeKeyReleased

    private void txtRoomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRoomKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRoomKeyReleased

    private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
        // TODO add your handling code here:

    if((txtQueueID.getText().isEmpty() ||txtSessionID.getText().isEmpty()) ){
        JOptionPane.showMessageDialog(null, "Please choose a record out of each table");  
    }
    else if(txtCategory.getText().equals(txtVolCategory.getText())){
        tblQueue.setVisible(false);
        tblVolunteer.setVisible(false);
        txtSelectedSessionID.setText(txtSessionID.getText());
        txtSelectedVolunteerID.setText(txtVolunteerID.getText());
        txtSelectedDate.setText(txtDate.getText());
        txtSelectedTime.setText(txtTime.getText());
        txtSelectedRoom.setText(txtRoom.getText());
        
        txtSelectedClientID.setText(txtClientID.getText());
        txtSelectedCategory.setText(txtCategory.getText());
        
    }
    else{
        JOptionPane.showMessageDialog(null, "Client category doesn't meet the volunteers");  
        dispose();
        AssignClient ul =new AssignClient();
        ul.setVisible(true);
        
        
        
        

    }
    
        
        
    }//GEN-LAST:event_btnChooseActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        JOptionPane.showMessageDialog(null, 
                "<html><h1><b>Steps to booking a meeting</b></h1>\nSelect a client in the Queue table\nSelect a Volunteer Available table\nClick the 'Choose' button to confirm each of the choices\nClick the 'Add' button to book the meeting"
                ,"Help", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        
   
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        dispose();
        AssignClient ul =new AssignClient();
        ul.setVisible(true);      
    }//GEN-LAST:event_btnResetActionPerformed

    private void txtVolCategoryKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtVolCategoryKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVolCategoryKeyReleased

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
            java.util.logging.Logger.getLogger(AssignClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssignClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack5;
    private javax.swing.JButton btnChoose;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblQueue;
    private javax.swing.JTable tblVolunteer;
    private javax.swing.JTextField txtCategory;
    private javax.swing.JTextField txtClientID;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtForename;
    private javax.swing.JTextField txtQueueID;
    private javax.swing.JTextField txtRoom;
    private javax.swing.JTextField txtSelectedCategory;
    private javax.swing.JTextField txtSelectedClientID;
    private javax.swing.JTextField txtSelectedDate;
    private javax.swing.JTextField txtSelectedRoom;
    private javax.swing.JTextField txtSelectedSessionID;
    private javax.swing.JTextField txtSelectedTime;
    private javax.swing.JTextField txtSelectedVolunteerID;
    private javax.swing.JTextField txtSessionID;
    private javax.swing.JTextField txtSurname;
    private javax.swing.JTextField txtTime;
    private javax.swing.JTextField txtVolCategory;
    private javax.swing.JTextField txtVolunteerID;
    // End of variables declaration//GEN-END:variables
}
