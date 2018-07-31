package ejb;

import domain.AbsenceByStudent;
import domain.CoursesDomain;
import domain.PresenceDomain;
import domain.SubscriptionSDomain;
import jpa.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ActivityServiceImpli implements ActivityService {
    @PersistenceContext
    EntityManager entityManager;

   /* @Override
    public void addPresence(PresenceDomain presence) {
        Presence presence1 = new Presence(presence.getLessons_id(), presence.getStudent_id(),presence.getAbsence());
        entityManager.persist(presence1);
    }

    @Override
    public void addCourses(CoursesDomain courses) {
        Courses courses1 = new Courses(courses.getTeacher_id(),courses.getCourseName(),courses.getDateStart(),courses.getDateEnd());
        entityManager.persist(courses1);
    }*/

    @Override
    public void addSubscription(SubscriptionSDomain sDomain) {
        SubscriptionS s = new SubscriptionS(sDomain.isRegistration(),sDomain.getStudent_id(),sDomain.getCourses_id());
        entityManager.persist(s);
    }

   /* @Override
    public List<AbsenceByStudent> getAbsence() {
      List<Student> allAbsence = entityManager.createNamedQuery("selectstudents").getResultList();
       List<AbsenceByStudent> myList = new ArrayList<>();
        for (Student a:allAbsence){
            for (SubscriptionS s:a.getSubscriptionSList()) {
                for (Presence p:a.getPresenceList()) {
                    (Presence p:a.getPresenceList()) {a.getPnumber(), a.getFirstname(), a.getLastname(), s.getCourses().getCourseName(), p.));
                }
            }
        }
        return myList;
    }*/

    /*@Override
    public List<AbsenceByStudent> getStudentFirtsNameContain(String filter) {

        List<AbsenceByStudent> studentList = entityManager.createNamedQuery("AbsenceByStudent")
                .setParameter("filter",filter).getResultList();

        return studentList.stream().map(s -> new AbsenceByStudent(s.getPersonal_Number(),s.getFirstName(),s.getLastNmae(),s.getCourses_Name(),s.getAbsence_Hours()))
        .collect(Collectors.toList());
    }*/

   /* @Override
    public List<AbsenceByStudent> getAllAbsence() {
        List<Student> allAbsence = entityManager.createNamedQuery("selectstudents").getResultList();
        List<AbsenceByStudent> myList = new ArrayList<>();
        for (Student a:allAbsence) {
            for (Presence p : a.getPresenceList()) {

            }

            }

        return null;
    }*/

    @Override
    public List<AbsenceByStudent> getAllAbsence() {
        List<Student> list = entityManager.createNamedQuery("selectstudents").getResultList();
        List<AbsenceByStudent> myList = new ArrayList<>();
        for (Student s:list) {
            List<Long> longList = new ArrayList<>();
            for (Presence p:s.getPresenceList()) {
                longList.add(p.getAbsence());
                //Student s=p.getStudent();
            }
            myList.add(new AbsenceByStudent(s.getPnumber(), s.getFirstname(), s.getLastname(), longList));
        }
        return myList;
    }


}
