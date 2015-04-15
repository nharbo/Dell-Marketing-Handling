/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.DBMapper;
import Interface.ControllerInterface;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nicolaiharbo
 */
public class Controller implements ControllerInterface {
    
    DBMapper db = new DBMapper();
    private Map<String, Campaign> campaigns = new HashMap();
    

    @Override
    public void addPartner(String userid, int partnerid, String partnername, String address, int cvr, int phone, int zip) {
        System.out.println("now in addPartner");
        db.addPartner(userid, partnerid, partnername, address, cvr, phone, zip);
    }

    @Override
    public void addUser(String userid, String password) {
        System.out.println("now in addUser");
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
    public void addCampaign(int campaignId, int startDate, int stopDate, int budget, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //public void addCampaign(int startDate, int stopDate, int budget, String country, String currency, int campaignId)

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


    
    
    
}
