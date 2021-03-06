
package Domain;

public class Partner {
    
    String userid;
    int partnerid;
    String partnername;
    String address;
    int cvr;
    int phone;
    int zip;

    public Partner() {
        // Tom konstruktør, for at lave klassen til en bean, så den kan fanges i jsp'en.
    }
    
    // Konstruktør som bruges til at oprette objekter med.
    public Partner(String userid, int partnerid, String partnername, String address, int cvr, int phone, int zip) {
        this.userid = userid;
        this.partnerid = partnerid;
        this.partnername = partnername;
        this.address = address;
        this.cvr = cvr;
        this.phone = phone;
        this.zip = zip;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
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

    @Override
    public String toString() {
        return "Partner{" + "userid=" + userid + ", partnerid=" + partnerid + ", partnername=" + partnername + ", address=" + address + ", cvr=" + cvr + ", phone=" + phone + ", zip=" + zip + '}';
    }
 
}
