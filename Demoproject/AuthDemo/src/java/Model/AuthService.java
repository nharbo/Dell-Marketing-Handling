/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.AuthenticationIF;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tha
 */
public class AuthService implements AuthenticationIF{
    Map<String, User> users = new HashMap();
    @Override
    public boolean authCheck(String id, String pwd) {
        if(users.containsKey(id)){
            if(getUser(id).getPwd().equals(pwd)){
                return true;
            }
        }
        return false;
    }

    public AuthService() {
        //Dommy data
        addUser("jens", "Jens Petersen", "jp123", "M");
        addUser("holger", "Holger Andersen", "ha123", "M");
        addUser("karen", "Karen Ibsen", "ki123", "F");
        
    }
    @Override
    public List<User> getAllUsers(){
       return new ArrayList<User>(users.values());
        
    }

    @Override
    public User getUser(String id) {
        return users.get(id);
    }

    @Override
    public boolean addUser(String id, String name, String pwd, String gender) {
        users.put(id, new User(id, name, pwd, gender));
        return true;
    }
    
}
