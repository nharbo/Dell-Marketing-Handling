/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.DBfacade;
import Interface.ControllerInterface;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nicolaiharbo
 */
public class Controller implements ControllerInterface {
    
    DBfacade db = new DBfacade();
    
    public static final boolean inDebugMode = false;

    @Override
    public void addPartner(String userid, int partnerid, String partnername, String address, int cvr, int phone, int zip) {
        System.out.println("now in addPartner");
        db.addPartner(userid, partnerid, partnername, address, cvr, phone, zip);
    }

    @Override
    public void addUser(String userid, String password) {
        if(inDebugMode) {System.out.println("now in addUser");}
        db.addUser(userid, password);
    }

    @Override
    public List<Partner> getAllPartners() {
        return db.getPartners();
    }

    @Override
    public void getUser(String userid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public List<Campaign> getAllCampaigns() {
        return db.getCampaigns();
       
    }

    @Override
    public void deletePartner(String userid) {
        db.deletePartner(userid);
    }

    @Override
    public Partner getPartner(String userid) {
        return db.getPartner(userid);
    }

    @Override
    public void editPartner(Partner partner) {
        db.editPartner(partner);
    }

    @Override
    public void addCampaign(int c_id, int p_id, Date startdate, Date stopdate, int c_budget, String status, String country, String currency) {
        db.addCampaign(c_id, p_id, startdate, stopdate, c_budget, status , country, currency); // ret efter table
    }
   

    
    


    
    
    
}
