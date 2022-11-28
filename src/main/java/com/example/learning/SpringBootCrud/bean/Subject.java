package com.example.learning.SpringBootCrud.bean;

import com.sun.istack.NotNull;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import lombok.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

//Model or tables are creating here


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Subject")
public class Subject {

    @Id
    private String id;//TODO AUTO GENERATE ID

    @Column(nullable = false)
    private String name;

    // @Column(unique = true) // TODO UNDO THIS COMMENT
    private String email;

    //private LocalDateTime dob;
//    public Subject() {
//    }
//    public Subject(String id, String name, String email){
//        super();
//        this.id = id;
//        this.name = name;
//        this.email= email;
//        //this.dob = dob;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//
//            return name;
//
//
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
/*

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }*/
}
