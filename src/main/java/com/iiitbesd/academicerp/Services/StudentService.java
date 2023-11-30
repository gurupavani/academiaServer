package com.iiitbesd.academicerp.Services;

import com.iiitbesd.academicerp.Entities.Student;
import com.iiitbesd.academicerp.Models.StudentDetails;
import com.iiitbesd.academicerp.ResponseEnities.StudentOverview;
import com.iiitbesd.academicerp.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentDetails getStudentDetails(int studentID){
        StudentDetails studentDetails = new StudentDetails();

        Student student=studentRepository.findById(studentID);

        studentDetails.setId(student.getId());
        studentDetails.setRollno(student.getRollno());
        studentDetails.setFname(student.getFname());
        studentDetails.setLname(student.getLname());
        studentDetails.setEmail(student.getEmail());
        studentDetails.setCgpa(student.getCgpa());
        studentDetails.setTotalCredits(student.getTotalCredits());
        studentDetails.setGradYear(student.getGradYear());


        return studentDetails;
    }

    public StudentOverview getStudentOverview(int studentID){
        StudentOverview studentOverview = new StudentOverview();

        Student student=studentRepository.findById(studentID);

        studentOverview.setId(student.getId());
        studentOverview.setRollno(student.getRollno());
        studentOverview.setFname(student.getFname());
        studentOverview.setLname(student.getLname());
        studentOverview.setEmail(student.getEmail());


        return studentOverview;
    }
}
