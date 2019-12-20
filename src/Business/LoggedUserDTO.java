/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author SHREE GANESH
 */
public class LoggedUserDTO {
    
    private String userName;
    private String password;
    private String enterpriseName;
    private String organizationName;
    private String enterpriseType;
    private String networkType;
    private String userRole;

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoggedUserDTO(String userName, String password, String enterpriseName, String enterpriseType , String organizationName, String networkType, String userRole) {
        this.userName = userName;
        this.password = password;
        this.enterpriseName = enterpriseName;
        this.enterpriseType  =enterpriseType;
        this.organizationName = organizationName;
        this.networkType = networkType;
        this.userRole = userRole;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    
    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

   

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
    
    
    
    
}
