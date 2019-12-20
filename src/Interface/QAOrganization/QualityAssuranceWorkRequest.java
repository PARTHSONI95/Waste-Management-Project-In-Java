/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.QAOrganization;

import Interface.Transportation.*;
import Business.LoggedUserDTO;
import Business.RequestDTO;
import Interface.GovernmentEnterprise.*;
import Interface.Planning.*;
import Business.RequestWorkFlowDTO;
import DAO.ProcessDao;
import java.awt.CardLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ABC
 */
public class QualityAssuranceWorkRequest extends javax.swing.JPanel {

    /**
     * Creates new form GovernmentWorkRequests
     */
    
   
    JPanel userProcessContainer;
    String reqUserName;
    String entName;
    LoggedUserDTO loggedUser;
    public QualityAssuranceWorkRequest(JPanel userProcessContainer, LoggedUserDTO loggedUser) {
        initComponents();
        this.loggedUser = loggedUser;
        //jLabel2.setVisible(false);
        //jComboBoxDropDown.setVisible(false);
        //jButtonAssign.setVisible(false);
        this.userProcessContainer = userProcessContainer;
        populateQAWorkQ();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void populateQAWorkQ(){
        
      ProcessDao pDao = new ProcessDao();
      List<RequestDTO> resultList = pDao.getUnitWorkQ(loggedUser.getUserName(), "QA");
      
      DefaultTableModel dtm = (DefaultTableModel) jTableQA.getModel();
        dtm.setRowCount(0);

        for (RequestDTO reqDetail : resultList) {
            Object[] row = new Object[dtm.getColumnCount()];
            
            row[0] = reqDetail;
            row[1] = reqDetail.getRequestUserName();
            row[4] = reqDetail.getRequestStatus();
            row[5] = reqDetail.getLastActionTakenUnit();
            row[2] = reqDetail.getWasteType();
            //row[5] = reqDetail.getWasteQuantity();
            //row[6] = reqDetail.getAssignedUnitRemarks();
            //row[7] = reqDetail.getLastUnitAssignedDate();
            row[3] = reqDetail.getRequestCreationDate();
            dtm.addRow(row);

        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableQA = new javax.swing.JTable();

        setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 0));
        jLabel1.setText("Quality Assurance Work Request Queue");

        jButton1.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 51, 0));
        jButton1.setText("Take Action");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTableQA.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jTableQA.setForeground(new java.awt.Color(0, 51, 0));
        jTableQA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Request ID", "Request User Name", "Waste Type", "Date created on", "Status", "Last Action Taken by"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableQA);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(234, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTableQA.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row from table first to view details.", "Warning",JOptionPane.WARNING_MESSAGE);
        }else{
            
            
            //String selectedUnit = jTableQA.getValueAt(selectedRow, 3).toString();
            //if(!selectedUnit.equalsIgnoreCase("Planning")){
              //  JOptionPane.showMessageDialog(null, "This request can't be assign to other enterprise until passed through all Government organization.", "Warning",JOptionPane.WARNING_MESSAGE);
            //} else {
                 RequestDTO workreq = (RequestDTO) jTableQA.getValueAt(selectedRow, 0);
                 CardLayout layout = (CardLayout)userProcessContainer.getLayout();
                 QualityAnalysisReqAction qaObj = new QualityAnalysisReqAction(userProcessContainer, (RequestDTO) workreq, loggedUser);
                 userProcessContainer.add("QualityAnalysisReqAction", qaObj);
                 layout.next(userProcessContainer);
           // }
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableQA;
    // End of variables declaration//GEN-END:variables
}