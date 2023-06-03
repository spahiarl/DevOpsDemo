package ch.zhaw.iwi.devops.demo;

public class Person {

    private int id;
    private String name;
    private String title;
    private String description;

    public Person() {
    }
    
    public Person(int id, String name, String title, String description) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }    

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
