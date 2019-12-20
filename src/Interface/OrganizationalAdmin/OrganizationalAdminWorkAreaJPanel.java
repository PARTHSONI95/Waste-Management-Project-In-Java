/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.OrganizationalAdmin;

import Business.LoggedUserDTO;
import Interface.GovernmentEnterprise.GovernmentWorkRequests;
import Interface.RecyclerWorkArea.RecyclerWorkRequests;
import Interface.SystemAdminWorkArea.ManageEnterpriseJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author SHREE GANESH
 */
public class OrganizationalAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form OrganizationalAdminWorkAreaJPanel
     */
    JPanel container;
    LoggedUserDTO loggedUser;
    public OrganizationalAdminWorkAreaJPanel(JPanel container, LoggedUserDTO loggedUser) {
        initComponents();
        this.container = container;
        this.loggedUser = loggedUser;
        txtEntName.setText(loggedUser.getEnterpriseName());
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
        jLabel2 = new javax.swing.JLabel();
        txtEntName = new javax.swing.JLabel();
        btnAddOrg = new javax.swing.JButton();
        btnManageUsers = new javax.swing.JButton();
        jButtonManageQ = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel1.setText("My Work Area -Adminstrative Role");

        jLabel2.setBackground(new java.awt.Color(255, 0, 51));
        jLabel2.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("Enterprise Name:");

        txtEntName.setBackground(new java.awt.Color(255, 0, 51));
        txtEntName.setFont(new java.awt.Font("Copperplate Gothic Bold", 0, 12)); // NOI18N
        txtEntName.setForeground(new java.awt.Color(0, 51, 51));

        btnAddOrg.setBackground(new java.awt.Color(255, 0, 51));
        btnAddOrg.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnAddOrg.setForeground(new java.awt.Color(255, 204, 204));
        btnAddOrg.setText("Add Organization ");
        btnAddOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrgActionPerformed(evt);
            }
        });

        btnManageUsers.setBackground(new java.awt.Color(255, 0, 51));
        btnManageUsers.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnManageUsers.setForeground(new java.awt.Color(255, 204, 204));
        btnManageUsers.setText("Manage Users");
        btnManageUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageUsersActionPerformed(evt);
            }
        });

        jButtonManageQ.setBackground(new java.awt.Color(255, 0, 51));
        jButtonManageQ.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jButtonManageQ.setForeground(new java.awt.Color(255, 204, 204));
        jButtonManageQ.setText("Manage Work Request Queue");
        jButtonManageQ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonManageQActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAddOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEntName, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButtonManageQ, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnManageUsers, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEntName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnAddOrg)
                .addGap(26, 26, 26)
                .addComponent(btnManageUsers)
                .addGap(30, 30, 30)
                .addComponent(jButtonManageQ)
                .addContainerGap(263, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrgActionPerformed
     
            CardLayout layout = (CardLayout) container.getLayout();
            AddOrganizationUnitJPanel addOrgPanel = new AddOrganizationUnitJPanel(container, loggedUser);
            container.add("AddOrganizationUnitJPanel", addOrgPanel);
            layout.next(container);
    }//GEN-LAST:event_btnAddOrgActionPerformed

    private void btnManageUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageUsersActionPerformed
       CardLayout layout = (CardLayout) container.getLayout();
       ManageUsersOrganizationalJPanel addOrgPanel = new ManageUsersOrganizationalJPanel(container, loggedUser);
       container.add("ManageUsersOrganizationalJPanel", addOrgPanel);
       layout.next(container);
    }//GEN-LAST:event_btnManageUsersActionPerformed

    private void jButtonManageQActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonManageQActionPerformed
        // TODO add your handling code here:
       if(loggedUser.getEnterpriseType().equals("Government")){ 
        CardLayout layout = (CardLayout) container.getLayout();
        GovernmentWorkRequests govWR = new GovernmentWorkRequests(container, loggedUser, txtEntName.getText());
       container.add("GovernmentWorkRequests", govWR);
       layout.next(container);
       }else{
          CardLayout layout = (CardLayout) container.getLayout();
            RecyclerWorkRequests recyclerEnt = new RecyclerWorkRequests(container,loggedUser);
            container.add("RecyclerWorkRequests", recyclerEnt);
            layout.next(container);
       }
        
    }//GEN-LAST:event_jButtonManageQActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOrg;
    private javax.swing.JButton btnManageUsers;
    private javax.swing.JButton jButtonManageQ;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel txtEntName;
    // End of variables declaration//GEN-END:variables
}
