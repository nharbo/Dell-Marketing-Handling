/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Model.Partner;
import java.util.List;

/**
 *
 * @author nicolaiharbo
 */
public interface AuthInterface {
    
    boolean authCheck(String partnerid, String password);
    Partner getUser(String id);
    boolean addUser(String partnername, String address, int zipcode, String city, int phone, int partnerid, String password);
    
}
