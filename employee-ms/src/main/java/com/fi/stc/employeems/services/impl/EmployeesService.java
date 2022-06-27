package com.fi.stc.employeems.services.impl;

import com.fi.stc.employeems.models.Employee;
import com.fi.stc.employeems.models.enums.LeaveTypeEnum;
import com.fi.stc.employeems.repository.IEmployeeRepository;
import com.fi.stc.employeems.services.IEmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * {@inheritDoc}
 */

@Service
public class EmployeesService implements IEmployeesService {
    @Autowired
    IEmployeeRepository employeesRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Flux<List<Employee>> getAllEmployees()
    {
        List<Employee> employees = new ArrayList<Employee>();
        employeesRepository.findAll().forEach(employees::add);
        return Flux.just(employees);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Employee> getEmloyeeById(int employeeId)
    {
        Employee employee=null;
        Optional<Employee> optionalEmployee=employeesRepository.findById(employeeId);
        if (optionalEmployee.isPresent()){
            employee= optionalEmployee.get();
            return Mono.just(employee);
        }
        return Mono.just(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Employee> saveOrUpdate(Employee employee)
    {
        Employee updatedEmployee=employeesRepository.save(employee);
        return Mono.just(updatedEmployee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int employeeId)
    {
        employeesRepository.deleteById(employeeId);
    }

    @Override
    public Mono<ServerResponse> updateEmployeeLeave(int employeeId, int numberOfDays, int leaveType) {
        Optional<Employee> optionalEmployee=employeesRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee=optionalEmployee.get();
            if (LeaveTypeEnum.PAID.getTypeValue() == leaveType) {
                int paidTakeDays=employee.getTakenPaidLeaves()+numberOfDays;
                int leftPaidDays=employee.getLeftPaidLeaves()-numberOfDays;
                employee.setTakenPaidLeaves(paidTakeDays);
                employee.setLeftPaidLeaves(leftPaidDays);
            } else {
                int unpaidTakenDays=employee.getTakenPaidLeaves()+numberOfDays;
                employee.setTakenUnpaidLeaves(unpaidTakenDays);
            }
            employee=employeesRepository.save(employee);
            return ServerResponse.ok().body("done",String.class);
        }
        return ServerResponse.badRequest().body("employee not exist",String.class);

    }


}
