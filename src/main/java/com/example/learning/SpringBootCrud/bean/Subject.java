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
@Builder
@Table(name = "Subject")
public class Subject {

    @Id
    private String id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true) // TODO UNDO THIS COMMENT
    private String email;

}
