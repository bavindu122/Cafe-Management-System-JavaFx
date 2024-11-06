package com.example.demo.Controllers.Admin;

public class Admin {
    private static String name;
    private String password;

    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
