package com.iiitbesd.academicerp.RequestEntities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BillPayment {
    private int billId;
    private int studentId;
    private float amount;
    private String description;
}
