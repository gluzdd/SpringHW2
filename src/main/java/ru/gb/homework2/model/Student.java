package ru.gb.homework2.model;


public class Student {

    private Long id;
    private String name;
    private String groupname;

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

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public Student(Long id, String name, String groupname) {
        this.id = id;
        this.name = name;
        this.groupname = groupname;
    }
}
