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

        DBfacade db = new DBfacade();
        Controller control = new Controller();
        
        db.getPOE(4444);
        
    }
}
