package ejb;

import domain.MemberViewDomain;
import domain.MembreDomain;
import domain.UsersDomain;

import javax.ejb.Local;
import java.util.List;

@Local
public interface TeacherService {
    void addTeacher(MembreDomain teacher, UsersDomain users);
    void updateTeacher(MembreDomain teacher);
    MembreDomain getTeacher (Long id);
    UsersDomain getUser (Long id);
    List<MembreDomain> getTeachers();
    public List<MembreDomain> getTeacherP_NumberContain(String filter) ;
}
