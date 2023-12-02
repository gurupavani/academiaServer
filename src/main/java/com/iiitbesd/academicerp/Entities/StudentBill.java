package com.iiitbesd.academicerp.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Student_Bills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentBill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student studentId;

    @OneToOne
    @JoinColumn(name = "bill_id")
    @JsonBackReference
    private Bill billId;
}
