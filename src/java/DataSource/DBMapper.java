/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import Domain.Campaign;
import Domain.User;
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

    public static final boolean inDebugMode = true;
    
    private Connection con = null;
    private ResultSet rs;
    private Statement statement = null;
    private Map<String, Campaign> campaigns = new HashMap();
    private Map<String, User> users = new HashMap();

    // Constructor som holder forbindelsen til databasen, via DBConnector.
    // Vi bruger getInstance metoden, fordi forbindelsen er oprettet som en singleton,
    // så der kun oprettes 1 forbindelse til DB-serveren.
    public DBMapper() {

        con = DBConnector.getInstance().getConnection();

    }

    static boolean testRun = true;

    //======  Methods to read from DB ======
    
    public boolean addUser (int partnerid, String partnername, String adress, int zip, String city, int cvr, int phone) {
        try {
            String sqlAdd = "insert into cphnh127.partners values ("+partnerid+", '"+partnername+"', '"+adress+"', "+zip+", '"+city+"', "+cvr+", "+phone+")";
            statement.executeUpdate(sqlAdd);
        } catch (Exception e) {
            System.out.println("Fail in DBMapper - addUser");
            System.out.println(e.getMessage());
        }
        return true;
    }
    
    // Henter data ned fra databasen, og gemmer det i en liste, som returneres.
    // Denne metode henter data ned fra databasen, og gemmer det i en liste, som returneres.
    public Map<String, Campaign> getCampaigns() {

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
                if(inDebugMode) { System.out.println("ResultSet: " + rs.getString("c_id"));}
                
                Campaign camp = new Campaign (rs.getInt("c_id"), rs.getInt("p_id"), rs.getDate("startdate"), rs.getDate("stopdate"), rs.getInt("c_budget"), rs.getString("status"));
                System.out.println("Printing capm: " + camp.toString()  );
                
                campaigns.put(rs.getString("c_id"), camp);
            }
            rs.close();
            statement.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Fail in DBMapper - getCampaign");
            System.out.println(e.getMessage());
        }
        if (testRun) {
            System.out.println("Retrieved campaign: " + campaigns);
        }
        // Mappet med campaign-objekter returneres.
        return campaigns; 
   }

}
