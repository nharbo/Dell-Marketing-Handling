/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interface.AuthInterface;

/**
 *
 * @author nicolaiharbo
 */
public class AuthService implements AuthInterface {
    
    public boolean addUser(String userid, String partnerid, String partnername, String address, int zip, String city, int cvr, int phone, int budget, String password, String re_password){
        
        //Somehow connect to the database, and add the user.
        
        
        return true;
    }

    @Override
    public boolean authCheck(String partnerid, String password) {
        
        //Connect to database, and see if the user exists. return true if it does, false if not.
        return true;
    }

    @Override
    public Partner getUser(String id) {
        
        //Get the users information from the database and return it.
        return null;
    }
    
}
