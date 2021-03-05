package com.DTO;

public class StudentDTO {
    private String name;

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
