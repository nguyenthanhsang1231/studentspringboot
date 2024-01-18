package com.example.springboot.model;

import jakarta.persistence.*;

@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;

    @ManyToOne
    private AClass classs;

    public Student() {
    }

    public Student(Long id, String name, int age, AClass aClass) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.classs = aClass;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AClass getClasss() {
        return classs;
    }

    public void setClasss(AClass aClass) {
        this.classs = aClass;
    }
}
