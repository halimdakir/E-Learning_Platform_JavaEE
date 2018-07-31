package jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import domain.MemberViewDomain;
import domain.MembreDomain;
import domain.UsersDomain;
import ejb.StudentService;
import ejb.TeacherService;
import jpa.Login;


import javax.ejb.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.Date;
import java.util.List;

@ManagedBean
@RequestScoped
public class MemberBean {
    //to know who you register the data
    @NotNull(message = "*")
    private String profil;
    private Long id_member;
    private Long id_user;
    // users parameter
    @NotNull(message = "*")
    @Pattern(regexp = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "Exemple@email.com")
    private String email;
    private String dbemail;
    @NotNull(message = "*")
    @Size(min = 8, max = 15, message = "8 =< size =< 15")
    private String password;
    //Students and teacher parametre
    @NotNull(message = "*")
    @Pattern(regexp = "[0-9]{6}-[0-9]{4}", message = "YYMMDD-NNNN")
    private String pnumber;
    @NotNull(message = "*")
    private String firstname;
    @NotNull(message = "*")
    private String lastname;
    @NotNull(message = "*")
    @Pattern(regexp = "[0-9]{2}-[0-9]{2}-[0-9]{4}", message = "DD-MM-YYYY")
    private String dateOfBirth;
    @NotNull(message = "*")
    @Pattern(regexp = "[0-9]{10}", message = "0700000000")
    private String telNumber;
    @NotNull(message = "*")
    private String adress;
    @NotNull(message = "*")
    @Pattern(regexp = "[0-9]{5}", message = "Ex 12345")
    private String postzip;
    @NotNull(message = "*")
    private String city;
    @AssertTrue(message = "*")
    private boolean agree;
    private String filter;


    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String SQL;






    @EJB
    StudentService studentService;
    @EJB
    TeacherService teacherService;





