package com.example.learning.SpringBootCrud.repository;

import com.example.learning.SpringBootCrud.bean.Subject;
import org.springframework.data.repository.CrudRepository;
//ekta interface jekhane CrudRepository add kora hoy
public interface SubjectRepository extends CrudRepository<Subject, String> {

}
