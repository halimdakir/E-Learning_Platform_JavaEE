package jpa;

import javax.persistence.*;

@Entity
public class SubscriptionS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Subs_id")
    private Long id;
    private boolean registration;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "student_id")
    private Student student;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "courses_id")
    private Courses courses;


    public SubscriptionS() {
    }

    public SubscriptionS(boolean registration, Student student, Courses courses) {
        this.registration = registration;
        this.student = student;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }


}
