package com.iiitbesd.academicerp.Controllers;

import com.iiitbesd.academicerp.RequestEntities.LogoutCred;
import com.iiitbesd.academicerp.RequestEntities.UserCredentials;
import com.iiitbesd.academicerp.ResponseEnities.LoginResponse;
import com.iiitbesd.academicerp.ResponseEnities.LogoutResponse;
import com.iiitbesd.academicerp.Services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            res = authService.authenticate(userCreds);

            if (res.isStatus()) {
                return ResponseEntity.status(HttpStatus.OK).body(res);
            } else {
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
    public ResponseEntity<LogoutResponse> logoutUser(@RequestBody LogoutCred lgCred) {
        LogoutResponse res = new LogoutResponse();
        res.setStatus(true);
        res.setMsg("Logged out Successfully.");

        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
}
