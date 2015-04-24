    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import Domain.Campaign;
import Domain.POE;
import Domain.Partner;
import Domain.User;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.Part;

/**
 *
 * @author nicolaiharbo
 */
public class DBfacade {

    public static final boolean inDebugMode = true;

    private static Connection con;
    private static Statement statement = null;

    // Constructor som holder forbindelsen til databasen, via DBConnector.
    // Vi bruger getInstance metoden, fordi forbindelsen er oprettet som en singleton,
    // så der kun oprettes 1 forbindelse til DB-serveren.
    public DBfacade() {

//        con = DBConnector.getInstance().getConnection();
    }

    // Authentication check.
    public static User login(User bean) {
        // Henter UserId og Password fra "User" class. 
        String username = bean.getUserId();
        String password = bean.getPassword();
        ResultSet rs;

        // SQL-streng der finder alle users der passer med oplyste user_id og pwd. 
        String SQLString = "select * from users where user_id='" + username + "' AND pwd = '" + password + "'";

        try {

            con = DBConnector.getInstance().getConnection();

            // Gør connection klar til at modtage et statement.
            statement = con.createStatement();

            // Eksikverer de SQL-statements som er gjort klar, og gemmer dem i en rs-variabel af typen ResultSet
            rs = statement.executeQuery(SQLString);

            // 
            boolean more = rs.next();

            // If user does not exist, set isValid variable in user class to false. 
            if (!more) {
                bean.setValid(false);
            } // If user exists, set isValid variable in user class to true.
            else if (more) {
                bean.setValid(true);
            }
            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Log-in failed: An exception has occured - " + e);
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return bean;
    }

    // Henter data ned fra databasen, og gemmer det i en liste, som returneres.
    // Denne metode henter data ned fra databasen, og gemmer det i en liste, som returneres.
    // Listen indeholder aktive/accepterede kampagner (ongoing)
    public ArrayList<Campaign> getCampaigns() {

        ArrayList<Campaign> campaigns = new ArrayList();
        ResultSet rs;

        try {
            con = DBConnector.getInstance().getConnection();

            // SQLString hiver alle elementer ud med status "ongoing"
            String SQLString1 = "SELECT * FROM campaign WHERE status = 'ongoing'";

            // Gør connection klar til at modtage et statement.
            statement = con.createStatement();

            // Eksikverer de SQL-statements som er gjort klar, og gemmer dem i en rs-variabel af typen ResultSet
            rs = statement.executeQuery(SQLString1);

            // Så længe der er indhold i tabellen, hives den ud, og gemmes ned i c, som er en liste af objekter.
            while (rs.next()) {
                if (inDebugMode) {
                    System.out.println("ResultSet: " + rs.getString("c_id"));
                }

                campaigns.add(new Campaign(rs.getInt("c_id"), rs.getInt("p_id"), rs.getDate("startdate"), rs.getDate("stopdate"), rs.getInt("c_budget"), rs.getString("status"), rs.getString("country")));
            }
            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Fail in DBfacade - getCampaign");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        // Mappet laves om til en liste (da vi ikke skal bruge key-funktionen), og listen med campaign-objekter returneres.
        return campaigns;
    }

    public ArrayList<Campaign> getPartnerCampaigns(String username) {

        ArrayList<Campaign> partnercampaigns = new ArrayList();
        ResultSet rs;

        try  {
            
            con = DBConnector.getInstance().getConnection();
            
            //Her laves en inner join, da campaign ikke inderholder et user_id, 
            //men kun p_id - derfor skal tabellerne sammensmeltes med en join..
            String SQLString1 = "SELECT * FROM partners INNER JOIN campaign ON campaign.p_id = partners.p_id WHERE user_id = '" + username + "'";
            statement = con.createStatement();
            rs = statement.executeQuery(SQLString1);

            System.out.println(SQLString1);

            while (rs.next()) {
                partnercampaigns.add(new Campaign(rs.getInt("c_id"), rs.getInt("p_id"), rs.getDate("startdate"), rs.getDate("stopdate"), rs.getInt("c_budget"), rs.getString("status"), rs.getString("country")));
            }
            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Fail in DBMapper - getPartnerCampaign");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return partnercampaigns;

    }

    // Denne metode tilføjer en ny user til user-tabellen.
    public void addUser(String userid, String password) {

        try  {
            con = DBConnector.getInstance().getConnection();
            
            statement = con.createStatement();
            String sqlAdd = "insert into cphnh127.users values ('" + userid + "', '" + password + "')";
            statement.executeQuery(sqlAdd);

        } catch (Exception e) {
            System.out.println("Fail in DBfacade - addUser");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Denne metode tilføjer en nu kampagne til campaign-tabellen
    public void addCampaign(int c_id, int p_id, Date startdate, Date stopdate, int c_budget, String status, String country) {

        try {
            con = DBConnector.getInstance().getConnection();
            statement = con.createStatement();
            String sqlAddCampaign = "insert into cphnh127.campaign values (" + c_id + ", " + p_id + ", to_date('" + startdate + "', 'YYYY-MM-DD'), to_date('" + stopdate + "', 'YYYY-MM-DD'), " + c_budget + ",  '" + status + "',  '" + country + "')";
            statement.executeQuery(sqlAddCampaign);
        } catch (Exception e) {
            System.out.println("Fail in DBfacade - addCampaign");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
        }
    }

    //Denne metode tilføjer en ny partner til partner-tabellen.
    public void addPartner(String userid, int partnerid, String partnername, String adress, int cvr, int phone, int zip) {
        try  {
            con = DBConnector.getInstance().getConnection();
            statement = con.createStatement();
            String sqlAdd = "insert into cphnh127.partners values ('" + userid + "', " + partnerid + ", '" + partnername + "', '" + adress + "', " + cvr + ", " + phone + ", " + zip + ")";
            statement.executeQuery(sqlAdd);
        } catch (Exception e) {
            System.out.println("Fail in DBfacade - addPartner");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //Denne metode henter alle partnere ind, og lægger dem ind i en liste.
    public ArrayList<Partner> getPartners() {

        ArrayList<Partner> partners = new ArrayList();
        ResultSet rs;

        try  {
            con = DBConnector.getInstance().getConnection();
            
            // SQLString hiver alle elementer ud med status "ongoing"
            String SQLString1 = "SELECT * FROM partners";

            // Gør connection klar til at modtage et statement.
            statement = con.createStatement();

            // Eksikverer de SQL-statements som er gjort klar, og gemmer dem i en rs-variabel af typen ResultSet
            rs = statement.executeQuery(SQLString1);

            // Så længe der er indhold i tabellen, hives den ud, og gemmes ned i c, som er en liste af objekter.
            while (rs.next()) {

                partners.add(new Partner(rs.getString("user_id"), rs.getInt("p_id"), rs.getString("p_name"), rs.getString("address"), rs.getInt("cvr"), rs.getInt("phone"), rs.getInt("zip")));
            }
            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Fail in DBfacade - getPartner");
            System.out.println(e.getMessage());
        }
        if (inDebugMode) {
            System.out.println("Retrieved partners: " + partners);
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        //listen med partner-objekter returneres.
        return partners;
    }

    // Denne metode sletter en partner fra databasen, både i partner og user-tabellen, ud fra partnerid'et.
    // Lav som boolean, så der kan returners om det er gået godt eller ej.
    public void deletePartner(String userid) {
        try  {
            con = DBConnector.getInstance().getConnection();
            
            statement = con.createStatement();
            String sqlDelete1 = "DELETE FROM partners WHERE user_id = '" + userid + "'";
            statement.executeQuery(sqlDelete1);
            String sqlDelete2 = "DELETE FROM users WHERE user_id = '" + userid + "'";
            statement.executeQuery(sqlDelete2);
        } catch (Exception e) {
            System.out.println("Fail in DBfacade - deletePartner");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Denne metode henter en enkelt partner ind, og gemmer informationerne ned i et partner-objekt.
    public Partner getPartner(String userid) {

        ResultSet rs;
        Partner partner = null;

        try  {
            con = DBConnector.getInstance().getConnection();
            
            statement = con.createStatement();
            String sqlDelete1 = "SELECT * FROM partners WHERE user_id = '" + userid + "'";
            rs = statement.executeQuery(sqlDelete1);

            while (rs.next()) {

                partner = new Partner(rs.getString("user_id"), rs.getInt("p_id"), rs.getString("p_name"), rs.getString("address"), rs.getInt("cvr"), rs.getInt("phone"), rs.getInt("zip"));
            }

        } catch (Exception e) {
            System.out.println("Fail in DBfacade - deletePartner");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return partner;
    }

    // Denne metode opdaterer partnerinformationen i partner-tabellen i databasen.
    public void editPartner(Partner partner) {

        try {
            con = DBConnector.getInstance().getConnection();
            
            statement = con.createStatement();
            String sqlEdit = "UPDATE partners SET user_id = '" + partner.getUserid() + "', p_id = '" + partner.getPartnerid() + "', p_name = '" + partner.getPartnername() + "', address = '" + partner.getAddress() + "', cvr = '" + partner.getCvr() + "', phone = '" + partner.getPhone() + "', zip = '" + partner.getZip() + "' WHERE user_id = '" + partner.getUserid() + "'";
            statement.executeUpdate(sqlEdit);
        } catch (Exception e) {
            System.out.println("Fail in DBfacade - UpdatePartner");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<Campaign> getCampaignRequests() {

        ResultSet rs;
        ArrayList<Campaign> campaignReq = new ArrayList();

        try {
            con = DBConnector.getInstance().getConnection();
            
            // SQLString hiver alle elementer ud med status "ongoing"
            String SQLString1 = "SELECT * FROM campaign WHERE status = 'pending'";

            // Gør connection klar til at modtage et statement.
            statement = con.createStatement();

            // Eksikverer de SQL-statements som er gjort klar, og gemmer dem i en rs-variabel af typen ResultSet
            rs = statement.executeQuery(SQLString1);

            // Så længe der er indhold i tabellen, hives den ud, og gemmes ned i c, som er en liste af objekter.
            while (rs.next()) {
                campaignReq.add(new Campaign(rs.getInt("c_id"), rs.getInt("p_id"), rs.getDate("startdate"), rs.getDate("stopdate"), rs.getInt("c_budget"), rs.getString("status"), rs.getString("country")));
            }
            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Fail in DBfacade - getCampaignRequests");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        // Mappet laves om til en liste (da vi ikke skal bruge key-funktionen), og listen med campaign-objekter returneres.
        return campaignReq;
    }

    public void acceptCampaignRequest(int campaignid) {

        try {
            con = DBConnector.getInstance().getConnection();
            
            statement = con.createStatement();
            String sqlEdit = "UPDATE campaign SET status = 'ongoing' WHERE c_id = '" + campaignid + "'";
            statement.executeUpdate(sqlEdit);
        } catch (Exception e) {
            System.out.println("Fail in DBfacade - acceptCampaignRequest");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void addPoe(String poeid, int c_id, String status, Part poe) {

        try {
            
            con = DBConnector.getInstance().getConnection();

            PreparedStatement sqlPoe = con.prepareStatement("insert into cphnh127.poe values (?,?,?,?)");
            sqlPoe.setString(1, poeid);
            sqlPoe.setInt(2, c_id);
            sqlPoe.setString(3, status);
            sqlPoe.setBlob(4, poe.getInputStream());
            sqlPoe.executeQuery();

        } catch (Exception e) {
            System.out.println("Fail in DBMapper - addPoe");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public ArrayList<Campaign> getDisapprovedCampaigns() {

        ResultSet rs;
        ArrayList<Campaign> disCampaign = new ArrayList();

        try {
            con = DBConnector.getInstance().getConnection();
            
            String sqlDis = "SELECT * FROM campaign WHERE status = 'disapproved'";
            statement = con.createStatement();
            rs = statement.executeQuery(sqlDis);

            while (rs.next()) {
                disCampaign.add(new Campaign(rs.getInt("c_id"), rs.getInt("p_id"), rs.getDate("startdate"), rs.getDate("stopdate"), rs.getInt("c_budget"), rs.getString("status"), rs.getString("country")));
            }

            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Fail in DBfacade - getDisapprovedCampaigns");
            System.out.println(e);
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return disCampaign;
    }

    public void disapproveCampaignRequest(int campaignid) {

        try {
            con = DBConnector.getInstance().getConnection();
            
            statement = con.createStatement();
            String sqlDisapprove = "UPDATE campaign SET status = 'disapproved' WHERE c_id = '" + campaignid + "'";
            statement.executeUpdate(sqlDisapprove);
        } catch (Exception e) {
            System.out.println("Fail in DBfacade - disapproveCampaignRequest");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    // Clearer de inaktive kampagner (dem som ikke er blevet godkendte).
    // Der laves en autocommit, så der ikke går noget galt, når der slettes i to forskellige tabeller.
    // På den måde bliver begge statements kun udført, hvis de går godt. Hvis det ene fejler, bliver det andet ikke udført.
    // OBS!! DETTE ER EN TRANSACTION!
    public void clearDisapprovedCampaigns() {

        try  {
            con = DBConnector.getInstance().getConnection();
            
            //Autocommit slåes fra.
            con.setAutoCommit(false);

            statement = con.createStatement();
            String sqlDeleteDisapprove = "DELETE FROM POE WHERE C_ID IN (SELECT c_id FROM campaign WHERE status = 'disapproved')";
            statement.executeQuery(sqlDeleteDisapprove);
            String sqlDeleteDisapprove2 = "DELETE FROM campaign WHERE status = 'disapproved'";
            statement.executeQuery(sqlDeleteDisapprove2);

            //Her committes sql-strengene, og udføres, hvis de begge er "godkendte".
            con.commit();

        } catch (Exception e) {
            System.out.println("Fail in DBfacade - clearDisapprovedCampaigns");
            System.out.println(e.getMessage());
            // trycatch i catchen, hvis der opstår exception, 
            // som laver en rollback, så der ikke laves noget rod i DB
            try (Connection con = DriverManager.getConnection(URL, ID, PW)) {
                con.rollback();
                System.out.println("Transaction rolled back..");
            } catch (Exception f) {
                System.out.println("Fail doing rollback");
                System.out.println(f);
            }
        } //Finally vil altid blive udført i en metode, uanset udfald i trycatch, break etc..
        finally {
            try {
                //Autocommit slåes til igen.
                con.setAutoCommit(true);
                con.close();
            } catch (Exception e) {
            }

        }
    }

    public ArrayList<POE> getPOE(int campaignid) {

        ArrayList poe = new ArrayList();
        ResultSet rs;

        try {
            con = DBConnector.getInstance().getConnection();
            
            String SQLpoe = "SELECT * FROM poe WHERE c_id = " + campaignid + "";
            statement = con.createStatement();
            rs = statement.executeQuery(SQLpoe);

            while (rs.next()) {
                poe.add(new POE(rs.getString("poeid"), rs.getInt("c_id"), rs.getString("status"), rs.getBlob("poe")));
            }

        } catch (Exception e) {
            System.out.println("Fail in DBMapper - getPOE");
            System.out.println(e.getMessage());
        }
        try {
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return poe;

    }

}
