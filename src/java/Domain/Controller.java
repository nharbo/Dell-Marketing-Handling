/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Interface.ControllerInterface;

/**
 *
 * @author nicolaiharbo
 */
public class Controller implements ControllerInterface {

    @Override
    public void addPartner(int partnerid, String partnername, String address, int zip, String city, int cvr, int phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addUser(String userid, String password, String re_password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
