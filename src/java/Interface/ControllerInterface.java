/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Domain.Campaign;
import java.util.List;

/**
 *
 * @author nicolaiharbo
 */
public interface ControllerInterface {
    
    public void addPartner(int partnerid, String partnername, String address, int zip, String city, int cvr, int phone);
    
    public void getPartner(int partnerid);
    
    public void addUser(String userid, String password, String re_password);
    
    public void getUser(String userid);
    
    public void addCampaign(int campaignId, int startDate, int stopDate, int budget, String status);
    
    public List<Campaign> getCampaigns(String status);
    
    
}
