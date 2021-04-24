package pursuit.PlannerHandler;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

import pursuit.*;
import pursuit.DataHandler.JTextFieldLimiter;
import pursuit.DataHandler.SQLDatabase;
import pursuit.DataHandler.TextFormat;

public class EditWorkoutForm extends javax.swing.JFrame {
    private DefaultTableModel tblModWorkout;
    private DefaultTableModel tblModDiet;
    
    public EditWorkoutForm() {
        initComponents();
        
    }
    
    public EditWorkoutForm(String tblName) {
        initComponents();

        restrictCharField();

        // a function that updates the table "Workout" and "Diet"
        // updateTables();
        
        createConnection();
        
        txtPlanName.setText(tblName);
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPlanName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtWorkout = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkout = new javax.swing.JTable();
        btnAddDiet = new javax.swing.JButton();
        btnRemoveDiet = new javax.swing.JButton();
        txtDurationMin = new javax.swing.JFormattedTextField();
        txtDurationSec = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDiet = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDiet = new javax.swing.JTable();
        btnRemoveWorkout = new javax.swing.JButton();
        btnAddWorkout = new javax.swing.JButton();
        btnAddPlan = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 8, true), "Add a Personalized Workout", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setLabelFor(txtPlanName);
        jLabel1.setText("Workout Plan Name:");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 8, true));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name of Workout:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Duration:");

        tblWorkout.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Workout", "Duration"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblWorkout);

        btnAddDiet.setText("Add");
        btnAddDiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDietPlanActionPerformed(evt);
            }
        });

        btnRemoveDiet.setText("Remove");
        btnRemoveDiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveDietActionPerformed(evt);
            }
        });

        txtDurationMin.setColumns(2);
        txtDurationMin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("mm"))));
        txtDurationMin.setText("Minutes");

        txtDurationSec.setColumns(2);
        txtDurationSec.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("ss"))));
        txtDurationSec.setText("Secs");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add a Meal:");

        tblDiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Meal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblDiet);

        btnRemoveWorkout.setText("Remove");
        btnRemoveWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveWorkoutActionPerformed(evt);
            }
        });

        btnAddWorkout.setText("Add");
        btnAddWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddWorkoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDurationMin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDurationSec))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtWorkout))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAddDiet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveDiet))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDiet))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAddWorkout)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemoveWorkout)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddDiet, btnRemoveDiet});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddWorkout, btnRemoveWorkout});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtWorkout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDurationMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDurationSec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemoveWorkout)
                    .addComponent(btnAddWorkout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddDiet)
                    .addComponent(btnRemoveDiet))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddDiet, btnRemoveDiet});

        btnAddPlan.setText("Add Plan");
        btnAddPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPlanActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 246, Short.MAX_VALUE)
                        .addComponent(btnAddPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPlanName))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddPlan, btnBack});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPlanName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBack)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAddPlan)
                        .addContainerGap())))
        );

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createConnection() {
        try {
            SQLDatabase.getCon();
        } catch (Exception ex) {
            Logger.getLogger(EditWorkoutForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void restrictCharField() {
        try {
            txtDurationMin.setDocument(new JTextFieldLimiter(2));
            txtDurationSec.setDocument(new JTextFieldLimiter(2));
        } catch (Exception ex) {
            Logger.getLogger(EditWorkoutForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateTables() {
        String tblPlanName = txtPlanName.getText();
        
    }
    
    private void btnAddPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPlanActionPerformed
        tblModWorkout = (DefaultTableModel)tblWorkout.getModel();
        tblModDiet = (DefaultTableModel)tblDiet.getModel();
        
        String workoutTypes;
        String workoutDuration;
        String workoutDiet;
        String plnName = TextFormat.formatInsertedTableName(txtPlanName.getText());
        
        SQLDatabase.createTable(plnName);
        
        // Inserts all the data to table
        int rowCount = tblModWorkout.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            workoutTypes = tblModWorkout.getValueAt(i, 0).toString();
            workoutDuration = tblModWorkout.getValueAt(i, 1).toString();
            SQLDatabase.insertData(plnName, workoutTypes, workoutDuration);
        }
        
        int tblDietRowCount = tblModDiet.getRowCount(); 
        for (int j = 0; j < tblDietRowCount; j++) {
            workoutDiet = tblModDiet.getValueAt(j, 0).toString();
            SQLDatabase.insertData(plnName, workoutDiet);
        }

        txtPlanName.setText("");
        txtWorkout.setText("");
        txtDurationMin.setText("");
        txtDurationSec.setText("");
        txtDiet.setText("");
        this.dispose();
        new PlannerForm();
    }//GEN-LAST:event_btnAddPlanActionPerformed

    private void btnAddDietPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDietPlanActionPerformed
        String dietItems[] = { txtDiet.getText() };
        tblModDiet = (DefaultTableModel)tblDiet.getModel();
        tblModDiet.addRow(dietItems);
        
        txtDiet.setText("");
    }//GEN-LAST:event_btnAddDietPlanActionPerformed

    private void btnRemoveDietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveDietActionPerformed
        tblModDiet = (DefaultTableModel)tblDiet.getModel();
        int selectedDietRowIndex = tblDiet.getSelectedRow();
        tblModDiet.removeRow(selectedDietRowIndex);
    }//GEN-LAST:event_btnRemoveDietActionPerformed

    private void btnAddWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddWorkoutActionPerformed
        String workoutItems[] = { txtWorkout.getText(), txtDurationMin.getText() + ":" + txtDurationSec.getText() };
        tblModWorkout = (DefaultTableModel)tblWorkout.getModel();
        tblModWorkout.addRow(workoutItems);
        
        txtWorkout.setText("");
        txtDurationMin.setText("");
        txtDurationSec.setText("");
    }//GEN-LAST:event_btnAddWorkoutActionPerformed

    private void btnRemoveWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveWorkoutActionPerformed
        tblModWorkout = (DefaultTableModel)tblWorkout.getModel();
        int selectedWorkoutRowIndex = tblWorkout.getSelectedRow();
        tblModWorkout.removeRow(selectedWorkoutRowIndex);
    }//GEN-LAST:event_btnRemoveWorkoutActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
        new PlannerForm();
    }//GEN-LAST:event_btnBackActionPerformed
    
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
            java.util.logging.Logger.getLogger(EditWorkoutForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditWorkoutForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditWorkoutForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditWorkoutForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditWorkoutForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDiet;
    private javax.swing.JButton btnAddPlan;
    private javax.swing.JButton btnAddWorkout;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemoveDiet;
    private javax.swing.JButton btnRemoveWorkout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblDiet;
    private javax.swing.JTable tblWorkout;
    private javax.swing.JTextField txtDiet;
    private javax.swing.JFormattedTextField txtDurationMin;
    private javax.swing.JFormattedTextField txtDurationSec;
    private javax.swing.JTextField txtPlanName;
    private javax.swing.JTextField txtWorkout;
    // End of variables declaration//GEN-END:variables
}
