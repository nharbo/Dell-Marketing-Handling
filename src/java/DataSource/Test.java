/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import Domain.Campaign;
import Domain.Controller;
import java.util.Map;

/**
 *
 * @author nicolaiharbo
 */
public class Test {
    public static void main(String[] args) {
        DBMapper dbm = new DBMapper();
        
        for (int i = 0; i < dbm.getCampaigns().size(); i++) {
            
            System.out.println("liste " + i);
            
        }
        
//        Controller control = new Controller();
//        control.addUser("Username222011", "hej");
//        control.addPartner("Username222011", 121111, "123", "Århus C", 123, 123, 8000);
        
        
    }
}
