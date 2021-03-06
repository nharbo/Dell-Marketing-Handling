/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DataSource.DBfacade;
import Interface.Facadeinterface;
import Interface.ControllerInterface;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;

public class Controller implements ControllerInterface {

//    DBfacade db = new DBfacade();
    Facadeinterface db = new DBfacade();

    public Controller() {
    }

    public Controller(Facadeinterface facade) {
        this.db = facade;
    }

    @Override
    public void addPartner(String userid, int partnerid, String partnername, String address, int cvr, int phone, int zip) {
        db.addPartner(userid, partnerid, partnername, address, cvr, phone, zip);
    }

    @Override
    public void addUser(String userid, String password, String status) {
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

    public ArrayList<Campaign> getPartnerCampaigns(String username) {
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
    public void addCampaign(String user_id, int c_id, int p_id, Date startdate, Date stopdate, int c_budget, String status, String country) {
        db.addCampaign(user_id, c_id, p_id, startdate, stopdate, c_budget, status, country);
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
    public void addPoe(String poeid, int c_id, String status, InputStream poe) {

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
    public POE getPOE(int campaignid) {
        return db.getPOE(campaignid);
    }

    @Override
    public void approvePOE(String campaignid) {
        db.approvePOE(campaignid);
    }

    @Override
    public void disapprovePOE(String campaignid) {
        db.disapprovePOE(campaignid);
    }
}
