/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Planning;

import Business.LoggedUserDTO;
import Business.RequestDTO;
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
public class PlanningWorkRequests extends javax.swing.JPanel {

    /**
     * Creates new form PlanningWorkRequests
     */
    
    JPanel container;
    String reqUserName;
    LoggedUserDTO userLogged;
    public PlanningWorkRequests(JPanel userProcessContainer, LoggedUserDTO userLogged) {
        initComponents();
        
        this.container = userProcessContainer;
        this.userLogged = userLogged;
        populatePlanningWorkQ();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void populatePlanningWorkQ(){
        
      ProcessDao pDao = new ProcessDao();
      List<RequestDTO> resultList = pDao.getUnitWorkQ(userLogged.getUserName(), "Planning");
      
      DefaultTableModel dtm = (DefaultTableModel) jTablePlanningRequestQ.getModel();
        dtm.setRowCount(0);

        for (RequestDTO reqDetail : resultList) {
            Object[] row = new Object[20];
            
            row[0] = reqDetail;
            row[1] = reqDetail.getRequestUserName();
            row[2] = reqDetail.getRequestStatus();
            row[3] = reqDetail.getAssignedUnitRemarks();
            row[4] = reqDetail.getRequestCreationDate();
            //row[4] = reqDetail.getLastUnitAssignedDate();
            dtm.addRow(row);

        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePlanningRequestQ = new javax.swing.JTable();

        setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setText("Planning Department Request Queue");

        jButton1.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jButton1.setText("Take Action");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTablePlanningRequestQ.setBackground(new java.awt.Color(204, 255, 255));
        jTablePlanningRequestQ.setFont(new java.awt.Font("Century", 0, 12)); // NOI18N
        jTablePlanningRequestQ.setForeground(new java.awt.Color(0, 51, 51));
        jTablePlanningRequestQ.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request Id", "Requestor User Name", "Status", "Remark", "Created DTTM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablePlanningRequestQ);

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
                        .addGap(249, 249, 249)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(230, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = jTablePlanningRequestQ.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row from table first to view details.", "Warning",JOptionPane.WARNING_MESSAGE);
        }else{
            RequestDTO workreq = (RequestDTO) jTablePlanningRequestQ.getValueAt(selectedRow, 0);
            CardLayout layout = (CardLayout)container.getLayout();
            GovernmentPlanningScreen govtPlanning = new GovernmentPlanningScreen(container, (RequestDTO) workreq);
            container.add("GovernmentPlanningScreen", govtPlanning);
            layout.next(container);
        }
        
        
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePlanningRequestQ;
    // End of variables declaration//GEN-END:variables
}
