/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Domain.Campaign;
import Domain.Partner;
import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nicolaiharbo
 */
public interface ControllerInterface {
    
    public void addPartner(String userid, int partnerid, String partnername, String address, int zip, int cvr, int phone);
    
    public List<Partner> getAllPartners();
    
    public void addUser(String userid, String password);
    
    public void getUser(String userid);
    
    public void addCampaign(int c_id, int p_id, Date startdate, Date stopdate, int c_budget, String status, String country);
    
    public List<Campaign> getAllCampaigns();
    
    public void deletePartner(String userid);
    
    public Partner getPartner(String userid);
    
    public void editPartner(Partner partner);
    
    public List<Campaign> getCampaignRequests();
    
    public void acceptCampaignRequest(int campaignid);
}
