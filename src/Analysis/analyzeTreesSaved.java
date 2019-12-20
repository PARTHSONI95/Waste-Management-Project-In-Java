/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analysis;

import DAO.ManageAdminDAO;

/**
 *
 * @author SHREE GANESH
 */
public class analyzeTreesSaved {
    
    public double savedAmtOfTrees(){
    
    int totalQuantityFromPaper = ManageAdminDAO.analyzeTreesSavedFromPaper();
    
    int totalQuantityFromWood = ManageAdminDAO.analyzeTreesSavedFromWood();
    
    double treesSavedFromPaper = (totalQuantityFromPaper * 17)/2000;
    
    double treesSavedFromWood = totalQuantityFromWood / 20;
    
    double totalTreesSaved = treesSavedFromPaper + treesSavedFromWood; 
    
    return totalTreesSaved;
    
    }
    
}
