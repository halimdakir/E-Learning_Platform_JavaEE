package domain;

import java.util.Date;

public class MembreDomain {
    private long id;
    private String pnumber;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private String telNumber;
    private String adress;
    private String postzip;
    private String city;



    public MembreDomain(String pnumber, String firstname, String lastname, String dateOfBirth, String telNumber, String adress, String postzip, String city) {
        this.pnumber = pnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.telNumber = telNumber;
        this.adress = adress;
        this.postzip = postzip;
        this.city = city;

    }

    public MembreDomain(long id, String pnumber, String firstname, String lastname, String dateOfBirth, String telNumber, String adress, String postzip, String city) {
        this.id = id;
        this.pnumber = pnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.telNumber = telNumber;
        this.adress = adress;
        this.postzip = postzip;
        this.city = city;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPostzip() {
        return postzip;
    }

    public void setPostzip(String postzip) {
        this.postzip = postzip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
