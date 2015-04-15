/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import Domain.Campaign;
import Domain.Partner;
import Domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nicolaiharbo
 */
public class DBMapper {

    public static final boolean inDebugMode = false;

    private Connection con = null;
    private ResultSet rs;
    private Statement statement = null;
    private Map<String, Campaign> campaigns = new HashMap();
    private Map<String, Partner> partners = new HashMap();

    // Constructor som holder forbindelsen til databasen, via DBConnector.
    // Vi bruger getInstance metoden, fordi forbindelsen er oprettet som en singleton,
    // så der kun oprettes 1 forbindelse til DB-serveren.
    public DBMapper() {

        con = DBConnector.getInstance().getConnection();

    }

    // Henter data ned fra databasen, og gemmer det i en liste, som returneres.
    // Denne metode henter data ned fra databasen, og gemmer det i en liste, som returneres.
    public List<Campaign> getCampaigns() {

        campaigns.clear();

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

                campaigns.put(rs.getString("c_id"), new Campaign(rs.getInt("c_id"), rs.getInt("p_id"), rs.getDate("startdate"), rs.getDate("stopdate"), rs.getInt("c_budget"), rs.getString("status")));
            }
            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Fail in DBMapper - getCampaign");
            System.out.println(e.getMessage());
        }
        if (inDebugMode) {
            System.out.println("Retrieved campaign: " + campaigns);
        }
        // Mappet laves om til en liste (da vi ikke skal bruge key-funktionen), og listen med campaign-objekter returneres.
        return new ArrayList<Campaign>(campaigns.values());
    }

    // Denne metode tilføjer en ny user til user-tabellen.
    public void addUser(String userid, String password) {
        try {
            statement = con.createStatement();
            String sqlAdd = "insert into cphnh127.users values ('" + userid + "', '" + password + "')";
            statement.executeQuery(sqlAdd);

        } catch (Exception e) {
            System.out.println("Fail in DBMapper - addUser");
            System.out.println(e.getMessage());
        }
    }

    //Denne metode tilføjer en nu kampagne til campaign-tabellen
    public void addCampaign() {
        try {
            statement = con.createStatement();
            String sqlAddCampaign = "insert into cphnh127.campaign values ()";
            statement.executeQuery(sqlAddCampaign);
        } catch (Exception e) {
            System.out.println("Fail in DBMapper - addCampaign");
            System.out.println(e.getMessage());
        }
    }

    //Denne metode tilføjer en ny partner til partner-tabellen.
    public void addPartner(String userid, int partnerid, String partnername, String adress, int cvr, int phone, int zip) {
        try {
            statement = con.createStatement();
            String sqlAdd = "insert into cphnh127.partners values ('" + userid + "', " + partnerid + ", '" + partnername + "', '" + adress + "', " + cvr + ", " + phone + ", " + zip + ")";
            statement.executeQuery(sqlAdd);
        } catch (Exception e) {
            System.out.println("Fail in DBMapper - addPartner");
            System.out.println(e.getMessage());
        }

    }

    //Denne metode henter alle partnere ind, og lægger dem ind i en liste.
    public List<Partner> getPartners() {
        partners.clear();

        try {
            // SQLString hiver alle elementer ud med status "ongoing"
            String SQLString1 = "SELECT * FROM partners";

            // Gør connection klar til at modtage et statement.
            statement = con.createStatement();

            // Eksikverer de SQL-statements som er gjort klar, og gemmer dem i en rs-variabel af typen ResultSet
            rs = statement.executeQuery(SQLString1);

            // Så længe der er indhold i tabellen, hives den ud, og gemmes ned i c, som er en liste af objekter.
            while (rs.next()) {
                if (inDebugMode) {
                    System.out.println("ResultSet: " + rs.getString("c_id"));
                }

                partners.put(rs.getString("user_id"), new Partner(rs.getString("user_id"), rs.getInt("p_id"), rs.getString("p_name"), rs.getString("address"), rs.getInt("cvr"), rs.getInt("phone"), rs.getInt("zip")));
            }
            rs.close();
            statement.close();

        } catch (Exception e) {
            System.out.println("Fail in DBMapper - getPartner");
            System.out.println(e.getMessage());
        }
        if (inDebugMode) {
            System.out.println("Retrieved partners: " + partners);
        }
        // Mappet laves om til en liste (da vi ikke skal bruge key-funktionen), og listen med partner-objekter returneres.
        return new ArrayList<Partner>(partners.values());
    }

    // Denne metode sletter en partner fra databasen, både i partner og user-tabellen, ud fra partnerid'et.
    //Lav som boolean, så der kan returners om det er gået godt eller ej.
    public void deletePartner(String userid) {
        try {
            statement = con.createStatement();
            String sqlDelete1 = "DELETE FROM partners WHERE user_id = '" + userid + "'";
            statement.executeQuery(sqlDelete1);
            String sqlDelete2 = "DELETE FROM users WHERE user_id = '" + userid + "'";
            statement.executeQuery(sqlDelete2);
        } catch (Exception e) {
            System.out.println("Fail in DBMapper - deletePartner");
            System.out.println(e.getMessage());
        }

    }

    // Denne metode henter en enkelt partner ind, og gemmer informationerne ned i et partner-objekt.
    public Partner getPartner(String userid) {
        Partner partner = null;

        try {
            statement = con.createStatement();
            String sqlDelete1 = "SELECT * FROM partners WHERE user_id = '" + userid + "'";
            rs = statement.executeQuery(sqlDelete1);

            while (rs.next()) {

                partner = new Partner(rs.getString("user_id"), rs.getInt("p_id"), rs.getString("p_name"), rs.getString("address"), rs.getInt("cvr"), rs.getInt("phone"), rs.getInt("zip"));
            }

        } catch (Exception e) {
            System.out.println("Fail in DBMapper - deletePartner");
            System.out.println(e.getMessage());
        }
        return partner;
    }

    // Denne metode opdaterer partnerinformationen i partner-tabellen i databasen.
    public void editPartner(Partner partner) {
        
        try {
            statement = con.createStatement();
            String sqlEdit = "UPDATE partners SET user_id = '" + partner.getUserid() + "', p_id = '" + partner.getPartnerid() + "', p_name = '" + partner.getPartnername() + "', address = '" + partner.getAddress() + "', cvr = '" + partner.getCvr() + "', phone = '" + partner.getPhone() + "', zip = '" + partner.getZip() + "' WHERE user_id = '" + partner.getUserid() + "'";
            statement.executeUpdate(sqlEdit);
        } catch (Exception e) {
            System.out.println("Fail in DBMapper - UpdatePartner");
            System.out.println(e.getMessage());
        }
    }

//        public boolean authCheck(String id, String password) {
//
//        if(userMap.getUserMap().containsKey(id)){
//            if(getUser(id).getPassword().equals(password)){
//                return true;
//            }
//        }
//        return false;
//    }
}
