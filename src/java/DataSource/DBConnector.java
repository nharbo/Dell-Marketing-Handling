package DataSource;

import java.sql.Connection;
import java.sql.DriverManager;

// Enkapsuleret kode, så databasen kun kan tilgåes via denne "private" metode.
// Lavet som en singleton, så der kun kan oprettes en connection af gangen.
public class DBConnector
{

    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String URL = "jdbc:oracle:thin:@datdb.cphbusiness.dk:1521:dat";
    private static String id = "cphnh127";
    private static String pw = "cphnh127";
    
    private Connection con;

    //-- Singleton, så der kun oprettes 1 forbindelse ---- 
    private static DBConnector instance;
    private DBConnector()
    {
        try
        {
            Class.forName(driver);
            con = DriverManager.getConnection(URL, id, pw);   // The connection will be released upon program 
		  					      // termination by the garbage collector	
        } catch (Exception e)
        {
            System.out.println("\n*** Remember to insert your Oracle ID and PW in the DBConnector class! ***\n");
            System.out.println("error in DBConnector.getConnection()");
            System.out.println(e);
        }
    }
    public static DBConnector getInstance()
    {
        if (instance == null)
            instance = new DBConnector();
        return instance;
    }
    //------------------
    
    public Connection getConnection()
    {
      return con;
    }
}
