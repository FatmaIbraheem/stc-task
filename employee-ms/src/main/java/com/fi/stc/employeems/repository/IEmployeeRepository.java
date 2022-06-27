package com.fi.stc.employeems.repository;

import com.fi.stc.employeems.models.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * Employee repository that extends CrudRepository
 *
 * @author Fatma Ibrahim
 * @since 26-06-2022
 *
 */

public interface IEmployeeRepository extends CrudRepository<Employee, Integer>{
}