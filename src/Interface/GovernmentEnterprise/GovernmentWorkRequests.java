/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.GovernmentEnterprise;

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
public class GovernmentWorkRequests extends javax.swing.JPanel {

    /**
     * Creates new form GovernmentWorkRequests
     */
    
    JPanel container;
    String reqUserName;
    String entName;
    LoggedUserDTO loggedUser;
    String[] allEnt;
    boolean checkQualityFlag;
    public GovernmentWorkRequests(JPanel userProcessContainer, LoggedUserDTO loggedUser, String entName) {
        List<String> entNameList = ProcessDao.getAllEntNameForEntType("Transport");
            allEnt = new String[entNameList.size()];
            Object[] objArr = entNameList.toArray(); 
            int i = 0; 
            for (Object obj : objArr) { 
            allEnt[i++] = (String)obj; 
            }
        initComponents();
        this.loggedUser = loggedUser;
        this.entName = entName;
        lblAssignto.setVisible(false);
        cmbAssignTo.setVisible(false);
        lblRemark.setVisible(false);
            txtRemark.setVisible(false);
        btnFinalize.setVisible(false);
        this.container = userProcessContainer;
        populateGovernmentWorkQ();
        
        
        //Visibilities Off
        if(lblAssignto.isVisible()){
           lblAssignto.setVisible(false);
        }
        if(lblRemark.isVisible()){
           lblRemark.setVisible(false);
        }
        if(txtRemark.isVisible()){
           txtRemark.setVisible(false);
        }
        if(cmbAssignTo.isVisible()){
           cmbAssignTo.setVisible(false);
        }
        if(btnFinalize.isVisible()){
           btnFinalize.setVisible(false);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void populateGovernmentWorkQ(){
        
      ProcessDao pDao = new ProcessDao();
      List<RequestDTO> resultList = pDao.getUnitWorkQ(loggedUser.getUserName(),"Government");
      
      DefaultTableModel dtm = (DefaultTableModel) jTableGovernmentRequestQ.getModel();
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
        btnAssignTo = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableGovernmentRequestQ = new javax.swing.JTable();
        lblAssignto = new javax.swing.JLabel();
        cmbAssignTo = new javax.swing.JComboBox<String>();
        btnFinalize = new javax.swing.JButton();
        lblRemark = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRemark = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Government Enterprise Request Queue");

        btnAssignTo.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnAssignTo.setText("Assign to / Submit");
        btnAssignTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignToActionPerformed(evt);
            }
        });

