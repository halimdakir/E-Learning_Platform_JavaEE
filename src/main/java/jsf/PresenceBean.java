package jsf;


import domain.AbsenceByStudent;

import ejb.ActivityService;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean
@RequestScoped
public class PresenceBean {


    private String personal_Number;
    private String firstName;
    private String lastNmae;
    // private String courses_Name;
    private List<Long> absence_Hours;

    @EJB
    ActivityService activityService;

    /*public void addPresence(){
        if (getId() == null)
            activityService.addPresence(new PresenceDomain(getLessons_id(),getStudent_id(),getAbsence()));

        setId(null);
        setLessons_id(null);
        setStudent_id(null);
        setAbsence(null);
    }*/

    /*public List<AbsenceByStudent> getAbsenceFilterByStudent(){
        if (filter==null || filter.equals(""))
            return activityService.getAbsence();
        else
            return activityService.getStudentFirtsNameContain(filter);
    }*/

    public List<AbsenceByStudent> getAllAbsence(){

        return activityService.getAllAbsence();
    }

    public String getPersonal_Number() {
        return personal_Number;
    }

    public void setPersonal_Number(String personal_Number) {
        this.personal_Number = personal_Number;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNmae() {
        return lastNmae;
    }

    public void setLastNmae(String lastNmae) {
        this.lastNmae = lastNmae;
    }

    public List<Long> getAbsence_Hours() {
        return absence_Hours;
    }

    public void setAbsence_Hours(List<Long> absence_Hours) {
        this.absence_Hours = absence_Hours;
    }

    public ActivityService getActivityService() {
        return activityService;
    }

    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }
}
