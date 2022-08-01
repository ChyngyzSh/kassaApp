package kg.megacom.kassaapp.models;

public class Position {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Position() {
    }

    @Override
    public String toString() {
        return getName();
    }
}