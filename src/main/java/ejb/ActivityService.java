package ejb;


import domain.AbsenceByStudent;
import domain.CoursesDomain;
import domain.PresenceDomain;
import domain.SubscriptionSDomain;

import javax.ejb.Local;
import java.util.List;


@Local
public interface ActivityService {
    /*void addPresence(PresenceDomain presence);
    void addCourses(CoursesDomain courses);*/
    void addSubscription(SubscriptionSDomain sDomain);
   //List<AbsenceByStudent> getAbsence();
    List<AbsenceByStudent> getAllAbsence();
    //public List<AbsenceByStudent> getStudentFirtsNameContain(String filter) ;
}
