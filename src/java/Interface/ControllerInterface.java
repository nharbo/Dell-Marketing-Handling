/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Domain.Campaign;
import Domain.Partner;
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
    
    public void addCampaign(int campaignId, int startDate, int stopDate, int budget, String status);
    //public void addCampaign(int startDate, int stopDate, int budget, String country, String currency, int campaignId);
    
    public List<Campaign> getAllCampaigns();
    
    public void deletePartner(String userid);
    
    public Partner getPartner(String userid);
    
    public void editPartner(Partner partner);
}
