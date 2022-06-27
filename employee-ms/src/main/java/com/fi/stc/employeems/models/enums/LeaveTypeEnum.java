package com.fi.stc.employeems.models.enums;

public enum LeaveTypeEnum {

    PAID(1),
    UNPAID(2);
    public final int  type;

    LeaveTypeEnum(int i) {
        this.type=i;
    }
    public int getTypeValue() {
        return type;
    }
}
