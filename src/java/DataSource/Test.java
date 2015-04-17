/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import Domain.Campaign;
import Domain.Controller;
import java.sql.Date;
import java.util.Map;

/**
 *
 * @author nicolaiharbo
 */
public class Test {
    public static void main(String[] args) {
        DBfacade dbm = new DBfacade();
        Controller ctrl = new Controller();
        
        for (int i = 0; i < ctrl.getAllPartners().size(); i++) {
            
            System.out.println("liste " + i);
            
        }
        
        ctrl.addCampaign(5000, 1001, Date.valueOf("1992-04-28"), Date.valueOf("1992-04-30"), 1337, "Pending", "denmark");
        
//        Controller control = new Controller();
//        control.addUser("Username222011", "hej");
//        control.addPartner("Username222011", 121111, "123", "Århus C", 123, 123, 8000);
        
        
    }
}
