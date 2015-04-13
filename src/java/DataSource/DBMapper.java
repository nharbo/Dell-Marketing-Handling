/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import Domain.Campaign;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nicolaiharbo
 */
public class DBMapper {

    Connection con = null;
    private ResultSet rs;
    private Map<String, Campaign> campaigns = new HashMap();

    // Constructor som holder forbindelsen til databasen, via DBConnector.
    // Vi bruger getInstance metoden, fordi forbindelsen er oprettet som en singleton,
    // så der kun oprettes 1 forbindelse til DB-serveren.
    public DBMapper() {

        con = DBConnector.getInstance().getConnection();

    }

    static boolean testRun = true;

    //======  Methods to read from DB ======
    
    // Henter data ned fra databasen, og gemmer det i en liste, som returneres.
    public Map<String, Campaign> getCampaigns() {

        campaigns = null;

        // SQLString hiver alle elementer ud med status "ongoing"
        String SQLString1 = "SELECT * FROM campaign WHERE status = 'ongoing'";

        PreparedStatement statement = null;

        try {
            // Gør SQL-strengen klar
            statement = con.prepareStatement(SQLString1);

            rs = statement.executeQuery();
            
            // Så længe der er indhold i tabellen, hives den ud, og gemmes ned i c, som er en liste af objekter.
            while(rs.next()) {
                campaigns.put(String.valueOf(rs.getInt("c_id")), new Campaign(rs.getInt("c_id"), rs.getInt("p_id"), rs.getDate("startdate"), rs.getDate("stopdate"), rs.getInt("c_budget"), rs.getString("status")));
            }
            
            // Eksikverer de SQL-statements som er sat op under prepare, og gemmer dem i en rs-variabel af typen ResultSet
            rs = statement.executeQuery();

        } catch (Exception e) {
            System.out.println("Fail in DBMapper - getCampaign");
            System.out.println(e.getMessage());
        }
        if (testRun) {
            System.out.println("Retrieved campaign: " + campaigns);
        }
        // Listen med objekter returneres.
        return campaigns;
    }

}
