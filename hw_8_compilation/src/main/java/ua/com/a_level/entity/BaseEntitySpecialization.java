package ua.com.a_level.entity;

public abstract class BaseEntitySpecialization {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BaseEntitySpecialization{" +
                "id='" + id + '\'' +
                '}';
    }
}
