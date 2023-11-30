package com.iiitbesd.academicerp.Controllers;

import com.iiitbesd.academicerp.Entities.StudentBill;
import com.iiitbesd.academicerp.Models.StudentResponseBill;
import com.iiitbesd.academicerp.Services.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/bills")
public class BillsController {

    @Autowired
    BillsService billsService;

    @GetMapping("/")
    public ResponseEntity<Collection<StudentResponseBill>> getStudentBills(@RequestParam(name = "std_id") int studentID) {
        try {
            Collection<StudentResponseBill> bills = billsService.getAllStudentBillsById(studentID);
            return ResponseEntity.of(Optional.of(bills));
        } catch (Exception e) {

            System.out.println(e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }
}
