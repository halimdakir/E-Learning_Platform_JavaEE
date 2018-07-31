package jsf;

import domain.CoursesDomain;
import ejb.ActivityService;
import ejb.CoursesAndPresencesServives;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@ManagedBean
@RequestScoped
@SessionScoped
public class CoursesBean {
    private Long id;
    //@NotNull(message = "*")
    private Long teacher_id;
   //@NotNull(message = "*")
    private String courseName;
    //@NotNull(message = "*")
    @Pattern(regexp = "[0-9]{2}-[0-9]{2}-[0-9]{4}", message = "DD-MM-YYYY")
    private String dateStart;
    //@NotNull(message = "*")
    @Pattern(regexp = "[0-9]{2}-[0-9]{2}-[0-9]{4}", message = "DD-MM-YYYY")
    private String dateEnd;

    private String filter;


    @EJB
    CoursesAndPresencesServives coursesAndPresencesServives;

    public void addCourses() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (getId() == null) {
            coursesAndPresencesServives.addCourses(new CoursesDomain(getCourseName(), getDateStart(), getDateEnd()));
            facesContext.addMessage(null, new FacesMessage("Successfully register!"));
            setId(null);
            setCourseName("");
            setDateStart("");
            setDateEnd("");
        } else {
            coursesAndPresencesServives.updateCourses(new CoursesDomain(getId(), getCourseName(), getDateStart(), getDateEnd(), getTeacher_id()));
            facesContext.addMessage(null, new FacesMessage("Successfully update!"));
            setId(null);
            setCourseName("");
            setDateStart("");
            setDateEnd("");
            setTeacher_id(null);
        }
    }

    public String editCourses(long id1) {
        CoursesDomain coursesDomain = coursesAndPresencesServives.getCourses(id1);
        setId(coursesDomain.getId());
        setCourseName(coursesDomain.getCourseName());
        setDateStart(coursesDomain.getDateStart());
        setDateEnd(coursesDomain.getDateEnd());
        setTeacher_id(coursesDomain.getId2());
        return "editlistcourses";
    }
    public List<CoursesDomain> getAllcourses(){

        return coursesAndPresencesServives.getAllCourses();
    }

    public List<CoursesDomain> getCoursesFilter(){
        if (filter==null || filter.equals(""))
            return  coursesAndPresencesServives.getAllCourses();
        else
            return coursesAndPresencesServives.getCoursesNameContain(filter);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
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

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }
}
