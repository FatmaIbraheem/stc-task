package com.fi.stc.employeems.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class Employee {
    //Defining employee id as primary key
    @Id
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "name")
    private String employeeName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "max_paid_leaves")
    private int maxPaidLeaves;

    @Column(name = "left_paid_leaves")
    private int leftPaidLeaves;

    @Column(name = "taken_paid_leaves")
    private int takenPaidLeaves;

    @Column(name = "taken_unpaid_leaves")
    private int takenUnpaidLeaves;
}
