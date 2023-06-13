package ua.com.a_level.entity;

public class Specialization extends BaseEntity{
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Specialization{" +
                "title='" + title + '\'' +
                '}';
    }
}
