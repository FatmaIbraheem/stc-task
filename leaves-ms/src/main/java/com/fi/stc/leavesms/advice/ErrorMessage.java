package com.fi.stc.leavesms.advice;

import lombok.Data;

import java.util.Date;


@Data
public class ErrorMessage {
    private Date date;
    private String message;
    public ErrorMessage(Date date, String message) {
        this.date=date;
        this.message=message;
    }
}
