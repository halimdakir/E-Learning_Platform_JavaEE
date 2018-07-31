package jpa;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name="selectstudents",query="SELECT p FROM Student p"),
        @NamedQuery(name="filterByfirstnameS",query="SELECT s FROM Student s WHERE LOCATE(:filter,s.firstname) >0 "),
        @NamedQuery(name = "All_Absence", query = "SELECT s.firstname,s.lastname,s.pnumber,p.absence,c.courseName FROM Student s inner Join Presence p inner join Lessons l inner join Courses c"),
        @NamedQuery(name = "AbsenceByStudent", query = "SELECT s.firstname,s.lastname,s.pnumber,p.absence,c.courseName FROM Student s inner Join Presence p inner join Lessons l inner join Courses c WHERE LOCATE(:filter,s.firstname) >0"),

})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    private String pnumber;
    private String firstname;
    private String lastname;
    private String dateOfBirth;
    private String telNumber;
    private String adress;
    private String postzip;
    private String city;

    @OneToOne (mappedBy = "student")
    private Login login;

    @OneToMany (mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubscriptionS> subscriptionSList = new ArrayList<SubscriptionS>();

    @OneToMany (mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Presence> presenceList = new ArrayList<Presence>();


    public Student() {
    }

    public Student( String pnumber, String firstname, String lastname, String dateOfBirth, String telNumber, String adress, String postzip, String city) {
        this.pnumber = pnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.telNumber = telNumber;
        this.adress = adress;
        this.postzip = postzip;
        this.city = city;
        //this.login = login;
    }

    public Student(String pnumber, String firstname, String lastname, List<Presence> presenceList) {
        this.pnumber = pnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.presenceList = presenceList;
    }

    public Student(String pnumber, String firstname, String lastname, String dateOfBirth, String telNumber, String adress, String postzip, String city, List<SubscriptionS> subscriptionSList) {
        this.pnumber = pnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.telNumber = telNumber;
        this.adress = adress;
        this.postzip = postzip;
        this.city = city;
        this.subscriptionSList = subscriptionSList;
    }

    public Student(String pnumber, String firstname, String lastname, String dateOfBirth, String telNumber, String adress, String postzip, String city, Login login, List<SubscriptionS> subscriptionSList, List<Presence> presenceList) {
        this.pnumber = pnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfBirth = dateOfBirth;
        this.telNumber = telNumber;
        this.adress = adress;
        this.postzip = postzip;
        this.city = city;
        this.login = login;
        this.subscriptionSList = subscriptionSList;
        this.presenceList = presenceList;
    }

    public Student(String pnumber, String firstname, String lastname, Login login) {
        this.pnumber = pnumber;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public List<SubscriptionS> getSubscriptionSList() {
        return subscriptionSList;
    }

    public void setSubscriptionSList(List<SubscriptionS> subscriptionSList) {
        this.subscriptionSList = subscriptionSList;
    }

    public List<Presence> getPresenceList() {
        return presenceList;
    }

    public void setPresenceList(List<Presence> presenceList) {
        this.presenceList = presenceList;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
