/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Business.RequestDTO;
import Business.RequestDetails;
import Business.RequestWorkFlowDTO;
import java.util.List;

/**
 *
 * @author ABC
 */
public interface Dao {
    
    void createUser(String roleName, String userName, String password, String address, String phnNo, String email, String city, String state, String country);
    
    void updateRequestDetails(int reqId, RequestDetails reqDetails);
    
    List<RequestDTO> getUnitWorkQ(String assignedUnit, String unit);
    
    void assignReqToEntrprise(int userName);
    
    void updateTransportRequestDetails(int reqId, RequestDetails reqDetails);
    
    List<String> getPlanningUnitsFromDb();
}
