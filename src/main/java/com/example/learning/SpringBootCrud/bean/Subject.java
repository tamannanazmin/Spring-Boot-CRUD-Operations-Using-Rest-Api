package com.example.learning.SpringBootCrud.bean;

import com.sun.istack.NotNull;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import java.time.LocalDateTime;

//Model or tables are creating here
@Entity
@Table(name = "Subject")
public class Subject {
    @Id
    private String id;


    @Column(name = "name", nullable = false)
    @NotNull
    private String name;
    private String email;
    //private LocalDateTime dob;
    public Subject() {
    }
    public Subject(String id, String name, String email){
        super();
        this.id = id;
        this.name = name;
        this.email= email;
        //this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {

            return name;


    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }/*

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }*/
}
