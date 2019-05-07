package io.swagger.database;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import org.threeten.bp.LocalDate;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
public class UserMongo {

    @Id
    private String id;
    @Indexed(unique = true)
    private String email;
    private String password;
    private List<String> roles;
    private String name;
    private Float height;
    private LocalDate birthday;

    public UserMongo() {
        roles = new ArrayList<>();
    }

    public UserMongo(String email, String password, String name, Float height, LocalDate birthday) {
        this();
        this.email = email;
        this.password = password;
        this.roles.add("user");
        this.name = name;
        this.height = height;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "UserMongo{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", birthday=" + birthday +
                '}';
    }
}
