/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Business.LoggedUserDTO;
import Business.RequestDTO;
import DAO.ProcessDao;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SHREE GANESH
 */
public class CollectionUnitJPanel extends javax.swing.JPanel {

    JPanel container;
    LoggedUserDTO loggedUser;
    /**
     * Creates new form CollectionUnitJPanel
     */
    public CollectionUnitJPanel(JPanel container, LoggedUserDTO loggedUser) {
        initComponents();
        this.container = container;
        this.loggedUser = loggedUser;
        populateTable();

    }

    public void populateTable() {
        ProcessDao dao = new ProcessDao();
        List<RequestDTO> allDonorReqs = dao.getUnitWorkQ(loggedUser.getUserName(), "Donor");

        //for (RequestDTO temp : allDonorReqs) {
         //   System.out.println("In Collection Unit");
          //  System.out.println(temp.getRequestId());
        //}

        DefaultTableModel dtm = (DefaultTableModel) tblHistoryRequest.getModel();
        dtm.setRowCount(0);

        for (RequestDTO donorReq : allDonorReqs) {

            Object[] row = new Object[dtm.getColumnCount()];
            row[0] = donorReq;
            row[1] = donorReq.getRequestStatus();
            row[2] = donorReq.getRequestCreationDate();
            row[3] = donorReq.getReqAssgnEntName();
            row[4] = donorReq.getLastUnitAssignedDate();
            row[5] = donorReq.getAssignedUnitRemarks();
            //System.out.println(a.getRequestUserName());
            dtm.addRow(row);

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
        tblHistoryRequest = new javax.swing.JTable();
        btnNewRequest = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblUserName = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 51, 0));
        setForeground(new java.awt.Color(0, 51, 0));

        tblHistoryRequest.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        tblHistoryRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Request_ID", "Current Status", "Date Requested", "Current Assigned Enterprise", "Modified Date", "Last Updated Remark"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHistoryRequest.setToolTipText("");
        jScrollPane1.setViewportView(tblHistoryRequest);
        if (tblHistoryRequest.getColumnModel().getColumnCount() > 0) {
            tblHistoryRequest.getColumnModel().getColumn(0).setResizable(false);
            tblHistoryRequest.getColumnModel().getColumn(1).setResizable(false);
            tblHistoryRequest.getColumnModel().getColumn(2).setResizable(false);
            tblHistoryRequest.getColumnModel().getColumn(3).setResizable(false);
            tblHistoryRequest.getColumnModel().getColumn(4).setResizable(false);
        }

        btnNewRequest.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        btnNewRequest.setText("Create New Request");
        btnNewRequest.setToolTipText("");
        btnNewRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewRequestActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("Request History");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnNewRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnNewRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNewRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewRequestActionPerformed
        List<String> planningUnitList;
        String[] units;
        ProcessDao dao = new ProcessDao();
        planningUnitList = dao.getPlanningUnitsFromDb();
        units = new String[planningUnitList.size()];
        Object[] objArr = planningUnitList.toArray(); 
        int i = 0; 
        for (Object obj : objArr) { 
            units[i++] = (String)obj; 
        }
        
        CardLayout layout = (CardLayout) container.getLayout();
        CollectionUnitRequestJPanel collectionReq = new CollectionUnitRequestJPanel(container, loggedUser, units);
        container.add("CollectionUnitRequestJPanel", collectionReq);
        layout.next(container);

    }//GEN-LAST:event_btnNewRequestActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTable tblHistoryRequest;
    // End of variables declaration//GEN-END:variables
}
