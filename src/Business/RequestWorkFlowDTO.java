/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author ABC
 */
public class RequestWorkFlowDTO {
    
    int reqId;
    String reqUserName;
    String reqStatus;
    String reqAssignedUnit;
    String assignedunitRemark;
    String wasteType;
    String wasteQuantity;
    Date reqCreationDttm;
    Date reqModifiedDttm;
    int predictedSaving;
    String reqAssignedEnterprise;
    String lastActionTakenBy;

    public String getLastActionTakenBy() {
        return lastActionTakenBy;
    }

    public void setLastActionTakenBy(String lastActionTakenBy) {
        this.lastActionTakenBy = lastActionTakenBy;
    }

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public String getReqUserName() {
        return reqUserName;
    }

    public void setReqUserName(String reqUserName) {
        this.reqUserName = reqUserName;
    }

    public String getReqStatus() {
        return reqStatus;
    }

    public void setReqStatus(String reqStatus) {
        this.reqStatus = reqStatus;
    }

    public String getReqAssignedUnit() {
        return reqAssignedUnit;
    }

    public void setReqAssignedUnit(String reqAssignedUnit) {
        this.reqAssignedUnit = reqAssignedUnit;
    }

    public String getAssignedunitRemark() {
        return assignedunitRemark;
    }

    public void setAssignedunitRemark(String assignedunitRemark) {
        this.assignedunitRemark = assignedunitRemark;
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

    public Date getReqCreationDttm() {
        return reqCreationDttm;
    }

    public void setReqCreationDttm(Date reqCreationDttm) {
        this.reqCreationDttm = reqCreationDttm;
    }

    public Date getReqModifiedDttm() {
        return reqModifiedDttm;
    }

    public void setReqModifiedDttm(Date reqModifiedDttm) {
        this.reqModifiedDttm = reqModifiedDttm;
    }

    public int getPredictedSaving() {
        return predictedSaving;
    }

    public void setPredictedSaving(int predictedSaving) {
        this.predictedSaving = predictedSaving;
    }

    public String getReqAssignedEnterprise() {
        return reqAssignedEnterprise;
    }

    public void setReqAssignedEnterprise(String reqAssignedEnterprise) {
        this.reqAssignedEnterprise = reqAssignedEnterprise;
    }

    @Override
    public String toString() {
        return reqUserName.toString();
    }

    
    
    
    
    
    
    
}
