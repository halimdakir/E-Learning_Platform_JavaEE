package ejb;

import domain.MemberViewDomain;
import domain.MembreDomain;
import domain.UsersDomain;
import jpa.Login;

import javax.ejb.Local;
import java.util.List;


@Local
public interface StudentService {
    void addStudent(MembreDomain student, UsersDomain users);
    void updateStudent(MembreDomain student);
    MembreDomain getStudent (Long id);
    UsersDomain getUser (Long id);
    List<MembreDomain> getStudents();
    public List<MembreDomain> getStudentP_NumberContain(String filter) ;


}

