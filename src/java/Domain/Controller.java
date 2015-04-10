/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.DBMapper;
import Interface.ControllerInterface;
import java.util.List;

/**
 *
 * @author nicolaiharbo
 */
public class Controller implements ControllerInterface {
    
    DBMapper db = new DBMapper();

    @Override
    public void addPartner(int partnerid, String partnername, String address, int zip, String city, int cvr, int phone) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public List<Campaign> getCampaigns(int campaignId) {
        
       List<Campaign> data = db.getCampaigns(campaignId);
       return data;
       
    }
    
}
