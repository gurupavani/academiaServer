package com.iiitbesd.academicerp.Services;

import com.iiitbesd.academicerp.Entities.Student;
import com.iiitbesd.academicerp.Models.UserCredentials;
import com.iiitbesd.academicerp.Repositories.BillsRepository;
import com.iiitbesd.academicerp.Repositories.StudentRepository;
import com.iiitbesd.academicerp.ResponseEnities.LoginResponse;
import com.iiitbesd.academicerp.ResponseEnities.StudentOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    StudentRepository studentRepository;
    public LoginResponse authenticate(UserCredentials creds){
        LoginResponse res=new LoginResponse();

        Student sd=studentRepository.findByUsername(creds.getUsername());

        if(sd!=null){
            res.setUser(true);
            if(sd.getEmail().equals(creds.getUsername()) && sd.getPassword().equals(creds.getPassword())){

                res.setStatus(true);
                res.setMsg("User Logged in Successfully.");

                StudentOverview sdOverview=new StudentOverview();
                sdOverview.setId(sd.getId());
                sdOverview.setRollno(sd.getRollno());
                sdOverview.setFname(sd.getFname());
                sdOverview.setLname(sd.getLname());
                sdOverview.setEmail(sd.getEmail());
                sdOverview.setPhotoPath(sd.getPhotoPath());
                res.setData(sdOverview);
            }else{
                res.setStatus(false);
                res.setMsg("Username or Password is wrong.");
                res.setData(null);
            }

        }else{
            res.setUser(false);
            res.setStatus(false);
            res.setMsg("No such User Available.");
            res.setData(null);
        }

        return res;

    }
}
