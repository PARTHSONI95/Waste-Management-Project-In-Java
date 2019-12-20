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
public class EnterpriseDTO {

    private String enterpriseName;
    
    private String enterpriseType;
    
    private String networkName;

    public EnterpriseDTO(String enterpriseName, String enterpriseType, String networkName) {
        this.enterpriseName = enterpriseName;
        this.enterpriseType = enterpriseType;
        this.networkName = networkName;
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

    public String getNetworkName() {
        return networkName;
    }

    public void setNetworkName(String networkName) {
        this.networkName = networkName;
    }
    
    
    
}
