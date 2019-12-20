/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.RequestDTO;
import Business.RequestDetails;
import Business.RequestWorkFlowDTO;
import Interface.Constants.QueryConstants;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ABC
 */
public class ProcessDao implements Dao, QueryConstants{
    
    @Override
    public void createUser(String roleName, String userName, String password, String address, String phnNo, String email, String city, String state, String country){
        
        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        
        try {
        stmt = conn.createStatement();      
        String sql = "INSERT INTO user_details " +
                   "VALUES ("+null+",'"+userName +"', '"+password+"', '"+roleName+"','"+address+"','"+city+"','"+state+"','"+country+"','"+email+"','"+phnNo+"',"+null+")";
        stmt.executeUpdate(sql);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        } 
        
    }
    
    
    //Method to update request details into DB
    
    @Override
    public void updateRequestDetails( int reqId, RequestDetails reqDetails){
        
        LocalDateTime now = LocalDateTime.now();  
        DbConnection dbCon = new DbConnection();
        Connection con = dbCon.getDbConnection();       
        Statement stmt = null;
                
        try {
        stmt = con.createStatement();      
        
        String query = "UPDATE aedfinalproject.request_workflow "
            + "SET request_assigned_unit = '"+reqDetails.getAssignedUnit()+"', assigned_unit_remarks = '"+reqDetails.getRemark()+"', "
            + "waste_type='"+reqDetails.getWasteType()+"', waste_quantity='"+reqDetails.getWeight()+"', last_assigned_modified_date='"
            +now+"', predicted_savings='"+reqDetails.getPredictedSaving()
            + "', request_assigned_enterprise= 'Government', last_action_taken_unit='Planning' WHERE request_id='"+reqId+"'";
        
        stmt.executeUpdate(query);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }         
    }
    
