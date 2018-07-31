package jpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Lessons {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "lessons_id")
    private Long id;
    private String date;

    @OneToMany (mappedBy = "lessons", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Presence> presenceList = new ArrayList<Presence>();

    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "courses_id")
    private Courses courses;



    public Lessons() {
    }

    public Lessons(String date, List<Presence> presenceList, Courses courses) {
        this.date = date;
        this.presenceList = presenceList;
        this.courses = courses;
    }

    public Lessons(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<Presence> getPresenceList() {
        return presenceList;
    }

    public void setPresenceList(List<Presence> presenceList) {
        this.presenceList = presenceList;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }
}
