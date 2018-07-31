package domain;

public class LessonsDomain {
    private long id;
    private String date;

    public LessonsDomain(String date) {
        this.date = date;
    }

    public LessonsDomain(long id, String date) {
        this.id = id;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
