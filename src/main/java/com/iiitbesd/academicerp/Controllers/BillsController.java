package com.iiitbesd.academicerp.Controllers;

import com.iiitbesd.academicerp.Entities.StudentPayment;
import com.iiitbesd.academicerp.RequestEntities.BillPayment;
import com.iiitbesd.academicerp.RequestEntities.UserCredentials;
import com.iiitbesd.academicerp.ResponseEnities.*;
import com.iiitbesd.academicerp.Services.BillsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/bills")
public class BillsController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    BillsService billsService;

    @GetMapping("")
    public ResponseEntity<Collection<StudentResponseBill>> getStudentBills(@RequestParam(name = "std_id") int studentID) {
        Collection<StudentResponseBill> bills;
        try {
            bills = billsService.getAllStudentBillsById(studentID);

            return ResponseEntity.status(HttpStatus.OK).body(bills);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/bill")
    public ResponseEntity<DetailedBillResponse> getBillDetails(@RequestParam(name = "billid") int billId) {
        DetailedBillResponse bill;
        try {
            bill = billsService.getBillInfoById(billId);

            return ResponseEntity.status(HttpStatus.OK).body(bill);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/bill/history")
    public ResponseEntity<BillHistoryResponse> getBillPaymentHistory(@RequestParam(name = "billid") int billId) {
        BillHistoryResponse res = new BillHistoryResponse();
        try {
            Collection<StudentPayment> temp = billsService.getBillHistoryById(billId);
            res.setStatus(true);
            res.setData(temp);
//            logger.warn(temp.isEmpty() ? "no data" : temp.iterator().next().getDescription());
            return ResponseEntity.status(HttpStatus.OK).body(res);
        } catch (Exception e) {
            res.setStatus(false);
            res.setData(null);
            res.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }

    @PostMapping("/bill/pay")
    public ResponseEntity<BillPaymentResponse> payStudentBill(@RequestBody BillPayment billPayment) {
        BillPaymentResponse res = new BillPaymentResponse();

//        logger.warn(billPayment.getBillId()+" "+ billPayment.getStudentId());

        try {
            StudentPayment temp = billsService.payBill(billPayment);
            res.setStatus(true);
            res.setData(temp);
            res.setMsg("Payment done successfully");
            return ResponseEntity.status(HttpStatus.OK).body(res);


        } catch (Exception e) {
            res.setStatus(false);
            res.setMsg(e.getMessage());
            res.setData(null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }
}
