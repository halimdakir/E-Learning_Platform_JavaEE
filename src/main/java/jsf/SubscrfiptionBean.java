package jsf;

import domain.SubscriptionSDomain;
import ejb.ActivityService;
import jpa.Courses;
import jpa.Student;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SubscrfiptionBean {
    private Long id;
    private Student student_id;
    private Courses courses_id;
    private boolean registration;

    @EJB
    ActivityService activityService;

    public void register(){
        if (getId()==null)
        activityService.addSubscription(new SubscriptionSDomain(isRegistration(), getStudent_id(), getCourses_id()));


        }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean isRegistration() {
        return registration;
    }

    public void setRegistration(boolean registration) {
        this.registration = registration;
    }
}
