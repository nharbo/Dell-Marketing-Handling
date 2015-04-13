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
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author nicolaiharbo
 */
public class DBMapper {

    private Connection con = null;
    private ResultSet rs;
    private Statement statement;
    private Map<String, Campaign> campaigns = new HashMap();

    // Constructor som holder forbindelsen til databasen, via DBConnector.
    // Vi bruger getInstance metoden, fordi forbindelsen er oprettet som en singleton,
    // så der kun oprettes 1 forbindelse til DB-serveren.
    public DBMapper() {

        con = DBConnector.getInstance().getConnection();

    }

    static boolean testRun = true;

    //======  Methods to read from DB ======
    // Denne metode henter data ned fra databasen, og gemmer det i en liste, som returneres.
    public Map<String, Campaign> getCampaigns() {

        campaigns = null;

        try {
            // SQLString hiver alle elementer ud med status "ongoing"
            String SQLString1 = "SELECT * FROM campaign WHERE status = 'ongoing'";

            // Gør connection klar til at modtage et statement.
            statement = con.createStatement();

            // Eksikverer de SQL-statements som er gjort klar, og gemmer dem i en rs-variabel af typen ResultSet
            rs = statement.executeQuery(SQLString1);

            // Så længe der er indhold i tabellen, hives den ud, og gemmes ned i c, som er en liste af objekter.
            while (rs.next()) {
                campaigns.put(String.valueOf(rs.getInt(1)), new Campaign(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getDate(4), rs.getInt(5), rs.getString(6)));
            }

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
