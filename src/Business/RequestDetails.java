/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author ABC
 */
public class RequestDetails {
    
    String assignedUnit;
    String requestStatus;
    String remark;
    String wasteType;
    String weight;
    String predictedSaving;
    
    public RequestDetails() {};

    public String getAssignedUnit() {
        return assignedUnit;
    }

    public void setAssignedUnit(String assignedUnit) {
        this.assignedUnit = assignedUnit;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getWasteType() {
        return wasteType;
    }

    public void setWasteType(String wasteType) {
        this.wasteType = wasteType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPredictedSaving() {
        return predictedSaving;
    }

    public void setPredictedSaving(String predictedSaving) {
        this.predictedSaving = predictedSaving;
    }
    
    
    
    
}
