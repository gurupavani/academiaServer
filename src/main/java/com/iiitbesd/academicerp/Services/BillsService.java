package com.iiitbesd.academicerp.Services;

import com.iiitbesd.academicerp.Entities.Bill;
import com.iiitbesd.academicerp.Entities.Student;
import com.iiitbesd.academicerp.Entities.StudentBill;
import com.iiitbesd.academicerp.Entities.StudentPayment;
import com.iiitbesd.academicerp.Repositories.BillRepository;
import com.iiitbesd.academicerp.Repositories.StudentPaymentRepository;
import com.iiitbesd.academicerp.Repositories.StudentRepository;
import com.iiitbesd.academicerp.RequestEntities.BillPayment;
import com.iiitbesd.academicerp.ResponseEnities.BillHistoryResponse;
import com.iiitbesd.academicerp.ResponseEnities.BillPaymentResponse;
import com.iiitbesd.academicerp.ResponseEnities.DetailedBillResponse;
import com.iiitbesd.academicerp.ResponseEnities.StudentResponseBill;
import com.iiitbesd.academicerp.Repositories.StudentBillRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Service
public class BillsService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    StudentBillRepository studentBillRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentPaymentRepository studentPaymentRepository;

    @Autowired
    BillRepository billRepository;

    public Collection<StudentResponseBill> getAllStudentBillsById(int studentID) {
        Collection<StudentBill> studentbills = studentBillRepository.findBillsByStudentId(studentID);

        Collection<StudentResponseBill> resultBills = new ArrayList<StudentResponseBill>();
        StudentResponseBill tempbill;
        float totalPaid;
        for (StudentBill bill : studentbills) {
            totalPaid = studentPaymentRepository.getTotalAmountPaidByBillId(bill.getBillId().getId());
            tempbill = new StudentResponseBill();
            tempbill.setStudentId(bill.getStudentId().getId());
            tempbill.setBillId(bill.getBillId().getId());
            tempbill.setDescription(bill.getBillId().getDescription());
            tempbill.setAmount(bill.getBillId().getAmount());
            tempbill.setBillDate(bill.getBillId().getBillDate().toString());
            tempbill.setDeadline(bill.getBillId().getDeadline() != null ? bill.getBillId().getDeadline().toString() : null);
            tempbill.setType(totalPaid == 0 ? 1 : bill.getBillId().getAmount() - totalPaid > 0 ? 2 : 3);
            resultBills.add(tempbill);
        }

        return resultBills;

    }

    public DetailedBillResponse getBillInfoById(int billID) {

        Bill bill = billRepository.getBillById(billID);
        float totalPaid = studentPaymentRepository.getTotalAmountPaidByBillId(billID);
        DetailedBillResponse db = new DetailedBillResponse();
        db.setBillId(bill.getId());
        db.setDescription(bill.getDescription());
        db.setAmount(bill.getAmount());
        db.setPaidAmount(totalPaid);
        db.setBalance(bill.getAmount() - totalPaid);
        db.setBillDate(bill.getBillDate());
        db.setDeadline(bill.getDeadline());
//        1 means not paid 2 means partially paid 3 means paid
        db.setType(totalPaid == 0 ? 1 : bill.getAmount() - totalPaid > 0 ? 2 : 3);
        return db;
    }

    public Collection<StudentPayment> getBillHistoryById(int billId) {

        Collection<StudentPayment> payments = studentPaymentRepository.getStudentPaymentsByBillId(billId);
//        logger.warn(payments.isEmpty() ? "empty" : payments.iterator().next().getId() + "");
        return payments;
    }

    public StudentPayment payBill(BillPayment billPayment) {

        Bill bill = billRepository.getBillById(billPayment.getBillId());
        Student student = studentRepository.findById(billPayment.getStudentId());
//        logger.info(billPayment.getBillId()+"");
//        logger.info(billPayment.getStudentId()+"");
//        logger.info(student.toString());
//        logger.info(bill.toString());

        StudentPayment studentPayment = new StudentPayment();

        studentPayment.setBillId(bill);
        studentPayment.setStudentId(student);
        studentPayment.setAmount(billPayment.getAmount());
        studentPayment.setDescription(billPayment.getDescription());
        studentPayment.setPaymentDate(new Date(System.currentTimeMillis()));

        studentPayment = studentPaymentRepository.save(studentPayment);
//logger.warn(studentPayment.getDescription());

        return studentPayment;
    }
}
