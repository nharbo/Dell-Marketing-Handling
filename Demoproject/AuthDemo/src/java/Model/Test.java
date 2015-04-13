/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.AuthenticationIF;
import java.util.List;

/**
 *
 * @author tha
 */
public class Test {
    public static void main(String[] args) {
        //AuthenticationIF as = new AuthServiceWithDB();
        //boolean test = as.authCheck("jens", "jp123");
        //System.out.println(test);
        //as.addUser("id", "navn", "pwd");
       
//        for(User user : as.getAllUsers()){
//            System.out.println(user.getName());
//        }
        //System.out.println(as.authCheck("id", "pwd"));
        
        AuthenticationIF auth = new AuthServiceWithDB();
//        for(User user: auth.getAllUsers()){
//            System.out.println(user.getName());
//        }
        boolean bool = auth.addUser("fe", "Fie Eriksen", "fe123", "F");
        System.out.println(bool);
    }
}
