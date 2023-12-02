package com.iiitbesd.academicerp.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name="Students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private int id;

    @Column(name="roll_number",nullable = false,unique = true)
    private String rollno;

    @Column(name="first_name",nullable = false)
    private String fname;

    @Column(name="last_name")
    private String lname;

    @Column(name="email",nullable = false,unique = true)
    private String email;

    @Column(name="password",nullable = false)
    private String password;

    @Column(name="photograph_path")
    private String photoPath;

    @Column(name = "cgpa",nullable = false,columnDefinition="Decimal(10,2) default '0.00'")
    private float cgpa;

    @Column(name="total_credits",nullable = false)
    private int totalCredits;

    @Column(name="graduation_year")
    private int gradYear;

    @OneToMany(mappedBy = "studentId" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<StudentBill> studentBills;

    @OneToMany(mappedBy = "studentId")
    @JsonManagedReference
    private Collection<StudentPayment> studentPayments;
}
