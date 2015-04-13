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
    public void addPartner(String userid, int partnerid, String partnername, String address, int zip, int cvr, int phone) {
        
        db.addPartner(userid, partnerid, partnername, address, zip, cvr, phone);
    }

    @Override
    public void addUser(String userid, String password, String re_password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getPartner(int partnerid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getUser(String userid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addCampaign(int campaignId, int startDate, int stopDate, int budget, String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<String, Campaign> getAllCampaigns() {
        return db.getCampaigns();
       
    }
    
}
