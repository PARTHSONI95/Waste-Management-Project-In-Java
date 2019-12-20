/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Constants;

/**
 *
 * @author ABC
 */
public interface QueryConstants {
     
         String planningWorkQQuery = "select * from aedfinalproject.request_workflow where request_assigned_unit = \"Planning\";";
         String governmentWorkQQuery = "select * from aedfinalproject.request_workflow where request_assigned_unit = \"Planning\" OR request_assigned_unit = \"Collection\";";
         String transportationWorkQQuery = "select * from aedfinalproject.request_workflow where request_assigned_unit = \"Transportation\" ";
         String getPlanningUnitsFromDb = "SELECT * FROM aedfinalproject.user_details where user_organization=\"Planning Unit\"";
}