    @Override
    public List<RequestDTO> getUnitWorkQ(String unitAssignedName, String unit){
        
        DbConnection dbCon = new DbConnection();       
        Statement stmt = null;
        Connection con = null;
        ResultSet rst = null;
        List<RequestDTO> reqDetailsList = new ArrayList<>();
        RequestDTO reqWfObj;
        String query = null;
        
        try{
            
            con = dbCon.getDbConnection();
            stmt = con.createStatement();
            
            if(unit.equalsIgnoreCase("Planning")){
                query = "select * from aedfinalproject.request_workflow where req_assgn_org_name = '"+unitAssignedName+"'";
            }
            if(unit.equalsIgnoreCase("Government")){
                query = "select * from aedfinalproject.request_workflow where req_assgn_ent_name = '"+unitAssignedName+"'";
            }
            
            if(unit.equalsIgnoreCase("Donor")){
                query = "select * from aedfinalproject.request_workflow where request_user_name = '"+unitAssignedName+"'";
            }
            
             if(unit.equalsIgnoreCase("Transportation")){
                query = "select * from aedfinalproject.request_workflow where req_assgn_ent_name = '"+unitAssignedName+"'";
            }
             
             if(unit.equalsIgnoreCase("Recycler")){
                query = "select * from aedfinalproject.request_workflow where req_assgn_org_name = '"+unitAssignedName+"'";
            }
             
              if(unit.equalsIgnoreCase("QA")){
                query = "select * from aedfinalproject.request_workflow where req_assgn_org_name = '"+unitAssignedName+"'";
            }
             if(unit.equalsIgnoreCase("RecPlant")){
                query = "select * from aedfinalproject.request_workflow where req_assgn_org_name = '"+unitAssignedName+"'";
            }
             if(unit.equalsIgnoreCase("ProdUnit")){
                query = "select * from aedfinalproject.request_workflow where req_assgn_org_name = '"+unitAssignedName+"'";
            }
            
            
            rst = stmt.executeQuery(query);
            
            while(rst.next()){
                //System.out.println(rst.getString("request_status"));
                reqWfObj = new RequestDTO();
                
                reqWfObj.setRequestId(rst.getInt("request_id"));
                reqWfObj.setRequestUserName(rst.getString("request_user_name"));
                reqWfObj.setRequestStatus(rst.getString("request_status"));
                reqWfObj.setRequestAssignedUnit(rst.getString("request_assigned_unit"));
                reqWfObj.setAssignedUnitRemarks(rst.getString("assigned_unit_remarks"));
                reqWfObj.setWasteType(rst.getString("waste_type"));
                reqWfObj.setWasteQuantity(rst.getString("waste_quantity"));
                reqWfObj.setRequestCreationDate(rst.getDate("request_creation_date"));
                reqWfObj.setLastUnitAssignedDate(rst.getDate("last_assigned_modified_date"));
                reqWfObj.setPredictedSavings(rst.getString("predicted_savings"));
                reqWfObj.setReqAssgnedEnterprise(rst.getString("request_assigned_enterprise"));
                reqWfObj.setLastActionTakenUnit(rst.getString("last_action_taken_unit"));
                reqWfObj.setReqAssgnOrgName(rst.getString("req_assgn_org_name"));
                reqWfObj.setReqAssgnEntName(rst.getString("req_assgn_ent_name"));
                reqDetailsList.add(reqWfObj);
            }
        } catch(Exception ex){
            ex.printStackTrace();          
        }finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
            if(rst != null){
                rst.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        
        return reqDetailsList;
    }
    
    @Override
    public void assignReqToEntrprise(int reqId){
        
        DbConnection dbCon = new DbConnection();       
        Statement stmt = null;
        Connection con = null;
        ResultSet rst = null;
        String query = null;
        LocalDateTime now = LocalDateTime.now();
        
        try {
        con = dbCon.getDbConnection();
        stmt = con.createStatement();     
        
        query = "UPDATE aedfinalproject.request_workflow "
            + "SET request_assigned_unit = 'Transportation', request_assigned_enterprise = 'Transportation', last_assigned_modified_date='"+now+"' WHERE request_id='"+reqId+"'";
        
        stmt.executeUpdate(query);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
             
            if(con != null){
                con.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void updateTransportRequestDetails( int reqId, RequestDetails reqDetails){
        
        LocalDateTime now = LocalDateTime.now();  
        DbConnection dbCon = new DbConnection();
        Connection con = dbCon.getDbConnection();       
        Statement stmt = null;
                
        try {
        stmt = con.createStatement();      
        
        String query = "UPDATE aedfinalproject.request_workflow "
            + "SET request_assigned_unit = '"+reqDetails.getAssignedUnit()+"', assigned_unit_remarks = '"+reqDetails.getRemark()+"', "
            + "last_assigned_modified_date='"
            +now+"', request_assigned_enterprise= 'Recycling', last_action_taken_unit='Transportation' WHERE request_id='"+reqId+"'";
        
        stmt.executeUpdate(query);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }         
    }
	
	

    
    public static ArrayList<RequestDTO> selectUserHistory(){
        
        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<RequestDTO> requestArrayList = new ArrayList<>();
        
        try {
        stmt = conn.createStatement();      
        String sql = "SELECT request_id, request_status, request_creation_date, request_assigned_unit, last_assigned_modified_date, request_user_name, assigned_unit_remarks, waste_type, waste_quantity, predicted_savings FROM aedfinalproject.request_workflow";
        ResultSet rs = stmt.executeQuery(sql);
        
        while(rs.next()){
        //RequestDTO request = new RequestDTO(rs.getInt("request_id"),rs.getString("request_status"),rs.getDate("request_creation_date"),rs.getString("request_assigned_unit"),rs.getDate("last_assigned_modified_date"), rs.getString("request_user_name"),rs.getString("assigned_unit_remarks"),rs.getString("waste_type"), rs.getString("waste_quantity"), rs.getString("predicted_savings"));
        //requestArrayList.add(request);
        
        }
        } catch(SQLException e){
            e.printStackTrace();
        } finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
            if(conn != null){
                conn.close();
            }
            } catch (SQLException ex){
                ex.printStackTrace();
            }
        } 
       return requestArrayList; 
    }
    
    
    @Override
    public List<String> getPlanningUnitsFromDb(){
        
        DbConnection dbCon = new DbConnection();       
        Statement stmt = null;
        Connection con = null;
        ResultSet rst = null;
        List<String> planningUnitList = new ArrayList<>();
        RequestWorkFlowDTO reqWfObj;
        String query = getPlanningUnitsFromDb;
        
         try{
            
            con = dbCon.getDbConnection();
            stmt = con.createStatement();           
            rst = stmt.executeQuery(query);
            
            while(rst.next()){
                
                planningUnitList.add(rst.getString("user_name"));
                
            }
        } catch(Exception ex){
            ex.printStackTrace();          
        }finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
            if(rst != null){
                rst.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        return planningUnitList;
    }
    
    public String getEntName(String userName){
        String retrieveOrgName = null;
        DbConnection dbCon = new DbConnection();       
        Statement stmt = null;
        Connection con = null;
        ResultSet rst = null;
        //String query = "SELECT user_name FROM aedfinalproject.user_details WHERE user_name = '"+userName+"'; ";
        
        String query = "SELECT user_name FROM aedfinalproject.user_details WHERE user_enterprise_type = 'Government' and user_organization='NA'; ";
        
        
         try{
            
            con = dbCon.getDbConnection();
            stmt = con.createStatement();           
            rst = stmt.executeQuery(query);
            
            while(rst.next()){
                
                retrieveOrgName = rst.getString("user_name");
                
            }
        } catch(Exception ex){
            ex.printStackTrace();          
        }finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
            if(rst != null){
                rst.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        
        return retrieveOrgName;
    }
    
    
    public static void insertReqInDb(RequestDTO dto){
        
         DbConnection con = new DbConnection();
          PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();
        
        try {
        String sql = "INSERT INTO aedfinalproject.request_workflow VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        prepStmt = conn.prepareStatement(sql);      
        //Date now = new Date();
        prepStmt.setInt(1,NULL);
        prepStmt.setString(2,dto.getRequestUserName());
        prepStmt.setString(3,dto.getRequestStatus());
        prepStmt.setString(4,dto.getRequestAssignedUnit()); // Admin Role
        prepStmt.setString(5,"Request assigned to Planning Unit");
        prepStmt.setString(6,"NA");
        prepStmt.setString(7,"NA");
        prepStmt.setDate(8,new java.sql.Date(dto.getRequestCreationDate().getTime()));
        prepStmt.setDate(9,new java.sql.Date(dto.getLastUnitAssignedDate().getTime()));
        prepStmt.setString(10,null);
        prepStmt.setString(11,dto.getReqAssgnedEnterprise());
        prepStmt.setString(12,"NA");
        prepStmt.setString(13,dto.getReqAssgnOrgName());
        prepStmt.setString(14, dto.getReqAssgnEntName());
        

        prepStmt.setString(15,"");
        prepStmt.setString(16,"");
        prepStmt.setString(17,"");
        prepStmt.setString(18,"");
        
        
        prepStmt.execute();
        
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                
             if(prepStmt != null){
                prepStmt.close();
            }
            if(conn != null){
                conn.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }  
    }
    
    public static List<String> getAllEntNameForEntType(String entType){
        ArrayList<String> allEntNames = new ArrayList<>();
        
        DbConnection dbCon = new DbConnection();       
        Statement stmt = null;
        Connection con = null;
        ResultSet rst = null;
        String query ;
        
        if(entType.equalsIgnoreCase("QualityAssurance")){
            query = "SELECT user_name FROM aedfinalproject.user_details where user_organization = 'Quality Assurance'";
        }else{
            query = "SELECT user_name FROM aedfinalproject.user_details WHERE user_enterprise_type = '"+entType+"'; ";
        }
        
         try{
            
            con = dbCon.getDbConnection();
            stmt = con.createStatement();           
            rst = stmt.executeQuery(query);
            
            while(rst.next()){
                
                allEntNames.add(rst.getString("user_name"));
                
            }
        } catch(Exception ex){
            ex.printStackTrace();          
        }finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
            if(rst != null){
                rst.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        
        return allEntNames;
    }
    
    
    
    public static void updateReqInDBFromTransport( int reqId, RequestDTO reqDTO){
        
        LocalDateTime now = LocalDateTime.now();  
        DbConnection dbCon = new DbConnection();
        Connection con = dbCon.getDbConnection();       
        Statement stmt = null;
                
        try {
        stmt = con.createStatement();      
        String query="";
        if(reqDTO.getRequestStatus() != null){
        query = "UPDATE aedfinalproject.request_workflow "
            + "SET req_assgn_org_name = '"+reqDTO.getReqAssgnOrgName()+"', req_assgn_ent_name = '"+reqDTO.getReqAssgnEntName()+"', assigned_unit_remarks = '"+reqDTO.getAssignedUnitRemarks()+"', "
            + "last_assigned_modified_date='"
            +now+"', last_action_taken_unit='"+reqDTO.getLastActionTakenUnit()+"', request_status = '" + reqDTO.getRequestStatus() + "' WHERE request_id='"+reqId+"'";
        }else{
        query = "UPDATE aedfinalproject.request_workflow "
            + "SET req_assgn_org_name = '"+reqDTO.getReqAssgnOrgName()+"', req_assgn_ent_name = '"+reqDTO.getReqAssgnEntName()+"', assigned_unit_remarks = '"+reqDTO.getAssignedUnitRemarks()+"', "
            + "last_assigned_modified_date='"
            +now+"', last_action_taken_unit='"+reqDTO.getLastActionTakenUnit()+"' WHERE request_id='"+reqId+"'";
        
        }
        stmt.executeUpdate(query);
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }         
    }
    
    
     public static List<String> getEnterpriseForTrans(String enterpriseType){
        
        DbConnection dbCon = new DbConnection();       
        Statement stmt = null;
        Connection con = null;
        ResultSet rst = null;
        List<String> reclyclerEntList = new ArrayList<>();
        //RequestDTO reqWfObj;
        String query = null;
        
        try{
            
            con = dbCon.getDbConnection();
            stmt = con.createStatement();
            
            query = "SELECT * FROM aedfinalproject.user_details where user_enterprise_type='"+ enterpriseType +"' AND user_organization=\"NA\";";
                  
            rst = stmt.executeQuery(query);
            
            while(rst.next()){
               reclyclerEntList.add(rst.getString("user_name"));
            }
        } catch(Exception ex){
            ex.printStackTrace();          
        }finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
            if(rst != null){
                rst.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        
        return reclyclerEntList;
        }
     
     
     public static void updateReqInDBFromRecycler( int reqId, RequestDTO reqDTO, String from){
        
        LocalDateTime now = LocalDateTime.now();  
        DbConnection dbCon = new DbConnection();
        Connection con = dbCon.getDbConnection();       
        Statement stmt = null;
         String query = null;
        try {
        stmt = con.createStatement();      
        
        if(from.equalsIgnoreCase("Transportation")){
        query = "UPDATE aedfinalproject.request_workflow "
            + "SET req_assgn_org_name = '"+reqDTO.getReqAssgnOrgName()+"', req_assgn_ent_name = '"+reqDTO.getReqAssgnEntName()+"', assigned_unit_remarks = '"+reqDTO.getAssignedUnitRemarks()+"', "
            + "last_assigned_modified_date='"
            +now+"', last_action_taken_unit='"+reqDTO.getLastActionTakenUnit()+"', request_assigned_unit = '"+reqDTO.getRequestAssignedUnit()+"' WHERE request_id='"+reqId+"'";
        }
        if(from.equalsIgnoreCase("QA")){
            query = "UPDATE aedfinalproject.request_workflow "
            + "SET req_assgn_org_name = '"+reqDTO.getReqAssgnOrgName()+"', req_assgn_ent_name = '"+reqDTO.getReqAssgnEntName()+"', assigned_unit_remarks = '"+reqDTO.getAssignedUnitRemarks()+"', "
            + "last_assigned_modified_date='"
            +now+"', last_action_taken_unit='"+reqDTO.getLastActionTakenUnit()+"', request_assigned_unit = '"+reqDTO.getRequestAssignedUnit()+"' , is_quality_approved = '"+reqDTO.getIsQualityApproved()+"', request_assigned_enterprise = '"+reqDTO.getReqAssgnedEnterprise()+"' WHERE request_id='"+reqId+"'";
        }
        if(from.equalsIgnoreCase("RecPlant")){
            query = "UPDATE aedfinalproject.request_workflow "
            + "SET req_assgn_org_name = '"+reqDTO.getReqAssgnOrgName()+"', req_assgn_ent_name = '"+reqDTO.getReqAssgnEntName()+"', assigned_unit_remarks = '"+reqDTO.getAssignedUnitRemarks()+"', "
            + "last_assigned_modified_date='"
            +now+"', last_action_taken_unit='"+reqDTO.getLastActionTakenUnit()+"', request_assigned_unit = '"+reqDTO.getRequestAssignedUnit()+"' , no_of_products_obtained = '"+reqDTO.getNoOfProductsObtained()+"', request_assigned_enterprise = '"+reqDTO.getReqAssgnedEnterprise()+"', produced_product_type = '"+reqDTO.getProducedProductType()+"' WHERE request_id='"+reqId+"'";
        }

        stmt.executeUpdate(query);
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }         
    }
     
     
     public static List<String> getAllUsersForEnt(String entType, String userOrg){
        ArrayList<String> allUsers = new ArrayList<>();
        
        DbConnection dbCon = new DbConnection();       
        Statement stmt = null;
        Connection con = null;
        ResultSet rst = null;
        String query ;
             
            query = "SELECT user_name FROM aedfinalproject.user_details WHERE user_enterprise_type = '"+entType+"' and user_organization = '"+userOrg+"' ";
             
         try{
            
            con = dbCon.getDbConnection();
            stmt = con.createStatement();           
            rst = stmt.executeQuery(query);
            
            while(rst.next()){
                
                allUsers.add(rst.getString("user_name"));
                
            }
        } catch(Exception ex){
            ex.printStackTrace();          
        }finally {
            try{
                
             if(stmt != null){
                stmt.close();
            }
            if(con != null){
                con.close();
            }
            if(rst != null){
                rst.close();
            }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        
        return allUsers;
    }
     
     
     
     
    
}
        