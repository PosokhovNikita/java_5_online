package ua.com.a_level.dto;

public class SpecializationDto {
    private Long id;
    private String name;
    private Long countEmployee;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountEmployee() {
        return countEmployee;
    }

    public void setCountEmployee(Long countEmployee) {
        this.countEmployee = countEmployee;
    }

    @Override
    public String toString() {
        return "SpecializationDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countEmployee=" + countEmployee +
                '}';
    }
}
