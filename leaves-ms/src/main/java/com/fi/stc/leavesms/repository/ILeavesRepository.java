package com.fi.stc.leavesms.repository;

import com.fi.stc.leavesms.models.Leaves;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Employee leaves repository that extends CrudRepository
 *
 * @author Fatma Ibrahim
 * @since 26-06-2022
 *
 */
public interface ILeavesRepository extends CrudRepository<Leaves, Integer> {
    List<Leaves> findByEmployeeId(int employeeId);
}
