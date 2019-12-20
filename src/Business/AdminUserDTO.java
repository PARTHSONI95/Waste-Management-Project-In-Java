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
public class AdminUserDTO {
    
    private String userName;
    private String password;
    private String emailId;
    private String phoneNo;
    private String networkName;
    private String enterpriseName;
    private String enterpriseType;
    private String city;
    private String state; 
    private String address;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    // For org user;
    private String organizationName;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AdminUserDTO(String userName, String password, String emailId, String phoneNo, String networkName, String enterpriseName, String enterpriseType,  String city, String state) {
        this.userName = userName;
        this.password = password;
        this.emailId = emailId;
        this.phoneNo = phoneNo;
        this.networkName = networkName;
        this.enterpriseName = enterpriseName;
        this.enterpriseType = enterpriseType;
        this.city = city;
        this.state = state;
        
    }
    
    public AdminUserDTO(){};

    public AdminUserDTO(String userName, String networkName, String enterpriseName) {
        this.userName = userName;
        this.networkName = networkName;
        this.enterpriseName = enterpriseName;
    }

    public AdminUserDTO(String userName, String password, String organizationName, String city) {
        this.userName = userName;
        this.password = password;
        this.organizationName = organizationName;
        this.city = city;
    }

    public AdminUserDTO(String userName, String organizationName) {
        this.userName = userName;
        this.organizationName = organizationName;
    }
    
    
    
    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
    
    
    
}
