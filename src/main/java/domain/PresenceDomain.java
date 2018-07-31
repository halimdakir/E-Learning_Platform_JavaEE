package domain;

public class PresenceDomain {
    private long id;
    private long lessons_id;
    private long student_id;
    private long absence;


    public PresenceDomain(long lessons_id, long student_id, long absence) {
        this.lessons_id = lessons_id;
        this.student_id = student_id;
        this.absence = absence;
    }

    public PresenceDomain(long id, long lessons_id, long student_id, long absence) {
        this.id = id;
        this.lessons_id = lessons_id;
        this.student_id = student_id;
        this.absence = absence;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLessons_id() {
        return lessons_id;
    }

    public void setLessons_id(long lessons_id) {
        this.lessons_id = lessons_id;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public long getAbsence() {
        return absence;
    }

    public void setAbsence(long absence) {
        this.absence = absence;
    }
}
