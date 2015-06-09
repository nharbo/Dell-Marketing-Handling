package DataSource;

import java.sql.Connection;
import java.sql.DriverManager;

// Enkapsuleret kode, så databasen kun kan tilgåes via denne "private" metode.
// Lavet som en singleton, så der kun kan oprettes en connection af gangen.
public class DBConnector {

    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat";
    private static String id = "cphnh127";
    private static String pw = "cphnh127";

    private Connection con;

    //-- Singleton, så der kun oprettes 1 forbindelse ---- 
    private static DBConnector instance;

    // Private konstruktør, kan kun tilgåes fra klassen selv (igennem getInstance())..
    private DBConnector() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, id, pw);

        } catch (Exception e) {
            System.out.println("Error in DBConnector");
            System.out.println(e);
        }
    }

    // Giver mulighed for at hente en instans af objektet, så der ikke oprettes et nyt, men bare en instans.
    // Hvis der findes en instans af DBConnector i forvejen, bruges denne
    // Ellers oprettes en ny.
    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }

    // Denne metode kaldes fra konstruktøren
    public Connection getConnection() {

        try {

            if (con.isClosed()) {

                Class.forName(driver);
                con = DriverManager.getConnection(URL, id, pw);

            }
        } catch (Exception e) {
            System.out.println("Error in DBConnector.getConnection()");
            System.out.println(e);
        }

        return con;
    }
}
