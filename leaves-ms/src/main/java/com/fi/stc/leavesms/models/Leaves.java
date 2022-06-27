package com.fi.stc.leavesms.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

/**
 * This is for employee model
 *
 * @author Fatma Ibrahim
 * @since 26-06-2022
 *
 */

//mark class as an Entity
@Entity
//defining class name as Table name
@Table
@Data
public class Leaves {
    //Defining leave id as primary key
    @Id
    @Column(name = "leave_id")
    private int leaveId;

    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "leave_type")
    private int leaveType;

    @Column(name = "number_of_days")
    private int numberOfDays;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "requested_date")
    private Date requestedDate;

    @Column(name = "modified_date")
    private Date modifiedDate;
}
