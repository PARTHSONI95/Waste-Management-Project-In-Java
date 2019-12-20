/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.AdminUserDTO;
import Business.EnterpriseDTO;
import Business.LoggedUserDTO;
import Business.RequestDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Types.NULL;
import java.util.ArrayList;

/**
 *
 * @author SHREE GANESH
 */
public class ManageAdminDAO {

    // whether enterprise or organization



    public static LoggedUserDTO checkUserLoginType(String username, String password){

        DbConnection con = new DbConnection();
        PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();

        LoggedUserDTO userLogged = null;
        try {
            String sql = "SELECT * FROM aedfinalproject.user_details where user_name = ? and user_password = ?";
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, username);
            prepStmt.setString(2, password);

            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                userLogged = new LoggedUserDTO(username, password, rs.getString("user_enterprise"), rs.getString("user_enterprise_type"), rs.getString("user_organization"), rs.getString("user_network"), rs.getString("user_role"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (prepStmt != null) {
                    prepStmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return userLogged;

    }

    public static void insertNetwork(String networkName) {

        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        
        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO network_details VALUES (" + null + ",'" + networkName + "')";

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public static ArrayList<String> selectNetwork() {

        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<String> requestArrayList = new ArrayList<String>();

        try {
            stmt = conn.createStatement();
            String sql = "SELECT network_name FROM network_details";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                requestArrayList.add(rs.getString("network_name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return requestArrayList;
    }

    public static ArrayList<String> selectToBeAssignedUnitNames(String enterpriseType, String organizationName) {

        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<String> requestArrayList = new ArrayList<String>();

        try {
            stmt = conn.createStatement();
            String sql = "SELECT enterprise_name FROM enterprise_details where network_name = '";
                    
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                requestArrayList.add(rs.getString("enterprise_name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return requestArrayList;
    }
    
    public static boolean checkQualityApproved(int requestId){
     DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        

        try {
            stmt = conn.createStatement();
            String sql = "SELECT is_quality_approved FROM request_workflow where  is_quality_approved IN ('Pass','Fail') AND request_id = '" + requestId + "'";
                    
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
            if(rs.getString("is_quality_approved").equals("Pass") || rs.getString("is_quality_approved").equals("Fail")){
                return true;
            
            }
            

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return false;
    
    }
    public static ArrayList<String> selectEnterprise(String networkName) {

        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<String> requestArrayList = new ArrayList<String>();

        try {
            stmt = conn.createStatement();
            String sql = "SELECT enterprise_name FROM enterprise_details where network_name = '" + networkName + "'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                requestArrayList.add(rs.getString("enterprise_name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return requestArrayList;
    }

    public static ArrayList<String> selectOrganization(String enterpriseName) {

        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<String> requestArrayList = new ArrayList<String>();

        try {

            stmt = conn.createStatement();
            String sql = "SELECT org_name FROM organization_details where enterprise_name LIKE '%" + enterpriseName + "%'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {

                requestArrayList.add(rs.getString("org_name"));

            }
        } catch (SQLException e) {

         
            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return requestArrayList;
    }

    public static void insertEnterprise(EnterpriseDTO enterprise) {

        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();

        try {
            stmt = conn.createStatement();
            String sql = "INSERT INTO enterprise_details VALUES (" + null + ",'" + enterprise.getEnterpriseName() + "','" + enterprise.getEnterpriseType() + "','" + enterprise.getNetworkName() + "')";

            stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    public static ArrayList<EnterpriseDTO> selectEnterprise() {

        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<EnterpriseDTO> requestArrayList = new ArrayList<EnterpriseDTO>();

        try {
            stmt = conn.createStatement();
            String sql = "SELECT enterprise_name, enterprise_type, network_name FROM enterprise_details";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                EnterpriseDTO entps = new EnterpriseDTO(rs.getString("enterprise_name"), rs.getString("enterprise_type"), rs.getString("network_name"));
                requestArrayList.add(entps);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return requestArrayList;
    }

    public static void insertEnterpriseUser(AdminUserDTO user) {

        DbConnection con = new DbConnection();
        PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();

        try {
            String sql = "INSERT INTO aedfinalproject.user_details VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            prepStmt = conn.prepareStatement(sql);

            prepStmt.setInt(1, NULL);
            prepStmt.setString(2, user.getUserName());
            prepStmt.setString(3, user.getPassword());
            prepStmt.setString(4, "Admin"); // Admin Role
            prepStmt.setString(5, user.getNetworkName());
            prepStmt.setString(6, user.getEnterpriseName());
            prepStmt.setString(7, user.getEnterpriseType());
            prepStmt.setString(8, "NA");
            prepStmt.setString(9, "NA");
            prepStmt.setString(10, user.getCity());
            prepStmt.setString(11, user.getState());
            prepStmt.setString(12, "NA");
            prepStmt.setString(13, user.getEmailId());
            prepStmt.setString(14, user.getPhoneNo());
            prepStmt.setString(15, "");

            prepStmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (prepStmt != null) {
                    prepStmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
    
    public static ArrayList<String> selectAllAdminUsers() {

        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<String> requestArrayList = new ArrayList<String>();

        try {
            stmt = conn.createStatement();
            String sql = "SELECT user_name FROM user_details";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                
                requestArrayList.add(rs.getString("user_name"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return requestArrayList;
    }
    
    

    public static ArrayList<AdminUserDTO> populateEntAdminTable() {

        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<AdminUserDTO> requestArrayList = new ArrayList<AdminUserDTO>();

        try {
            stmt = conn.createStatement();
            String sql = "SELECT user_enterprise, user_network, user_name FROM aedfinalproject.user_details";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                AdminUserDTO entps = new AdminUserDTO(rs.getString("user_name"), rs.getString("user_network"), rs.getString("user_enterprise"));
                requestArrayList.add(entps);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return requestArrayList;

    }

    public static String getEnterpriseTypeOfName(String enterpriseName) {
        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        String entType = "";

        try {
            stmt = conn.createStatement();
            String sql = "SELECT enterprise_type FROM enterprise_details where enterprise_name = '" + enterpriseName + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                entType = rs.getString("enterprise_type");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return entType;

    }

   
    
    public static ArrayList<String> getOrgNamesOfFirstLoggedEnterprise(LoggedUserDTO loggedUser) {
       DbConnection con = new DbConnection();

        Statement stmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<String> orgNameList = new ArrayList<>();

        try {

            stmt = conn.createStatement();
            String sql = "SELECT org_name FROM organization_details where enterprise_type = '" + loggedUser.getEnterpriseType() + "' AND enterprise_name NOT LIKE '%" + loggedUser.getEnterpriseName() + "%'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                orgNameList.add(rs.getString("org_name"));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return orgNameList;
    }

    public static ArrayList<String> getOrgNamesOfEnterpriseToAddUsers(LoggedUserDTO loggedUser) {
        DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<String> orgNameList = new ArrayList<>();

        try {
            stmt = conn.createStatement();
            String sql = "SELECT org_name FROM organization_details where enterprise_type = '" + loggedUser.getEnterpriseType() + "' AND enterprise_name LIKE '%" + loggedUser.getEnterpriseName() + "%'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                orgNameList.add(rs.getString("org_name"));
            }

        } catch (SQLException e) {

        
            e.printStackTrace();
        } finally {
            try {

                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return orgNameList;

    }

    
    public static String getPreviousEnterpriseNamesFromOrg(String orgName) {
       DbConnection con = new DbConnection();
        Statement stmt = null;
        Connection conn = con.getDbConnection();
        String output = "";
        
        try {
        stmt = conn.createStatement();      
        String sql = "SELECT enterprise_name FROM organization_details where org_name = '" + orgName + "'" ;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next())
        output = rs.getString("enterprise_name");
       
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
        return output;
    } 
    
    public static void insertEntpsDetailsInOrgDetails(LoggedUserDTO user, String orgName) {

        DbConnection con = new DbConnection();
        PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();
        String getPreviousEnterpriseNames = getPreviousEnterpriseNamesFromOrg(orgName);
        getPreviousEnterpriseNames = getPreviousEnterpriseNames + "," + user.getEnterpriseName();
        try {
            String sql = "UPDATE aedfinalproject.organization_details SET enterprise_name = ?, network_name = ? WHERE org_Name = ?";

            prepStmt = conn.prepareStatement(sql);

            prepStmt.setString(1, getPreviousEnterpriseNames);
            prepStmt.setString(2, user.getNetworkType());
            prepStmt.setString(3, orgName);

            prepStmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (prepStmt != null) {
                    prepStmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }   
   public static ArrayList<String> getOrgDetailsForEnterprise(LoggedUserDTO loggedUser) {
        DbConnection con = new DbConnection();
        PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<String> arrList = new ArrayList<String>();

        try {
            String sql = "SELECT org_name FROM aedfinalproject.organization_details where enterprise_name LIKE ? ";
            prepStmt = conn.prepareStatement(sql);
            prepStmt.setString(1, "%" + loggedUser.getEnterpriseName() + "%");
        //prepStmt.setString(2,loggedUser.getEnterpriseType());

            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                arrList.add(rs.getString("org_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (prepStmt != null) {
                    prepStmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return arrList;

    }
    public static void addOrganizationUserInDB(AdminUserDTO user, LoggedUserDTO loggedUser) {

        DbConnection con = new DbConnection();
        PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();

        try {
            String sql = "INSERT INTO aedfinalproject.user_details VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            prepStmt = conn.prepareStatement(sql);

            prepStmt.setInt(1, NULL);
            prepStmt.setString(2, user.getUserName());
            prepStmt.setString(3, user.getPassword());
            prepStmt.setString(4, "Admin"); // Admin Role
            prepStmt.setString(5, loggedUser.getNetworkType());
            prepStmt.setString(6, loggedUser.getEnterpriseName());
            prepStmt.setString(7, loggedUser.getEnterpriseType());
            prepStmt.setString(8, user.getOrganizationName());
            prepStmt.setString(9, "NA");
            prepStmt.setString(10, user.getCity());
            prepStmt.setString(11, "NA");
            prepStmt.setString(12, "NA");
            prepStmt.setString(13, "NA");
            prepStmt.setString(14, "NA");
            prepStmt.setString(15, "");

            prepStmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (prepStmt != null) {
                    prepStmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static ArrayList<AdminUserDTO> getOrgUsersDetails(LoggedUserDTO loggedUser) {

        DbConnection con = new DbConnection();
        PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<AdminUserDTO> arrList = new ArrayList<AdminUserDTO>();

        try {
            String sql = "SELECT user_name, user_organization FROM aedfinalproject.user_details where user_organization <> 'NA' AND user_enterprise ='" + loggedUser.getEnterpriseName() + "'";
            prepStmt = conn.prepareStatement(sql);
        //prepStmt.setString(2,loggedUser.getEnterpriseType());

            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                AdminUserDTO orgUsers = new AdminUserDTO(rs.getString("user_name"), rs.getString("user_organization"));
                arrList.add(orgUsers);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {

                if (prepStmt != null) {
                    prepStmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return arrList;

    }

    public static ArrayList<RequestDTO> selectRequestBasedOnEnterprise(LoggedUserDTO loggedUser) {
        DbConnection con = new DbConnection();
        PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<RequestDTO> arrList = new ArrayList<RequestDTO>();

        try {
            String sql = "SELECT request_user_name, request_creation_date, request_status, last_assigned_modified_date FROM aedfinalproject.request_workflow where request_assigned_enterprise ='" + loggedUser.getEnterpriseName() + "'";
            prepStmt = conn.prepareStatement(sql);
        //prepStmt.setString(2,loggedUser.getEnterpriseType());

            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
                RequestDTO currentRequestForLoggedUser = new RequestDTO(rs.getString("request_status"), rs.getDate("request_creation_date"), rs.getDate("last_assigned_modified_date"), rs.getString("request_user_name"));
                arrList.add(currentRequestForLoggedUser);
            }

        } catch (SQLException e) {
        }

        return arrList;
    }

    public static void insertDonorUser(AdminUserDTO user) {

        DbConnection con = new DbConnection();
        PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();

        try {
            String sql = "INSERT INTO aedfinalproject.user_details VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            prepStmt = conn.prepareStatement(sql);

            prepStmt.setInt(1, NULL);
            prepStmt.setString(2, user.getUserName());
            prepStmt.setString(3, user.getPassword());
            prepStmt.setString(4, "Donor"); // Admin Role
            prepStmt.setString(5, "NA");
            prepStmt.setString(6, "NA");
            prepStmt.setString(7, "NA");
            prepStmt.setString(8, "NA");
            prepStmt.setString(9, user.getAddress());
            prepStmt.setString(10, user.getCity());
            prepStmt.setString(11, user.getState());
            prepStmt.setString(12, user.getCountry());
            prepStmt.setString(13, user.getEmailId());
            prepStmt.setString(14, user.getPhoneNo());
            prepStmt.setString(15, "");

            prepStmt.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (prepStmt != null) {
                    prepStmt.close();
                }
                if (conn != null) {
                    conn.close();
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public static int analyzeTreesSavedFromPaper() {
        DbConnection con = new DbConnection();
        PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();
        int totalQuantityOfPaper = 0;

        try {
            String sql = "select sum(waste_quantity) from request_workflow where waste_type like '%paper%'";
            prepStmt = conn.prepareStatement(sql);
        //prepStmt.setString(2,loggedUser.getEnterpriseType());

            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
            totalQuantityOfPaper= rs.getInt(1);
            }

        } catch (SQLException e) {
          e.printStackTrace();
        }

        return totalQuantityOfPaper;
    }
    
    public static int analyzeTreesSavedFromWood() {
        DbConnection con = new DbConnection();
        PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();
        int totalQuantityOfWood = 0;

        try {
            String sql = "select sum(waste_quantity) from request_workflow where waste_type like '%wood%'";
            prepStmt = conn.prepareStatement(sql);
        //prepStmt.setString(2,loggedUser.getEnterpriseType());

            ResultSet rs = prepStmt.executeQuery();

            while (rs.next()) {
            totalQuantityOfWood= rs.getInt(1);
            }

        } catch (SQLException e) {
          e.printStackTrace();
        }

        return totalQuantityOfWood;
    }
    
   public static boolean checkNetworkNamePresentOrNot(String networkName){
       DbConnection con = new DbConnection();
        PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();
        

        try {
            String sql = "select count(*) from network_details where network_name = '"+networkName+"'";
            prepStmt = conn.prepareStatement(sql);
        //prepStmt.setString(2,loggedUser.getEnterpriseType());

            ResultSet rs = prepStmt.executeQuery();
            int nameCount=0;
            while (rs.next()) {
            nameCount= rs.getInt(1);
            }
            if(nameCount > 0){
            return true;
            }

        } catch (SQLException e) {
          e.printStackTrace();
        }

        return false;
   } 

    public static ArrayList<String> getEnterpriseBasedOnType(String enterpriseType) {
        DbConnection con = new DbConnection();
        PreparedStatement prepStmt = null;
        Connection conn = con.getDbConnection();
        ArrayList<String> requestList = new ArrayList<String>();

        try {
            String sql = "select user_name from user_details where user_enterprise_type = '"+enterpriseType+"' AND user_organization = 'NA'";
            prepStmt = conn.prepareStatement(sql);
        //prepStmt.setString(2,loggedUser.getEnterpriseType());

            ResultSet rs = prepStmt.executeQuery();
            int nameCount=0;
            while (rs.next()) {
            requestList.add(rs.getString("user_name"));
            }
            
        } catch (SQLException e) {
          e.printStackTrace();
        }

        return requestList;
    }
}
