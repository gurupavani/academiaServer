package com.iiitbesd.academicerp.Controllers;

import com.iiitbesd.academicerp.Models.StudentDetails;
import com.iiitbesd.academicerp.ResponseEnities.StudentOverview;
import com.iiitbesd.academicerp.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/profile")
    public ResponseEntity<StudentDetails> getStudentProfile(@RequestParam(name = "id") int studentId) {

        try {
            StudentDetails stdDetails = studentService.getStudentDetails(studentId);

            return ResponseEntity.of(Optional.of(stdDetails));
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/overview")
    public ResponseEntity<StudentOverview> getStudentOverviewDetails(@RequestParam(name = "id") int studentId) {

        try {
            StudentOverview stdOverview = studentService.getStudentOverview(studentId);

            return ResponseEntity.of(Optional.of(stdOverview));
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return ResponseEntity.status(500).build();
        }
    }
}
