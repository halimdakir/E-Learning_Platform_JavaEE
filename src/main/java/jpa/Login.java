package jpa;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity
@XmlRootElement
@NamedQueries({
        @NamedQuery(name="Login.control",query="SELECT l.email, l.password, s.id, t.id from Login l inner Join l.student s inner join l.teacher t where l.email = :username and l.password = :password"),
        @NamedQuery(name="Login.selectAllS",query="SELECT u FROM Login u where u.student is not null "),
        @NamedQuery(name="Login.selectAllT",query="SELECT u FROM Login u where u.teacher is not null "),
        //@NamedQuery(name = "Login.selectAll", query = "SELECT s FROM Student s JOIN Login u ON  u.student=s.id")
})
public class Login implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "user_id")
    private Long id;
    @Column (name = "username")
    private String email;
    private String password;


    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "student_id")
    private Student student;

    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "teacher_id")
    private Teacher teacher;

    public Login() {
    }

    public Login(String email, String password, Student s) {
        this.email = email;
        this.password = password;
        this.student = s;

    }
    public Login(String email, String password, Teacher t) {
        this.email = email;
        this.password = password;
        this.teacher= t;
    }

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Login(String email, String password, Student student, Teacher teacher) {
        this.email = email;
        this.password = password;
        this.student = student;
        this.teacher = teacher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
