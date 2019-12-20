/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author SHREE GANESH
 */
public class RequestDTO {
    
    private int requestId;
    private String requestStatus;
    private Date requestCreationDate;
    private String requestAssignedUnit;
    private Date lastUnitAssignedDate;
    
    // Detailed View needs
    private String requestUserName; 
    private String assignedUnitRemarks;
    private String wasteType;
    private String wasteQuantity;
    private String predictedSavings;
    
    //HRS
    private String reqAssgnedEnterprise;
    private String lastActionTakenUnit;
    private String reqAssgnOrgName;
    private String reqAssgnEntName;
    private String isWasteRecycled;
    private String noOfProductsObtained;
    private String isQualityApproved;
    private String producedProductType;

    public String getProducedProductType() {
        return producedProductType;
    }

    public void setProducedProductType(String producedProductType) {
        this.producedProductType = producedProductType;
    }

    public String getIsWasteRecycled() {
        return isWasteRecycled;
    }

    public void setIsWasteRecycled(String isWasteRecycled) {
        this.isWasteRecycled = isWasteRecycled;
    }

    public String getNoOfProductsObtained() {
        return noOfProductsObtained;
    }

    public void setNoOfProductsObtained(String noOfProductsObtained) {
        this.noOfProductsObtained = noOfProductsObtained;
    }

    public String getIsQualityApproved() {
        return isQualityApproved;
    }

    public void setIsQualityApproved(String isQualityApproved) {
        this.isQualityApproved = isQualityApproved;
    }
    
    public RequestDTO(int requestId, String requestStatus, Date requestCreationDate, String requestAssignedUnit, Date lastUnitAssignedDate, String requestUserName, String assignedUnitRemarks, String wasteType, String wasteQuantity, String predictedSavings, String reqAssgnedEnterprise, String lastActionTakenUnit, String reqAssgnOrgName, String reqAssgnEntName ) {
        this.requestId = requestId;
        this.requestStatus = requestStatus;
        this.requestCreationDate = requestCreationDate;
        this.requestAssignedUnit = requestAssignedUnit;
        this.lastUnitAssignedDate = lastUnitAssignedDate;
        this.requestUserName = requestUserName;
        this.assignedUnitRemarks = assignedUnitRemarks;
        this.wasteType = wasteType;
        this.wasteQuantity = wasteQuantity;
        this.predictedSavings = predictedSavings;
        this.reqAssgnedEnterprise = reqAssgnedEnterprise;
        this.lastActionTakenUnit = lastActionTakenUnit;
        this.reqAssgnOrgName = reqAssgnOrgName;
        this.reqAssgnEntName = reqAssgnEntName;
    }
    
    public RequestDTO(){}
    
    public RequestDTO(String requestStatus, Date requestCreationDate, Date lastUnitAssignedDate, String requestUserName) {
        this.requestStatus = requestStatus;
        this.requestCreationDate = requestCreationDate;
        this.lastUnitAssignedDate = lastUnitAssignedDate;
        this.requestUserName = requestUserName;
    }

    public String getAssignedUnitRemarks() {
        return assignedUnitRemarks;
    }

    public void setAssignedUnitRemarks(String assignedUnitRemarks) {
        this.assignedUnitRemarks = assignedUnitRemarks;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public String getWasteQuantity() {
        return wasteQuantity;
    }

    public void setWasteQuantity(String wasteQuantity) {
        this.wasteQuantity = wasteQuantity;
    }

    public String getPredictedSavings() {
        return predictedSavings;
    }

    public void setPredictedSavings(String predictedSavings) {
        this.predictedSavings = predictedSavings;
    }

    public String getRequestUserName() {
        return requestUserName;
    }

    public void setRequestUserName(String requestUserName) {
        this.requestUserName = requestUserName;
    }
    
    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Date getRequestCreationDate() {
        return requestCreationDate;
    }

    public void setRequestCreationDate(Date requestCreationDate) {
        this.requestCreationDate = requestCreationDate;
    }

    public String getRequestAssignedUnit() {
        return requestAssignedUnit;
    }

    public void setRequestAssignedUnit(String requestAssignedUnit) {
        this.requestAssignedUnit = requestAssignedUnit;
    }

    public Date getLastUnitAssignedDate() {
        return lastUnitAssignedDate;
    }

    public void setLastUnitAssignedDate(Date lastUnitAssignedDate) {
        this.lastUnitAssignedDate = lastUnitAssignedDate;
    }
    
     public String getReqAssgnedEnterprise() {
        return reqAssgnedEnterprise;
    }

    public void setReqAssgnedEnterprise(String reqAssgnedEnterprise) {
        this.reqAssgnedEnterprise = reqAssgnedEnterprise;
    }

    public String getLastActionTakenUnit() {
        return lastActionTakenUnit;
    }

    public void setLastActionTakenUnit(String lastActionTakenUnit) {
        this.lastActionTakenUnit = lastActionTakenUnit;
    }

    public String getReqAssgnOrgName() {
        return reqAssgnOrgName;
    }

    public void setReqAssgnOrgName(String reqAssgnOrgName) {
        this.reqAssgnOrgName = reqAssgnOrgName;
    }

    public String getReqAssgnEntName() {
        return reqAssgnEntName;
    }

    public void setReqAssgnEntName(String reqAssgnEntName) {
        this.reqAssgnEntName = reqAssgnEntName;
    }

    @Override
    public String toString() {
        return String.valueOf(requestId);
    }
    
    
    
    
    
}
