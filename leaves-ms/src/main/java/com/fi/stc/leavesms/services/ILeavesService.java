package com.fi.stc.leavesms.services;

import java.util.List;

import com.fi.stc.leavesms.dto.EmployeeLeaveDto;
import com.fi.stc.leavesms.models.Leaves;
import com.fi.stc.leavesms.models.Leaves;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This is for leaves service operation
 *
 * @author Fatma Ibrahim
 * @since 27-06-2022
 *
 */
public interface ILeavesService {

    /**
     * getting all leaves record by using the method findaAll() of CrudRepository
     *
     * @param
     * @return List<leaves>
     * @throws
     */
    public Flux<List<Leaves>> getAllLeaves();

    /**
     * getting a specific record by using the method findById() of CrudRepository
     *
     * @param leavesId
     * @return Leaves
     * @throws
     */
    public Mono<Leaves> getLeavesById(int leavesId);

    /**
     * getting a specific record by using the method findById() of CrudRepository
     *
     * @param employeeId
     * @return Leaves
     * @throws
     */
    public Flux<EmployeeLeaveDto> getAllEmployeeLeavesById(int employeeId);

    /**
     * saving a specific record by using the method save() of CrudRepository
     *
     * @param leaves
     * @return
     * @throws
     */
    public Mono<Leaves> save(Leaves leaves);

    /**
     * deleting a specific record by using the method deleteById() of CrudRepository
     *
     * @param leavesId
     * @return
     * @throws
     */
    public void delete(int leavesId);
}
