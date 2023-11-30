package com.iiitbesd.academicerp.ResponseEnities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class LoginResponse {
    private boolean user;
    private boolean status;
    private StudentOverview data;
    private String msg;
}
