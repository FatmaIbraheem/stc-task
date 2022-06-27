package com.fi.stc.employeems.services;

import com.fi.stc.employeems.models.Employee;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * This is for employee service operation
 *
 * @author Fatma Ibrahim
 * @since 26-06-2022
 *
 */
public interface IEmployeesService {
    /**
     * getting all employees record by using the method findaAll() of CrudRepository
     *
     * @param
     * @return List<Employee>
     * @throws
     */
    public Flux<List<Employee>> getAllEmployees();

    /**
     * getting a specific record by using the method findById() of CrudRepository
     *
     * @param employeeId
     * @return Employee
     * @throws
     */
    public Mono<Employee> getEmloyeeById(int employeeId);

    /**
     * saving a specific record by using the method save() of CrudRepository
     *
     * @param employee
     * @return
     * @throws
     */
    public Mono<Employee> saveOrUpdate(Employee employee);

    /**
     * deleting a specific record by using the method deleteById() of CrudRepository
     *
     * @param employeeId
     * @return
     * @throws
     */
    public void delete(int employeeId);


    public Mono<ServerResponse> updateEmployeeLeave(int employeeId, int numberOfDays, int leaveType);
}
