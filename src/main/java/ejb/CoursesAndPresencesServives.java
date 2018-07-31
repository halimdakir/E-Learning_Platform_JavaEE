package ejb;

import domain.CoursesDomain;


import javax.ejb.Local;
import java.util.List;

@Local
public interface CoursesAndPresencesServives {
    void addCourses(CoursesDomain courses);
    void updateCourses(CoursesDomain courses);
    CoursesDomain getCourses (Long id);
    List<CoursesDomain> getAllCourses();
    public List<CoursesDomain> getCoursesNameContain(String filter) ;

}
