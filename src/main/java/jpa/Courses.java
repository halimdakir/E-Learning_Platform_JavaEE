package jpa;
import domain.MembreDomain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@NamedQueries({
        @NamedQuery(name = "selectCourses", query = "SELECT c FROM Courses c"),
        @NamedQuery(name = "filterCourses", query = "SELECT c FROM Courses c WHERE LOCATE(:filter,c.courseName) >0 ")
})
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "courses_id")
    private Long id;
    private String courseName;
    @Column(name = "date_of_start")
    private String dateStart;
    @Column(name = "date_of_end")
    private String dateEnd;




    @OneToMany (mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubscriptionS> subscriptionSList = new ArrayList<SubscriptionS>();

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "teacher_id")
    private Teacher teacher;

    @OneToMany (mappedBy = "courses", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Lessons> lessonsList = new ArrayList<Lessons>();

    public Courses() {
    }

    public Courses( String courseName, String dateStart, String dateEnd) {
        this.courseName = courseName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;

    }

    public Courses(String courseName, String dateStart, String dateEnd, Teacher teacher) {
        this.courseName = courseName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.teacher = teacher;
    }

    public Courses(String courseName, String dateStart, String dateEnd, List<SubscriptionS> subscriptionSList) {
       // this.teacher_id = teacher_id;
        this.courseName = courseName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;

        this.subscriptionSList = subscriptionSList;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }



    public List<SubscriptionS> getSubscriptionSList() {
        return subscriptionSList;
    }

    public void setSubscriptionSList(List<SubscriptionS> subscriptionSList) {
        this.subscriptionSList = subscriptionSList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Lessons> getLessonsList() {
        return lessonsList;
    }

    public void setLessonsList(List<Lessons> lessonsList) {
        this.lessonsList = lessonsList;
    }
}
