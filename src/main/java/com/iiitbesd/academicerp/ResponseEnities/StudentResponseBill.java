package com.iiitbesd.academicerp.ResponseEnities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StudentResponseBill {
    private int studentId;
    private int billId;
    private String description;
    private float amount;
    private String billDate;
    private String deadline;
    private int type;
}
