/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.OrganizationalAdmin;

import Business.EnterpriseDTO;
import Business.LoggedUserDTO;
import DAO.ManageAdminDAO;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SHREE GANESH
 */
public class AddOrganizationUnitJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddOrganizationUnitJPanel
     */
    
    private JPanel container;
    private LoggedUserDTO loggedUser;
    public AddOrganizationUnitJPanel(JPanel container, LoggedUserDTO loggedUser) {
        initComponents();
        this.container = container;
        this.loggedUser = loggedUser;
        populateOrgTypeBox();
        populateTable();
    }

    public void populateTable(){
    
        ArrayList<String> orgVals = ManageAdminDAO.getOrgDetailsForEnterprise(loggedUser);
        DefaultTableModel dtm = (DefaultTableModel) tblOrganization.getModel();
        dtm.setRowCount(0);
        int i=0;
        for(String s: orgVals){
            
            Object[] row = new Object[dtm.getColumnCount()];
            row[0] = ++i;
            row[1] = s;
            dtm.addRow(row); 
        }
    
    }
    public void populateOrgTypeBox(){
    
        ArrayList<String> arr = ManageAdminDAO.getOrgNamesOfFirstLoggedEnterprise(loggedUser);
        cmbOrgList.removeAllItems();
        for(String a: arr){
        cmbOrgList.addItem(a);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrganization = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cmbOrgList = new javax.swing.JComboBox();
        backJButton = new javax.swing.JButton();
        btnAddOrg = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 255));

        tblOrganization.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Name"
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
        jScrollPane1.setViewportView(tblOrganization);

        jLabel1.setText("Organization Type ");

        cmbOrgList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        cmbOrgList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOrgListActionPerformed(evt);
            }
        });

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        btnAddOrg.setText("Add Organization");
        btnAddOrg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddOrgMouseClicked(evt);
            }
        });
        btnAddOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrgActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel2.setText("ADD NEW ORGANIZATION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbOrgList, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(backJButton)
                        .addGap(39, 39, 39)
                        .addComponent(btnAddOrg)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbOrgList, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddOrg)
                    .addComponent(backJButton))
                .addGap(88, 88, 88))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed

        this.container.remove(this);
        CardLayout layout = (CardLayout) container.getLayout();
        layout.previous(container);
      
      
    }//GEN-LAST:event_backJButtonActionPerformed

    private void btnAddOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrgActionPerformed
    if(cmbOrgList.getSelectedItem() == null){
    JOptionPane.showMessageDialog(null, "No Unit Left to be taken", "Warning",JOptionPane.WARNING_MESSAGE);
    }
    else{    
    ManageAdminDAO.insertEntpsDetailsInOrgDetails(loggedUser, cmbOrgList.getSelectedItem().toString());
    System.out.println("Enterprise Details logged in for" + loggedUser.getUserName());
    populateTable();
    populateOrgTypeBox();
    }
        
    }//GEN-LAST:event_btnAddOrgActionPerformed

    private void cmbOrgListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOrgListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbOrgListActionPerformed

    private void btnAddOrgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddOrgMouseClicked
        // TODO add your handling code here:
        populateTable();
        populateOrgTypeBox();
    }//GEN-LAST:event_btnAddOrgMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnAddOrg;
    private javax.swing.JComboBox cmbOrgList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrganization;
    // End of variables declaration//GEN-END:variables
}
