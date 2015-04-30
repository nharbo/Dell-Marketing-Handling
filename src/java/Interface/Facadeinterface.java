/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Domain.Campaign;
import Domain.POE;
import Domain.Partner;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author nicolaiharbo
 */
public interface Facadeinterface {
    boolean inDebugMode = true;

    void acceptCampaignRequest(int campaignid);

    //Denne metode tilføjer en nu kampagne til campaign-tabellen
    void addCampaign(int c_id, int p_id, Date startdate, Date stopdate, int c_budget, String status, String country);

    //Denne metode tilføjer en ny partner til partner-tabellen.
    void addPartner(String userid, int partnerid, String partnername, String adress, int cvr, int phone, int zip);

    void addPoe(String poeid, int c_id, String status, InputStream poe);

    // Denne metode tilføjer en ny user til user-tabellen.
    void addUser(String userid, String password, String status);

    // Clearer de inaktive kampagner (dem som ikke er blevet godkendte).
    // Der laves en autocommit, så der ikke går noget galt, når der slettes i to forskellige tabeller.
    // På den måde bliver begge statements kun udført, hvis de går godt. Hvis det ene fejler, bliver det andet ikke udført.
    // OBS!! DETTE ER EN TRANSACTION!
    void clearDisapprovedCampaigns();

    // Denne metode sletter en partner fra databasen, både i partner og user-tabellen, ud fra partnerid'et.
    // Lav som boolean, så der kan returners om det er gået godt eller ej.
    void deletePartner(String userid);

    void disapproveCampaignRequest(int campaignid);

    // Denne metode opdaterer partnerinformationen i partner-tabellen i databasen.
    void editPartner(Partner partner);

    ArrayList<Campaign> getCampaignRequests();

    // Henter data ned fra databasen, og gemmer det i en liste, som returneres.
    // Denne metode henter data ned fra databasen, og gemmer det i en liste, som returneres.
    // Listen indeholder aktive/accepterede kampagner (ongoing)
    ArrayList<Campaign> getCampaigns();

    ArrayList<Campaign> getDisapprovedCampaigns();

    POE getPOE(int campaignid);

    // Denne metode henter en enkelt partner ind, og gemmer informationerne ned i et partner-objekt.
    Partner getPartner(String userid);

    ArrayList<Campaign> getPartnerCampaigns(String username);

    //Denne metode henter alle partnere ind, og lægger dem ind i en liste.
    ArrayList<Partner> getPartners();
    
    public void approvePOE(int campaignid);
    
    public void disapprovePOE(int campaignid);
    
}
