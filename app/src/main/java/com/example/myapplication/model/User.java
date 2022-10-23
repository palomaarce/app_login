package com.example.myapplication.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String login;
    private String password;

    private static List<User> users= new ArrayList<>();



    public User(int id, String name, String login, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static List<User> getUsers(){
        users = new ArrayList<>();
        users.add(new User(1, "Paloma", "palomaarce", "1234"));
        users.add(new User(2, "Paloma Arce", "palomaarce2", "1234"));
        return users;

    }

    public User returnUser(int indice){
        return users.get(indice);
    }
}
