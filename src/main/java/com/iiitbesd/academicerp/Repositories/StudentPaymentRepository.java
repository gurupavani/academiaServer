package com.iiitbesd.academicerp.Repositories;

import com.iiitbesd.academicerp.Entities.Bill;
import com.iiitbesd.academicerp.Entities.StudentBill;
import com.iiitbesd.academicerp.Entities.StudentPayment;
import org.hibernate.sql.Insert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentPaymentRepository extends JpaRepository<StudentPayment, Integer> {


//    StudentPayment addPayment(StudentPayment studentPayment){
//        Query query = studentPayment.createQuery("INSERT INTO StudentPayment (NAME, VALUE) VALUES (?, ?)");
//        query.setParameter(1, name);
//        query.setParameter(2, value);
//        query.executeUpdate();
//    }
    @Query("SELECT s FROM StudentPayment s WHERE s.billId.id=:bid")
    Collection<StudentPayment> getStudentPaymentsByBillId(int bid);

    @Query("SELECT COALESCE(sum(s.amount),0) FROM StudentPayment s WHERE s.billId.id=:bid")
    float getTotalAmountPaidByBillId(int bid);
}
