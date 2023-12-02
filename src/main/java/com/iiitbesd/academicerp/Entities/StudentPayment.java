package com.iiitbesd.academicerp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Optional;

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
    @JsonBackReference
    private Student studentId;

    @Column(name="description")
    private String description;

    @Column(name="amount",nullable = false)
    private float amount;

    @Column(name="payment_date",nullable = false)
    private Date paymentDate;

    @ManyToOne
    @JoinColumn(name = "bill_id")
    @JsonBackReference
    private Bill billId;

}
