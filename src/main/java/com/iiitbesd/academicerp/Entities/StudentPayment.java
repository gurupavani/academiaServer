package com.iiitbesd.academicerp.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name="Student_Payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student studentId;

    @Column(name="description")
    private String description;

    @Column(name="amount",nullable = false)
    private float amount;

    @Column(name="payment_date",nullable = false)
    private Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    private Bill billId;
}
