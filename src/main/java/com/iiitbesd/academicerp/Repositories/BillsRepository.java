package com.iiitbesd.academicerp.Repositories;

import com.iiitbesd.academicerp.Entities.Bill;
import com.iiitbesd.academicerp.Entities.Student;
import com.iiitbesd.academicerp.Entities.StudentBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BillsRepository extends JpaRepository<Bill, Integer> {

    @Query("SELECT sb FROM StudentBill sb WHERE sb.studentId.id=:sid")
    Collection<StudentBill> findBillsByStudentId(int sid);

}
