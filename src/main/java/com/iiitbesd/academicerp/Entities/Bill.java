package com.iiitbesd.academicerp.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="Bills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="description")
    private String description;

    @Column(name="amount",nullable = false)
    private float amount;

    @Column(name="bill_date",nullable = false)
    private Date billDate;


    @Column(name="deadline")
    private  Date deadline;

    @OneToOne(mappedBy = "billId" ,cascade = CascadeType.ALL)
    @JsonManagedReference
    private StudentBill studentBill;

    @OneToMany(mappedBy = "billId", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Collection<StudentPayment> studentPayment;
}
