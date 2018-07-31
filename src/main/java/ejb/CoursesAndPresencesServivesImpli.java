package ejb;

import domain.CoursesDomain;
import domain.MembreDomain;
import jpa.Courses;
import jpa.Teacher;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CoursesAndPresencesServivesImpli implements CoursesAndPresencesServives {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public void addCourses(CoursesDomain courses) {
        Courses courses1 = new Courses(courses.getCourseName(),courses.getDateStart(),courses.getDateEnd());
        entityManager.persist(courses1);
    }

    @Override
    public void updateCourses(CoursesDomain courses) {
        Courses courses1 = entityManager.find(Courses.class, courses.getId());
        courses1.setCourseName(courses.getCourseName());
        courses1.setDateStart(courses.getDateStart());
        courses1.setDateEnd(courses.getDateEnd());
        entityManager.merge(courses1);
    }

    @Override
    public CoursesDomain getCourses(Long id) {
        Courses courses1 = entityManager.find(Courses.class, id);
        return new CoursesDomain(courses1.getId(), courses1.getCourseName(), courses1.getDateStart(), courses1.getDateEnd());
    }

    @Override
    public List<CoursesDomain> getAllCourses() {
        List<Teacher> list1 = entityManager.createNamedQuery("selectAllTeacher").getResultList();
        List<CoursesDomain> myList = new ArrayList<>();

        for (Teacher t:list1) {
            for (Courses c : t.getCoursesList()) {
                myList.add(new CoursesDomain(c.getId(), c.getCourseName(), c.getDateStart(), c.getDateEnd(), t.getId()));

            }
        }

        return myList;
    }

    @Override
    public List<CoursesDomain> getCoursesNameContain(String filter) {
        List<Courses> list1 = entityManager.createNamedQuery("filterCourses").setParameter("filter",filter).getResultList();
        List<CoursesDomain> myList = new ArrayList<>();

        for (Courses c:list1){
            Teacher t = c.getTeacher();
            myList.add(new CoursesDomain(c.getId(),c.getCourseName(),c.getDateStart(),c.getDateEnd(),t.getId()));
        }

        return myList;
    }
}
