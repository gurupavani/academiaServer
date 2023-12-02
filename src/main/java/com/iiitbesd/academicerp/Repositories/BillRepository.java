package com.iiitbesd.academicerp.Repositories;

import com.iiitbesd.academicerp.Entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BillRepository extends JpaRepository<Bill, Integer> {

    @Query("SELECT s FROM Bill s WHERE s.id=:id")
    Bill getBillById(int id);
}