    public void dbEmail(String email)
    {
        try  {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school", "postgres", "123");
            statement = connection.createStatement();
            SQL = "Select * from Login where username like ('" + email +"')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            dbemail = resultSet.getString(2).toString();
        }
        catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception ......:" + ex);
        }
    }
    public String addUser(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        dbEmail(email);

        if (dbemail != null) {
            setAgree(false);
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "This email is already exist", " Password or Username invalid!"));
        } else
            if (profil.equals("Student"))
                studentService.addStudent(new MembreDomain(getPnumber(), getFirstname(), getLastname(), getDateOfBirth(), getTelNumber(), getAdress(), getPostzip(), getCity()), new UsersDomain(getEmail(), getPassword()));
            facesContext.addMessage(null, new FacesMessage("successfully registered", ""));

          return "index";
        }
    public void addStudent() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        dbEmail(email);

        if (dbemail != null) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "This email is already exist", " Password or Username invalid!"));
        } else{
            if (getId_member()==null) {
                    studentService.addStudent(new MembreDomain(getPnumber(), getFirstname(), getLastname(), getDateOfBirth(), getTelNumber(), getAdress(), getPostzip(), getCity()), new UsersDomain(getEmail(), getPassword()));
                facesContext.addMessage(null, new FacesMessage("Successfully register!"));
                setId_member(null);
                setId_user(null);
                setProfil("");
                setEmail("");
                setPassword("");
                setPnumber("");
                setFirstname("");
                setLastname("");
                setDateOfBirth(null);
                setTelNumber("");
                setAdress("");
                setPostzip("");
                setCity("");

            }else {
                studentService.updateStudent(new MembreDomain(getId_member(), getPnumber(), getFirstname(), getLastname(), getDateOfBirth(), getTelNumber(), getAdress(), getPostzip(), getCity()));
                facesContext.addMessage(null, new FacesMessage("Successfully updat!"));


                setId_member(null);
                setId_user(null);
                setProfil("");
                setEmail("");
                setPassword("");
                setPnumber("");
                setFirstname("");
                setLastname("");
                setDateOfBirth(null);
                setTelNumber("");
                setAdress("");
                setPostzip("");
                setCity("");
            }
        }

    }
    public void addTeacher() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        dbEmail(email);

        if (dbemail != null) {

            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "This email is already exist", " Password or Username invalid!"));
        } else{
            if (getId_member()==null ) {
                teacherService.addTeacher(new MembreDomain(getPnumber(), getFirstname(), getLastname(), getDateOfBirth(), getTelNumber(), getAdress(), getPostzip(), getCity()), new UsersDomain(getEmail(), getPassword()));


                setId_member(null);
                setId_user(null);
                setProfil("");
                setEmail("");
                setPassword("");
                setPnumber("");
                setFirstname("");
                setLastname("");
                setDateOfBirth(null);
                setTelNumber("");
                setAdress("");
                setPostzip("");
                setCity("");


                facesContext.addMessage(null, new FacesMessage("Successfully register!"));
            }else {

                teacherService.updateTeacher(new MembreDomain(getId_member(), getPnumber(), getFirstname(), getLastname(), getDateOfBirth(), getTelNumber(), getAdress(), getPostzip(), getCity()));
                facesContext.addMessage(null, new FacesMessage("Successfully updat!"));


                setId_member(null);
                setId_user(null);
                setProfil("");
                setEmail("");
                setPassword("");
                setPnumber("");
                setFirstname("");
                setLastname("");
                setDateOfBirth(null);
                setTelNumber("");
                setAdress("");
                setPostzip("");
                setCity("");

            }


        }

    }


    /*public String updateStudent(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        studentService.updateStudent(new MembreDomain(getId_member(), getPnumber(), getFirstname(), getLastname(), getDateOfBirth(), getTelNumber(), getAdress(), getPostzip(), getCity()), new UsersDomain(getId_user(), getEmail(), getPassword()));
        facesContext.addMessage(null, new FacesMessage("successfully Update", ""));

        return null;
    }*/

   /* public String updateTeacher(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        teacherService.updateTeacher(new MembreDomain(getId_member(), getPnumber(), getFirstname(), getLastname(), getDateOfBirth(), getTelNumber(), getAdress(), getPostzip(), getCity()), new UsersDomain(getId_user(), getEmail(), getPassword()));
        facesContext.addMessage(null, new FacesMessage("successfully Update", ""));

        return null;
    }*/

    public String editStudent(Long id1 ){
        MembreDomain membreDomain = studentService.getStudent(id1);
        //UsersDomain usersDomain = studentService.getUser(id2);
        //setId_user(usersDomain.getId());
        //setEmail(usersDomain.getEmail());
        //setPassword(usersDomain.getPassword());
        setId_member(membreDomain.getId());
        setPnumber(membreDomain.getPnumber());
        setFirstname(membreDomain.getFirstname());
        setLastname(membreDomain.getLastname());
        setDateOfBirth(membreDomain.getDateOfBirth());
        setTelNumber(membreDomain.getTelNumber());
        setAdress(membreDomain.getAdress());
        setPostzip(membreDomain.getPostzip());
        setCity(membreDomain.getCity());
       return "editliststudent";
    }
    public String editTeacher(Long id1 ){
        MembreDomain membreDomain = teacherService.getTeacher(id1);
        //UsersDomain usersDomain = teacherService.getUser(id2);
        //setId_user(usersDomain.getId());
       // setEmail(usersDomain.getEmail());
        //setPassword(usersDomain.getPassword());
        setId_member(membreDomain.getId());
        setPnumber(membreDomain.getPnumber());
        setFirstname(membreDomain.getFirstname());
        setLastname(membreDomain.getLastname());
        setDateOfBirth(membreDomain.getDateOfBirth());
        setTelNumber(membreDomain.getTelNumber());
        setAdress(membreDomain.getAdress());
        setPostzip(membreDomain.getPostzip());
        setCity(membreDomain.getCity());
        return "editlistTeacher";
    }
    public String getSubmitButtonLabel() {
        if (id_member == null)
            return "Register";
        else
            return "Update";
    }
    public String logOut() {
            return "index";
    }

    public List<MembreDomain> getStudents(){

        return studentService.getStudents();
    }

    public List<MembreDomain> getTeachers(){

        return teacherService.getTeachers();
    }

    public List<MembreDomain> getStudentFilter(){
        if (filter==null || filter.equals(""))
            return studentService.getStudents();
        else
            return studentService.getStudentP_NumberContain(filter);
    }

    public List<MembreDomain> getTeacherFilter(){
        if (filter==null || filter.equals(""))
            return teacherService.getTeachers();
        else
            return teacherService.getTeacherP_NumberContain(filter);
    }



   /* public void saveMessage() {
        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, new FacesMessage("Successful",  "new: "+profil ) );

    }*/


    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public Long getId_member() {
        return id_member;
    }

    public void setId_member(Long id_member) {
        this.id_member = id_member;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDbemail() {
        return dbemail;
    }

    public void setDbemail(String dbemail) {
        this.dbemail = dbemail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isAgree() {
        return agree;
    }

    public void setAgree(boolean agree) {
        this.agree = agree;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}
