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
import java.util.List;

/**
 *
 * @author nicolaiharbo
 */
public class DBMapper {

    Connection con = null;

    // Constructor som holder forbindelsen til databasen, via DBConnector.
    // Vi bruger getInstance metoden, fordi forbindelsen er oprettet som en singleton,
    // så der kun oprettes 1 forbindelse til DB-serveren.
    public DBMapper() {
       
        con = DBConnector.getInstance().getConnection();
        
    }

    static boolean testRun = true;

    //======  Methods to read from DB ======
    // Henter data ned fra databasen, og gemmer det i en liste, som returneres.
    public List<Campaign> getCampaigns(int campaignId) {
        List<Campaign> c = null;
        
        // SQLString hiver alle elementer ud med status "ongoing"
        String SQLString1 = "select * " + "from campaign " + "where status = ongoing";

        PreparedStatement statement = null;

        try {
            // 
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, campaignId);
            ResultSet rs = statement.executeQuery();
            // Så længe der er indhold i tabellen, hives den ud, og gemmes ned i c, som er en liste af objekter.
            if (rs.next()) {
                c.add(new Campaign(campaignId, rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
            }

        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - getOrder");
            System.out.println(e.getMessage());
        }
        if (testRun) {
            System.out.println("Retrieved Order: " + c);
        }
        // Listen med objekter returneres.
        return c;
    }

}
