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
    
    public boolean addUser(String partnername, String address, int zipcode, String city, int phone, int partnerid, String password){
        
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
