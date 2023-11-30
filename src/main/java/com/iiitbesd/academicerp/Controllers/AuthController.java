package com.iiitbesd.academicerp.Controllers;

import com.iiitbesd.academicerp.Models.UserCredentials;
import com.iiitbesd.academicerp.ResponseEnities.LoginResponse;
import com.iiitbesd.academicerp.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "myName", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> loginUser(@RequestBody UserCredentials userCreds) {
        LoginResponse res;
        res = new LoginResponse();
        try {
//            if (userCreds.getUsername().equals("pavani") && userCreds.getPassword().equals("pavani1234")) {
//                return "User Login successful";
//            } else {
//                return "Incorrect Username or Password";
//            }
            res=authService.authenticate(userCreds);

            if(res.isStatus()){
return ResponseEntity.status(HttpStatus.OK).body(res);
            }else{
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(res);
            }

        } catch (Exception e) {
            res.setUser(false);
            res.setStatus(false);
            res.setMsg(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res);
        }
    }

    @PostMapping("/logout")
    public String logoutUser() {
        try {
            return "User Logged Out Successfully";

        } catch (Exception e) {
            return "Error At backend";
        }
    }
}
