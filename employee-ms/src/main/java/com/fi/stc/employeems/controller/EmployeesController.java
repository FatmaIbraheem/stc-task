package com.fi.stc.employeems.controller;

import com.fi.stc.employeems.models.Employee;
import com.fi.stc.employeems.services.IEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * This is for employee controller
 *
 * @author Fatma Ibrahim
 * @since 26-30-2022
 *
 */

@RestController
@RequestMapping("/api/v1")
public class EmployeesController {

    //autowire the EmployeesService class
    @Autowired
    IEmployeesService employeesService;

    //creating a get mapping that retrieves all employees details from the database
    @GetMapping("/getAll")
    private Mono<ServerResponse> getAllEmployees()
    {
        return ServerResponse.ok().body(employeesService.getAllEmployees(),List.class);

    }

    //creating a get mapping that retrieves the details of a specific employee
    @GetMapping("/employee-details/{employeeId}")
    private Mono<ServerResponse> getEmployee(@PathVariable("employeeId") int employeeId)
    {
        return ServerResponse.ok().body(employeesService.getEmloyeeById(employeeId), Employee.class);
    }

    //creating a delete mapping that deletes a specified emplyee
    @DeleteMapping("/delete/{employeeId}")
    private void deleteEmployee(@PathVariable("employeeId") int employeeId)
    {
        employeesService.delete(employeeId);
        ServerResponse.ok().body("done",String.class);
    }

    //creating post mapping that post the Employee detail in the database
    @PostMapping("/save")
    private void saveEmployee(@RequestBody Employee employee)
    {
        employeesService.saveOrUpdate(employee);
        ServerResponse.ok().body("done",String.class);
    }

    //creating put mapping that updates the employee detail
    @PutMapping("/update")
    private Mono<ServerResponse> update(@RequestBody Employee employee)
    {
        return ServerResponse.ok().body(employeesService.saveOrUpdate(employee),Employee.class);

    }

    @GetMapping("/update-employee-leave/employeeId/{employeeId}/days/{numberOfDays}/type/{leaveType}")
    private Mono<ServerResponse> updateEmployeeLeaves(@PathVariable int employeeId,int numberOfDays,int leaveType)
    {
        return ServerResponse.ok().body(employeesService.updateEmployeeLeave(employeeId,numberOfDays,leaveType),Employee.class);

    }
}
