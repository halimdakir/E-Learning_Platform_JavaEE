package ejb;

import domain.MemberViewDomain;
import domain.MembreDomain;
import domain.UsersDomain;
import jpa.Login;
import jpa.Teacher;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class TeacherServiceImpli  implements TeacherService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void addTeacher(MembreDomain teacher, UsersDomain users) {
        Teacher teacher1 = new Teacher( teacher.getPnumber(), teacher.getFirstname(), teacher.getLastname(), teacher.getDateOfBirth(), teacher.getTelNumber(), teacher.getAdress(), teacher.getPostzip(), teacher.getCity());
        entityManager.persist(teacher1);
        Login login1 = new Login(users.getEmail(),users.getPassword(), teacher1);
        entityManager.persist(login1);
    }


    @Override
    public void updateTeacher(MembreDomain teacher) {
        Teacher teacher1 = entityManager.find(Teacher.class, teacher.getId());
        //Login login1 = entityManager.find(Login.class, users.getId());
        //login1.setEmail(users.getEmail());
        //login1.setPassword(users.getPassword());
        teacher1.setPnumber(teacher.getPnumber());
        teacher1.setFirstname(teacher.getFirstname());
        teacher1.setLastname(teacher.getLastname());
        teacher1.setDateOfBirth(teacher.getDateOfBirth());
        teacher1.setTelNumber(teacher.getTelNumber());
        teacher1.setAdress(teacher.getAdress());
        teacher1.setPostzip(teacher.getPostzip());
        teacher1.setCity(teacher.getCity());

        entityManager.merge(teacher1);
        //entityManager.merge(login1);

    }

    @Override
    public MembreDomain getTeacher(Long id) {
        Teacher teacher1 = entityManager.find(Teacher.class, id);
        return new MembreDomain(teacher1.getId(),teacher1.getPnumber(),teacher1.getFirstname(),teacher1.getLastname(),teacher1.getDateOfBirth(),teacher1.getTelNumber(),teacher1.getAdress(),teacher1.getPostzip(),teacher1.getCity());
    }

    @Override
    public UsersDomain getUser(Long id) {
        Login login1 = entityManager.find(Login.class, id);
        return new UsersDomain(login1.getId(),login1.getEmail(),login1.getPassword());
    }

    @Override
    public List<MembreDomain> getTeachers() {
        List<Teacher> list1 = entityManager.createNamedQuery("selectAllTeacher").getResultList();
        List<MembreDomain> myList = new ArrayList<>();

        for (Teacher s:list1){
           // Teacher s = l.getTeacher();

            myList.add(new MembreDomain(s.getId(), s.getPnumber(), s.getFirstname(), s.getLastname(),s.getDateOfBirth(),s.getTelNumber(),s.getAdress(),s.getPostzip(),s.getCity()));
        }

        //return myList;
        return list1.stream().
                map(s->new MembreDomain(s.getId(), s.getPnumber(), s.getFirstname(), s.getLastname(),s.getDateOfBirth(),s.getTelNumber(),s.getAdress(),s.getPostzip(),s.getCity())).
                collect(Collectors.toList());
    }

    @Override
    public List<MembreDomain> getTeacherP_NumberContain(String filter) {
        List<Teacher> list = entityManager.createNamedQuery("filterByPNumberT").setParameter("filter",filter).getResultList();
        return list.stream().
                map(s->new MembreDomain(s.getId(), s.getPnumber(), s.getFirstname(), s.getLastname(),s.getDateOfBirth(),s.getTelNumber(),s.getAdress(),s.getPostzip(),s.getCity())).
                collect(Collectors.toList());
    }

}
