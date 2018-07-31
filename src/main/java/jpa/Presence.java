package jpa;

import javax.persistence.*;


@Entity
@NamedQueries({
        @NamedQuery(name="selectAbsence",query="SELECT p FROM Presence p")

})
public class Presence  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "absence_hours")
    private Long absence;


    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "student_id")
    private Student student;

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "lessons_id")
    private Lessons lessons;

    public Presence() {
    }

    public Presence(Long absence, Student student, Lessons lessons) {
        this.absence = absence;
        this.student = student;
        this.lessons = lessons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAbsence() {
        return absence;
    }

    public void setAbsence(Long absence) {
        this.absence = absence;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lessons getLessons() {
        return lessons;
    }

    public void setLessons(Lessons lessons) {
        this.lessons = lessons;
    }
}
