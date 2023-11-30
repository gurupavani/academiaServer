package com.iiitbesd.academicerp.Repositories;

import com.iiitbesd.academicerp.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findById(int id);

    @Query("SELECT s FROM Student s WHERE s.email=:username")
    Student findByUsername(String username);


}
