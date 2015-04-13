/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.AuthenticationIF;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tha
 */
public class AuthServiceWithDB implements AuthenticationIF{
    //database parameters
    private final String username   = "tha";
    private final String password   = "tha";
    private final String driver     = "oracle.jdbc.driver.OracleDriver";
    private final String URL        = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat";
    private ResultSet rs;
    private Statement statement;
    private Connection connection;
    private Map<String, User> users = new HashMap();
    
    public AuthServiceWithDB() {
        try{
        Class.forName(driver);
        connection = java.sql.DriverManager.getConnection(URL, username, password);
        
        
        statement = connection.createStatement();
        String sql = "SELECT * FROM users";
        rs = statement.executeQuery(sql);
        while(rs.next()){
            
          users.put(rs.getString("id"), new User(rs.getString("id"), rs.getString("name"), rs.getString("password"), rs.getString("gender")));
        }
        }catch(SQLException sqlE){
            System.out.println(Arrays.toString(sqlE.getStackTrace()));
            connection = null;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
       
        
        
    }
    @Override
    public boolean authCheck(String id, String pwd) {
        
        if(users.containsKey(id)){
            if(getUser(id).getPwd().equals(pwd)){
                return true;
            }
        }
        return false;
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
        try {
            String sql = "insert into THA.USERS values ('"+id+"', '"+name+"', '"+pwd+"', '"+gender+"')";
            statement.executeUpdate(sql);
            users.put(id, new User(id, name, pwd, gender));
        } catch (Exception e) {
            return false;
        }
    return true;
    }
    
}
