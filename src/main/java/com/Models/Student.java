package com.Models;


import com.Validators.MyValidation;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
@MyValidation
public class Student {

    @Min(value = 2, message = "id error!!!!!!!!!!!!!!")
    private int id;

    @Size(min = 2, message = "name error!!!!!!!!!!!!!!!!")
    @JsonProperty(value = "nm")
    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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
}