        jTableGovernmentRequestQ.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jTableGovernmentRequestQ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request ID", "Requestor User Name", "Status", "Last Action Taken By", "Remark"
            }
        ));
        jScrollPane2.setViewportView(jTableGovernmentRequestQ);

        lblAssignto.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        lblAssignto.setForeground(new java.awt.Color(204, 255, 255));
        lblAssignto.setText("Assign to other Enterprise: ");

        cmbAssignTo.setModel(new javax.swing.DefaultComboBoxModel(allEnt));

        btnFinalize.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnFinalize.setText("Assign");
        btnFinalize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizeActionPerformed(evt);
            }
        });

        lblRemark.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        lblRemark.setForeground(new java.awt.Color(204, 255, 255));
        lblRemark.setText("Remark: ");

        txtRemark.setColumns(20);
        txtRemark.setRows(5);
        jScrollPane1.setViewportView(txtRemark);

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
                        .addComponent(btnAssignTo, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAssignto, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRemark))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbAssignTo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFinalize, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnAssignTo)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAssignto)
                    .addComponent(cmbAssignTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblRemark))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinalize)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAssignToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignToActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTableGovernmentRequestQ.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row from table first to view details.", "Warning",JOptionPane.WARNING_MESSAGE);
        }else{
            //RequestWorkFlowDTO workreq = (RequestWorkFlowDTO) jTableGovernmentRequestQ.getValueAt(selectedRow, 0);
            //CardLayout layout = (CardLayout)userProcessContainer.getLayout();
            //GovernmentReqAction govtPlanning = new GovernmentReqAction(userProcessContainer, (RequestWorkFlowDTO) workreq);
            //userProcessContainer.add("GovernmentPlanningScreen", govtPlanning);
            //layout.next(userProcessContainer);
            
            
            
            
            String selectedUnit = jTableGovernmentRequestQ.getValueAt(selectedRow, 3).toString();
            int requestId = Integer.parseInt(jTableGovernmentRequestQ.getValueAt(selectedRow, 0).toString());
//            if(!selectedUnit.equalsIgnoreCase("Planning")){
//                JOptionPane.showMessageDialog(null, "This request can't be assign to other enterprise until passed through all Government organization.", "Warning",JOptionPane.WARNING_MESSAGE);
//            } else {
              if(ManageAdminDAO.checkQualityApproved(requestId)){
                 checkQualityFlag = true; 
                 btnFinalize.setText("Complete Request Status");
                if(!btnFinalize.isVisible())
                    
                    btnFinalize.setVisible(true);
                }else{
                checkQualityFlag = false;  
                btnFinalize.setText("Assign To");
                if(!lblAssignto.isVisible()){
                    lblAssignto.setVisible(true);
                    }
                if(!lblRemark.isVisible()){
                   lblRemark.setVisible(true);
                }
                if(!txtRemark.isVisible()){
                   txtRemark.setVisible(true);
                }
                if(!cmbAssignTo.isVisible()){
                   cmbAssignTo.setVisible(true);
                }
                if(!btnFinalize.isVisible()){
                   btnFinalize.setVisible(true);
                }
                  
                }    
                ProcessDao daoObj = new ProcessDao();
                //daoObj.assignReqToEntrprise(Integer.parseInt(jTableGovernmentRequestQ.getValueAt(selectedRow, 0).toString()));
            
//            }
        }
        
        
        
        
        
    }//GEN-LAST:event_btnAssignToActionPerformed

    private void btnFinalizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizeActionPerformed
        // TODO add your handling code here:
        RequestDTO reqDTO = new RequestDTO();
        Date now = new Date();
        int selectedRow = jTableGovernmentRequestQ.getSelectedRow();
        
        reqDTO.setLastUnitAssignedDate(new java.sql.Date(now.getTime()));
        reqDTO.setLastActionTakenUnit("Government Enterprise");
        if(checkQualityFlag){
        reqDTO.setReqAssgnOrgName("");
        reqDTO.setReqAssgnEntName("");
        reqDTO.setRequestStatus("Completed");
        reqDTO.setAssignedUnitRemarks("Material Reusable");
        reqDTO.setReqAssgnEntName(cmbAssignTo.getSelectedItem().toString());
        reqDTO.setAssignedUnitRemarks("Cycle Complete");
        }else{
        
        reqDTO.setReqAssgnOrgName(cmbAssignTo.getSelectedItem().toString());
        reqDTO.setReqAssgnEntName(cmbAssignTo.getSelectedItem().toString());
        reqDTO.setAssignedUnitRemarks(txtRemark.getText());
        }
//       if(Validation.checkMultiAlphaNumericSpecial(txtRemark.getText())){ 
        ProcessDao.updateReqInDBFromTransport(Integer.parseInt(jTableGovernmentRequestQ.getValueAt(selectedRow, 0).toString()), reqDTO);
        JOptionPane.showMessageDialog(null, "Submit Successful", "Information",JOptionPane.INFORMATION_MESSAGE);
//       }else{
//       JOptionPane.showMessageDialog(null, "Please add Remarks", "Warning",JOptionPane.WARNING_MESSAGE);
//       }
    }//GEN-LAST:event_btnFinalizeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssignTo;
    private javax.swing.JButton btnFinalize;
    private javax.swing.JComboBox<String> cmbAssignTo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableGovernmentRequestQ;
    private javax.swing.JLabel lblAssignto;
    private javax.swing.JLabel lblRemark;
    private javax.swing.JTextArea txtRemark;
    // End of variables declaration//GEN-END:variables
}
