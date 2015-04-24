/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.DBfacade;
import Interface.ControllerInterface;
import java.sql.Blob;
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
//    Facade db = new DBfacade();
//    
//    public Controller() {}
//    
//    public Controller(Facade facade) {
//        this.db = facade;
//    }
    
    
    public static final boolean inDebugMode = false;

    @Override
    public void addPartner(String userid, int partnerid, String partnername, String address, int cvr, int phone, int zip) {
        db.addPartner(userid, partnerid, partnername, address, cvr, phone, zip);
    }

    @Override
    public void addUser(String userid, String password, String status) {
        if(inDebugMode) {System.out.println("now in addUser");}
        db.addUser(userid, password, status);
    }

    @Override
    public ArrayList<Partner> getAllPartners() {
        return db.getPartners();
    }

    @Override
    public void getUser(String userid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Campaign> getAllCampaigns() {
        return db.getCampaigns();
       
    }
    
    public ArrayList<Campaign> getPartnerCampaigns(String username){
        return db.getPartnerCampaigns(username);
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
    public void addCampaign(int c_id, int p_id, Date startdate, Date stopdate, int c_budget, String status, String country) {
        db.addCampaign(c_id, p_id, startdate, stopdate, c_budget, status , country); // ret efter table
    }

    @Override
    public ArrayList<Campaign> getCampaignRequests() {
        return db.getCampaignRequests();
    }

    @Override
    public void acceptCampaignRequest(int campaignid) {
        db.acceptCampaignRequest(campaignid);
    }
   
@Override
    public void addPoe(String poeid, int c_id, String status, Blob poe) {
        
        db.addPoe(poeid, c_id, status, poe);
    }

    @Override
    public ArrayList<Campaign> getDisapprovedCampaigns() {
        return db.getDisapprovedCampaigns();
    }

    @Override
    public void disapproveCampaignRequest(int campaignid) {
        db.disapproveCampaignRequest(campaignid);
    }

    @Override
    public void clearDisapprovedCampaigns() {
        db.clearDisapprovedCampaigns();
    }

    @Override
    public ArrayList<POE> getPOE(int campaignid) {
      return db.getPOE(campaignid);
    }
    
    

    
    
    
}

