package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public class UserDAta {

    public String name;

    @JsonIgnore
    public int age;

    @JsonProperty("real_address")
    public String address;

    @JsonGetter("information")
    public String info(){
        return "Username is " + name + ", age is " + age + " and the address " + address;
    }

    public UserDAta(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
