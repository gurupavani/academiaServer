package com.iiitbesd.academicerp.Services;

import com.iiitbesd.academicerp.Entities.StudentBill;
import com.iiitbesd.academicerp.Models.StudentResponseBill;
import com.iiitbesd.academicerp.Repositories.BillsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

@Service
public class BillsService {

    @Autowired
    BillsRepository billsRepository;

    public Collection<StudentResponseBill> getAllStudentBillsById(int studentID){
        Collection<StudentBill> studentbills=billsRepository.findBillsByStudentId(studentID);

        Collection<StudentResponseBill> resultBills=new ArrayList<StudentResponseBill>();
        StudentResponseBill tempbill;
        for(StudentBill bill : studentbills){
            tempbill=new StudentResponseBill();
            tempbill.setStudentId(bill.getStudentId().getId());
            tempbill.setBillId(bill.getBillId().getId());
            tempbill.setDescription(bill.getBillId().getDescription());
            tempbill.setAmount(bill.getBillId().getAmount());
            tempbill.setBillDate(bill.getBillId().getBillDate().toString());
            tempbill.setDeadline(bill.getBillId().getDeadline()!=null?bill.getBillId().getDeadline().toString():null);

            resultBills.add(tempbill);
        }

        return resultBills;

    }
}
