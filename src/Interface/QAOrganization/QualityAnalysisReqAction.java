/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.QAOrganization;

import Business.LoggedUserDTO;
import Business.RequestDTO;
import DAO.ProcessDao;
import java.awt.CardLayout;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author SHREE GANESH
 */
public class QualityAnalysisReqAction extends javax.swing.JPanel {

    /**
     * Creates new form QualityAnalysisJPanel
     */
    JPanel container;
    RequestDTO reqDTO;
    LoggedUserDTO loggedUser;
    List<String> allUserNames;
    public QualityAnalysisReqAction(JPanel userProcessContainer, RequestDTO workreq, LoggedUserDTO loggedUser) {
        initComponents();
        this.container = userProcessContainer;
        this.reqDTO = workreq;
        this.loggedUser = loggedUser;
        jTextFieldUserName.setText(workreq.getRequestUserName());
        jTextFieldWasteQuantity.setText(workreq.getWasteQuantity());
        jTextFieldWasteType.setText(workreq.getWasteType());
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
        jTextFieldUserName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldWasteType = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldWasteQuantity = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbQualityPass = new javax.swing.JComboBox();
        btnSubmit = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        lblEnteprise = new javax.swing.JLabel();
        cmbOrgNames = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jLabel1.setText("Request User Name");

        jTextFieldUserName.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jLabel2.setText("Waste Type");

        jTextFieldWasteType.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jLabel3.setText("Waste Quantity");

        jTextFieldWasteQuantity.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jLabel4.setText("Quality Check Pass");

        cmbQualityPass.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pass", "Fail" }));

        btnSubmit.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jLabel5.setText("Need to Recycle");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "YES", "NO" }));
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });
        jComboBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox2MouseClicked(evt);
            }
        });
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        lblEnteprise.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        lblEnteprise.setText("Pass to Organization Name");

        cmbOrgNames.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        cmbOrgNames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrgNamesActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 0));
        jLabel7.setText("Quality Analysis Organization Action");

        btnBack.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(490, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbQualityPass, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldWasteQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldWasteType, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEnteprise)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbOrgNames, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(btnBack)
                        .addGap(27, 27, 27)
                        .addComponent(btnSubmit)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldWasteType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldWasteQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbQualityPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEnteprise, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbOrgNames, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSubmit)
                    .addComponent(btnBack))
                .addContainerGap(122, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        
        //Take decision
        
        if(jComboBox2.getSelectedItem().toString().equalsIgnoreCase("YES")){
            // Show Recycle plant Orgs
            cmbOrgNames.removeAllItems();
        allUserNames = ProcessDao.getAllUsersForEnt("Recycler","Disposal Unit");
        reqDTO.setAssignedUnitRemarks("Passed in Quality Test and passing to Recycler Plant");
        for(String user : allUserNames){
            cmbOrgNames.addItem(user);
        }
        }else{
            //send back to transportation
            cmbOrgNames.removeAllItems();
            
            reqDTO.setAssignedUnitRemarks("Failed in Quality Test and passing to Transport again");
            allUserNames = ProcessDao.getAllUsersForEnt("Recycler","NA");
        for(String user : allUserNames){
            cmbOrgNames.addItem(user);
        }
        }
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox2MouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jComboBox2MouseClicked

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        
        if(cmbOrgNames.getSelectedItem() == null){
        JOptionPane.showMessageDialog(null, "Please fill all the details", "Warning",JOptionPane.WARNING_MESSAGE);
        }else{
        //reqDTO.setAssignedUnitRemarks("");
        reqDTO.setIsQualityApproved(cmbQualityPass.getSelectedItem().toString());
        reqDTO.setLastActionTakenUnit("Quality Assurance Unit");
        
        reqDTO.setLastUnitAssignedDate(new Date());
        reqDTO.setReqAssgnEntName(loggedUser.getEnterpriseName());
        reqDTO.setReqAssgnOrgName(cmbOrgNames.getSelectedItem().toString());
        reqDTO.setReqAssgnedEnterprise(cmbQualityPass.getSelectedItem().toString().equalsIgnoreCase("Pass") ? "Recycler" : "Transportation");
        reqDTO.setRequestAssignedUnit(cmbQualityPass.getSelectedItem().toString().equalsIgnoreCase("Pass") ? "Recycler Plant" : "Transportation");
        
        ProcessDao.updateReqInDBFromRecycler(reqDTO.getRequestId(), reqDTO, "QA");
          JOptionPane.showMessageDialog(null, "Action taken by QA successfully!!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void cmbOrgNamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrgNamesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrgNamesActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
		
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox cmbOrgNames;
    private javax.swing.JComboBox cmbQualityPass;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextFieldUserName;
    private javax.swing.JTextField jTextFieldWasteQuantity;
    private javax.swing.JTextField jTextFieldWasteType;
    private javax.swing.JLabel lblEnteprise;
    // End of variables declaration//GEN-END:variables
}
