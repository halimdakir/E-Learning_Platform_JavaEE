package ejb;

import domain.MemberViewDomain;
import domain.MembreDomain;
import domain.UsersDomain;
import jpa.Login;
import jpa.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class StudentServiceImpli implements StudentService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addStudent(MembreDomain student, UsersDomain users) {
        Student student1 = new Student(student.getPnumber(), student.getFirstname(), student.getLastname(),  student.getDateOfBirth(), student.getTelNumber(), student.getAdress(), student.getPostzip(), student.getCity());
        entityManager.persist(student1);
        Login login1 = new Login(users.getEmail(), users.getPassword(),student1);
        entityManager.persist(login1);
    }

    @Override
    public void updateStudent(MembreDomain student) {
        Student student1 = entityManager.find(Student.class, student.getId());
       // Login login1 = entityManager.find(Login.class, users.getId());
        //login1.setEmail(users.getEmail());
        //login1.setPassword(users.getPassword());
        student1.setPnumber(student.getPnumber());
        student1.setFirstname(student.getFirstname());
        student1.setLastname(student.getLastname());
        student1.setDateOfBirth(student.getDateOfBirth());
        student1.setTelNumber(student.getTelNumber());
        student1.setAdress(student.getAdress());
        student1.setPostzip(student.getPostzip());
        student1.setCity(student.getCity());

        entityManager.merge(student1);
        //entityManager.merge(login1);

    }

    @Override
    public MembreDomain getStudent(Long id) {
        Student student1 = entityManager.find(Student.class, id);
        return new MembreDomain(student1.getId(),student1.getPnumber(),student1.getFirstname(),student1.getLastname(),student1.getDateOfBirth(),student1.getTelNumber(),student1.getAdress(),student1.getPostzip(),student1.getCity());
    }

    @Override
    public UsersDomain getUser(Long id) {
        Login login1 = entityManager.find(Login.class, id);
        return new UsersDomain(login1.getId(),login1.getEmail(),login1.getPassword());
    }

    @Override
    public List<MembreDomain> getStudents() {
        List<Student> list1 = entityManager.createNamedQuery("selectstudents").getResultList();
        List<MembreDomain> myList = new ArrayList<>();

        for (Student s:list1){
         //Student s = l.getStudent();

            myList.add(new MembreDomain(s.getId(), s.getPnumber(), s.getFirstname(), s.getLastname(),s.getDateOfBirth(),s.getTelNumber(),s.getAdress(),s.getPostzip(),s.getCity()));
        }

      //return myList;
        return list1.stream().
                map(s->new MembreDomain(s.getId(), s.getPnumber(), s.getFirstname(), s.getLastname(),s.getDateOfBirth(),s.getTelNumber(),s.getAdress(),s.getPostzip(),s.getCity())).
                collect(Collectors.toList());

    }

    @Override
    public List<MembreDomain> getStudentP_NumberContain(String filter) {
        List<Student> list = entityManager.createNamedQuery("filterByfirstnameS").setParameter("filter",filter).getResultList();
        return list.stream().
                map(s->new MembreDomain(s.getId(), s.getPnumber(), s.getFirstname(), s.getLastname(),s.getDateOfBirth(),s.getTelNumber(),s.getAdress(),s.getPostzip(),s.getCity())).
                collect(Collectors.toList());
    }
}
