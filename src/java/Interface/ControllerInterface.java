
package Interface;

import Domain.Campaign;
import Domain.POE;
import Domain.Partner;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Part;

public interface ControllerInterface {
    
    public void addPartner(String userid, int partnerid, String partnername, String address, int zip, int cvr, int phone);
    
    public List<Partner> getAllPartners();
    
    public void addUser(String userid, String password, String status);
    
    public void getUser(String userid);
    
    public void addCampaign(String user_id, int c_id, int p_id, Date startdate, Date stopdate, int c_budget, String status, String country);
    
    public List<Campaign> getAllCampaigns();
    
    public void deletePartner(String userid);
    
    public Partner getPartner(String userid);
    
    public void editPartner(Partner partner);
    
    public List<Campaign> getPartnerCampaigns(String username);
    
    public List<Campaign> getCampaignRequests();
    
    public void acceptCampaignRequest(int campaignid);
    
    public void addPoe(String poeid, int c_id, String status, InputStream poe);
    
    public List<Campaign> getDisapprovedCampaigns();
    
    public void disapproveCampaignRequest(int campaignid);
    
    public void clearDisapprovedCampaigns();
    
    public POE getPOE(int campaignid);
    
    public void approvePOE(String campaignid);
    
    public void disapprovePOE(String campaignid);
}

