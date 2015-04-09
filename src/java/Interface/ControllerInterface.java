/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author nicolaiharbo
 */
public interface ControllerInterface {
    
    public void addPartner(int partnerid, String partnername, String address, int zip, String city, int cvr, int phone);
    
    public void addUser(String userid, String password, String re_password);
    
}
