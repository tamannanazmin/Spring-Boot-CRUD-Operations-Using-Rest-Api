package com.example.learning.SpringBootCrud.repository;

import com.example.learning.SpringBootCrud.bean.Subject;
import com.example.learning.SpringBootCrud.dto.SubjectDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//ekta interface jekhane CrudRepository add kora hoy
public interface SubjectRepository extends JpaRepository<Subject, String> {
    public boolean existsByEmail(String email);
    Optional<Subject> findByEmail(String email);
}
