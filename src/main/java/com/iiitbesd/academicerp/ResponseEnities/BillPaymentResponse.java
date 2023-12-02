package com.iiitbesd.academicerp.ResponseEnities;

import com.iiitbesd.academicerp.Entities.StudentPayment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BillPaymentResponse {
    private boolean status;
    private StudentPayment data;
    private String msg;
}
