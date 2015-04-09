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
    boolean addUser(String userid, String partnerid, String partnername, String address, int zip, String city, int cvr, int phone, int budget, String password, String re_password);
    
}
