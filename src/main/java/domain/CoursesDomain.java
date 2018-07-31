package domain;

import jpa.Teacher;

public class CoursesDomain {
    private long id;
    private String courseName;
    private String dateStart;
    private String dateEnd;
    private Long id2;


    public CoursesDomain(long id, String courseName, String dateStart, String dateEnd) {
        this.id = id;
        this.courseName = courseName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public CoursesDomain(long id, String courseName, String dateStart, String dateEnd, Long id2) {
        this.id = id;
        this.courseName = courseName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.id2 = id2;
    }

    public CoursesDomain(String courseName, String dateStart, String dateEnd) {
        this.courseName = courseName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Long getId2() {
        return id2;
    }

    public void setId2(Long id2) {
        this.id2 = id2;
    }
}
