package com.iiitbesd.academicerp.Models;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StudentDetails {
    private int id;
    private String rollno;
    private String fname;
    private String lname;
    private String email;
    private String photoPath;
    private float cgpa;
    private int totalCredits;
    private int gradYear;
}
