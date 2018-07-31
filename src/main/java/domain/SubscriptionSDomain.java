package domain;

import jpa.Courses;
import jpa.Student;

public class SubscriptionSDomain {
    private long id;
    private boolean registration;
    private Student student_id;
    private Courses courses_id;


    public SubscriptionSDomain(long id, boolean registration, Student student_id, Courses courses_id) {
        this.id = id;
        this.registration = registration;
        this.student_id = student_id;
        this.courses_id = courses_id;
    }

    public SubscriptionSDomain(boolean registration, Student student_id, Courses courses_id) {
        this.registration = registration;
        this.student_id = student_id;
        this.courses_id = courses_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }

    public Student getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public Courses getCourses_id() {
        return courses_id;
    }

    public void setCourses_id(Courses courses_id) {
        this.courses_id = courses_id;
    }
}
