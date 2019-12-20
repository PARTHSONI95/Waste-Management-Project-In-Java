/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.RecyclerWorkArea;

import Business.LoggedUserDTO;
import Business.RequestDTO;
import Interface.Planning.*;
import Business.RequestWorkFlowDTO;
import DAO.ManageAdminDAO;
import DAO.ProcessDao;
import Interface.Validation;
import java.awt.CardLayout;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ABC
 */
public class RecyclerWorkRequests extends javax.swing.JPanel {

    /**
     * Creates new form RecyclerWorkRequests
     */
    
    JPanel userProcessContainer;
    String reqUserName;
    String entName;
    LoggedUserDTO loggedUser;
    String[] allEnt;
    boolean qualityApprovalFlag;
    public RecyclerWorkRequests(JPanel userProcessContainer, LoggedUserDTO loggedUser) {
//        List<String> entNameList = ProcessDao.getAllEntNameForEntType("QualityAssurance");
//            allEnt = new String[entNameList.size()];
//            Object[] objArr = entNameList.toArray(); 
//            int i = 0; 
//            for (Object obj : objArr) { 
//            allEnt[i++] = (String)obj; 
//            }
        initComponents();
        this.loggedUser = loggedUser;
        this.entName = entName;
        lblEntName.setVisible(false);
        cmbEntName.setVisible(false);
        jLabelRemark.setVisible(false);
            txtRemarks.setVisible(false);
        jButtonAssign.setVisible(false);
        this.userProcessContainer = userProcessContainer;
        populateRecyclerWorkQ();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void populateRecyclerWorkQ(){
        
      ProcessDao pDao = new ProcessDao();
      List<RequestDTO> resultList = pDao.getUnitWorkQ(loggedUser.getUserName(),"Recycler");
      
      DefaultTableModel dtm = (DefaultTableModel) jTableRecyclerRequestQ.getModel();
        dtm.setRowCount(0);

        for (RequestDTO reqDetail : resultList) {
            Object[] row = new Object[6];
            
            row[0] = reqDetail;
            //row[0] = reqDetail.getReqUserName();
            row[2] = reqDetail.getRequestStatus();
            row[1] = reqDetail.getRequestUserName();
            row[3] = reqDetail.getLastActionTakenUnit();
            row[4] = reqDetail.getAssignedUnitRemarks();
            //row[5] = reqDetail.getReqCreationDttm();
            //row[4] = reqDetail.getReqCreationDttm();
            dtm.addRow(row);

        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableRecyclerRequestQ = new javax.swing.JTable();
        lblEntName = new javax.swing.JLabel();
        cmbEntName = new javax.swing.JComboBox<String>();
        jButtonAssign = new javax.swing.JButton();
        jLabelRemark = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRemarks = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 0));
        jLabel1.setText("Recycler Enterprise Request Queue");

        jButton1.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 0));
        jButton1.setText("Assign to");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTableRecyclerRequestQ.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jTableRecyclerRequestQ.setForeground(new java.awt.Color(51, 51, 0));
        jTableRecyclerRequestQ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request ID", "Requestor User Name", "Status", "Last Action Taken By", "Remark"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableRecyclerRequestQ);

        lblEntName.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        lblEntName.setForeground(new java.awt.Color(51, 51, 0));
        lblEntName.setText("Select Quality Assurance Org:");

        cmbEntName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEntNameActionPerformed(evt);
            }
        });

        jButtonAssign.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jButtonAssign.setForeground(new java.awt.Color(51, 51, 0));
        jButtonAssign.setText("Assign");
        jButtonAssign.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAssignActionPerformed(evt);
            }
        });

        jLabelRemark.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jLabelRemark.setForeground(new java.awt.Color(51, 51, 0));
        jLabelRemark.setText("Remark: ");

        txtRemarks.setColumns(20);
        txtRemarks.setRows(5);
        jScrollPane1.setViewportView(txtRemarks);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(369, 369, 369)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEntName, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelRemark))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonAssign)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbEntName, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEntName)
                    .addComponent(cmbEntName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelRemark))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAssign)
                .addContainerGap(24, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTableRecyclerRequestQ.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row from table first to view details.", "Warning",JOptionPane.WARNING_MESSAGE);
        }else{
            //RequestWorkFlowDTO workreq = (RequestWorkFlowDTO) jTableGovernmentRequestQ.getValueAt(selectedRow, 0);
            //CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            //GovernmentReqAction govtPlanning = new GovernmentReqAction(userProcessContainer, (RequestWorkFlowDTO) workreq);
            //userProcessContainer.add("GovernmentPlanningScreen", govtPlanning);
            //layout.next(userProcessContainer);
            
            
            
            lblEntName.setVisible(true);
            jLabelRemark.setVisible(true);
            txtRemarks.setVisible(true);
            cmbEntName.setVisible(true);
            jButtonAssign.setVisible(true);
            
            int selectedRequestId = Integer.parseInt(jTableRecyclerRequestQ.getValueAt(selectedRow,0).toString());
            //if(!selectedUnit.equalsIgnoreCase("Planning")){
             //   JOptionPane.showMessageDialog(null, "This request can't be assign to other enterprise until passed through all Government organization.", "Warning",JOptionPane.WARNING_MESSAGE);
            //} else {
            if(ManageAdminDAO.checkQualityApproved(selectedRequestId)){
                System.out.println("Quality Approved True");
                qualityApprovalFlag = true;
            List<String> TransEntusers = ProcessDao.getAllUsersForEnt("Transport","NA"); 
                System.out.println("Pass");
            lblEntName.setText("Acknowledge to Enterprise");
            cmbEntName.removeAllItems();
            for(String s: TransEntusers){
            cmbEntName.addItem(s);
            }
            }else{
            qualityApprovalFlag = false;    
            List<String> QualityEntusers = ProcessDao.getAllUsersForEnt("Recycler","Quality Assurance");  
            lblEntName.setText("Assign to QA");
            cmbEntName.removeAllItems();
            for(String s: QualityEntusers){
            cmbEntName.addItem(s);
            }
            
            }
            
                
                ProcessDao daoObj = new ProcessDao();
                //daoObj.assignReqToEntrprise(Integer.parseInt(jTableGovernmentRequestQ.getValueAt(selectedRow, 0).toString()));
           // }
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAssignActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAssignActionPerformed
        // TODO add your handling code here:
        RequestDTO reqDTO = new RequestDTO();
        Date now = new Date();
        int selectedRow = jTableRecyclerRequestQ.getSelectedRow();
        reqDTO.setAssignedUnitRemarks(txtRemarks.getText());
        reqDTO.setLastUnitAssignedDate(new java.sql.Date(now.getTime()));
        reqDTO.setLastActionTakenUnit("Recycler Enterprise");
        
        if(qualityApprovalFlag){
        reqDTO.setReqAssgnOrgName("NA");
        reqDTO.setRequestAssignedUnit("Transport");
        reqDTO.setReqAssgnEntName(cmbEntName.getSelectedItem().toString());
        }else{
        reqDTO.setRequestAssignedUnit("QA");
        reqDTO.setReqAssgnEntName(loggedUser.getEnterpriseName());
        reqDTO.setReqAssgnOrgName(cmbEntName.getSelectedItem().toString());
        }
        
        if(Validation.checkMultiAlphaNumericSpecial(txtRemarks.getText())){
        ProcessDao.updateReqInDBFromTransport(Integer.parseInt(jTableRecyclerRequestQ.getValueAt(selectedRow, 0).toString()), reqDTO);
        
        JOptionPane.showMessageDialog(null, "Request assigned to Quality Organization succssfully!!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }else{
        JOptionPane.showMessageDialog(null, "Please add Remarks", "Warning",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAssignActionPerformed

    private void cmbEntNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEntNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEntNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbEntName;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAssign;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelRemark;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableRecyclerRequestQ;
    private javax.swing.JLabel lblEntName;
    private javax.swing.JTextArea txtRemarks;
    // End of variables declaration//GEN-END:variables
}
