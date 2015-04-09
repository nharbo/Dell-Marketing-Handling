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

/**
 *
 * @author nicolaiharbo
 */
public class DBMapper {
    
    static boolean testRun = true;

    //======  Methods to read from DB =======================================================
    // Retrieve a specific order and related order details
    // Returns the Order-object
    public Campaign getCampaigns(int campaignId, Connection con) {
        Campaign c = null;

        // get campaign
        String SQLString1 = "select * " + "from campaign " + "where status = ongoing";

        PreparedStatement statement = null;

        try {
            //=== get order
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, campaignId);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                c = new Campaign(campaignId, rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
            }

        } catch (Exception e) {
            System.out.println("Fail in OrderMapper - getOrder");
            System.out.println(e.getMessage());
        }
                if (testRun)
        {
            System.out.println("Retrieved Order: " + c);
        }
        return c;
    }
        
    
    }


