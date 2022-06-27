package com.fi.stc.leavesms.dto;


import com.fi.stc.leavesms.models.Leaves;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeLeaveDto {
    private String employeeName;
    private String phone;
    private String email;
    private List<Leaves> leaves;
}
