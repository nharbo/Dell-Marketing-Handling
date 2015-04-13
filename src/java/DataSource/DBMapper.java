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
            con.close();

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

}
