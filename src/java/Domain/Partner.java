/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author nicolaiharbo
 */
public class Partner {
    
    int partnerid;
    String partnername;
    String address;
    int zip;
    String city;
    int cvr;
    int phone;

    public Partner(int partnerid, String partnername, String address, int zip, String city, int cvr, int phone) {
        this.partnerid = partnerid;
        this.partnername = partnername;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.cvr = cvr;
        this.phone = phone;
    }





    
}
