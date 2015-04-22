/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Domain.Campaign;
import Domain.POE;
import Domain.Partner;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Part;

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
    
    public List<Campaign> getPartnerCampaigns(String username);
    
    public List<Campaign> getCampaignRequests();
    
    public void acceptCampaignRequest(int campaignid);
    
    public void addPoe(String poeid, int c_id, String status, String poe);
    
    public List<Campaign> getDisapprovedCampaigns();
    
    public void disapproveCampaignRequest(int campaignid);
    
    public void clearDisapprovedCampaigns();
    
    public List<POE> getPOE(int campaignid);
}
