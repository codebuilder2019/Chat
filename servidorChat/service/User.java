package servidorChat.service;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;
    private String role;
    private String department;
    private String user;
    private String password;
    
    public User(int id, String name, String role, String department, String user, String password){
        this.id = id;
        this.name = name;
        this.role = role;
        this.department = department;
        this.user = user;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    public String getUser() {
        return user;
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

    public void setRole(String role) {
        this.role = role;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
