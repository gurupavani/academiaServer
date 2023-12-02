package com.iiitbesd.academicerp.Repositories;

import com.iiitbesd.academicerp.Entities.StudentBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentBillRepository extends JpaRepository<StudentBill, Integer> {

    @Query("SELECT sb FROM StudentBill sb WHERE sb.studentId.id=:sid")
    Collection<StudentBill> findBillsByStudentId(int sid);



}
