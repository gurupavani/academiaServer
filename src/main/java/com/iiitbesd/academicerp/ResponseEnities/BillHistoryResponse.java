package com.iiitbesd.academicerp.ResponseEnities;

import com.iiitbesd.academicerp.Entities.StudentPayment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class BillHistoryResponse {
    private boolean status;
    private Collection<StudentPayment> data;
    private String msg;
}
