/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.io.InputStream;
import java.sql.Blob;
import javax.servlet.http.Part;

/**
 *
 * @author nicolaiharbo
 */
public class POE {

    String poeid;
    int c_id;
    String status;
    Blob poe;
//    InputStream in;

    public POE(String poeid, int c_id, String status, Blob poe/*, InputStream in*/) {

        this.poeid = poeid;
        this.c_id = c_id;
        this.status = status;
        this.poe = poe;
//        this.in = in;

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }

    public String getPoeid() {
        return poeid;
    }

    public void setPoeid(String poeid) {
        this.poeid = poeid;
    }

    public Blob getPoe() {
        return poe;
    }

    public void setPoe(Blob poe) {
        this.poe = poe;
    }

//    public InputStream getIn() {
//        return in;
//    }
//
//    public void setIn(InputStream in) {
//        this.in = in;
//    }

}
