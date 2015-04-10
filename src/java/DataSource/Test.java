/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSource;

import java.util.Map;

/**
 *
 * @author nicolaiharbo
 */
public class Test {
    public static void main(String[] args) {
        DBMapper dbm = new DBMapper();
        Map map = dbm.getCampaigns();
        System.out.println("size: "+ map.size());
    }
}
