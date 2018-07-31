package jsf;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;


@ManagedBean
@RequestScoped
@SessionScoped
public class LoginController implements Serializable{

   // @NotNull (message = "Enter your email!")
    //@Pattern(regexp = "[a-zA-Z0-9._%-]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "Email format invalid")
    private String username;
    //@NotNull (message = "Enter your password!")
    private String password;

    private String dbusername;
    private String dbpassword;
    private Long id_student;
    private Long id_teacher;

    Connection connection;
    Statement statement;
    ResultSet resultSet;
    String SQL;





    public void dbData(String username)
    {
        try  {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/school", "postgres", "123");
            statement = connection.createStatement();
            SQL = "Select * from Login where username like ('" + username +"')";
            resultSet = statement.executeQuery(SQL);
            resultSet.next();
            dbusername = resultSet.getString(2).toString();
            dbpassword = resultSet.getString(3).toString();
            id_student = resultSet.getLong(4);
            id_teacher = resultSet.getLong(5);
        }
        catch(Exception ex) {
            ex.printStackTrace();
            System.out.println("Exception ......:" + ex);
        }
    }
    public String checkValidUser()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        dbData(username);
        if (username == null || password == null){
            context.addMessage( null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Enter your email and password!", " Password or Username invalid!"));
            return null;
        }
        if(username.equalsIgnoreCase(dbusername)) {
            if (password.equals(dbpassword)) {
                if (id_teacher == 0 && id_student != 0) {
                    return "supscription";                }
               else if (id_teacher != 0 && id_student == 0) {
                    return "teacherconnect";
                }else{
                    return "addmember";
                }
            }else
            {
                context.addMessage( null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Password and or Username invalid!", " Password or Username invalid!"));
                return null;}
        }
        else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Password and or Username invalid!", " Password or Username invalid."));
            return null;
        }

    }

    public String newUser(){

            return "registerstudent";

    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbusername() {
        return dbusername;
    }

    public void setDbusername(String dbusername) {
        this.dbusername = dbusername;
    }

    public String getDbpassword() {
        return dbpassword;
    }

    public void setDbpassword(String dbpassword) {
        this.dbpassword = dbpassword;
    }

    public Long getId_student() {
        return id_student;
    }

    public void setId_student(Long id_student) {
        this.id_student = id_student;
    }

    public Long getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(Long id_teacher) {
        this.id_teacher = id_teacher;
    }
}
