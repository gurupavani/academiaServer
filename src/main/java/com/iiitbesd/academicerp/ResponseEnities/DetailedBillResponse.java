package com.iiitbesd.academicerp.ResponseEnities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class DetailedBillResponse {

        private int billId;
        private String description;
        private float amount;
        private Date billDate;
        private Date deadline;
        private float paidAmount;
        private float balance;
        private int type;
}
