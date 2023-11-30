package com.iiitbesd.academicerp.ResponseEnities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StudentOverview {

    private int id;
    private String rollno;
    private String fname;
    private String lname;
    private String email;
    private String photoPath;
}
