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

    public int getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(int partnerid) {
        this.partnerid = partnerid;
    }

    public String getPartnername() {
        return partnername;
    }

    public void setPartnername(String partnername) {
        this.partnername = partnername;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCvr() {
        return cvr;
    }

    public void setCvr(int cvr) {
        this.cvr = cvr;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }





    
}
