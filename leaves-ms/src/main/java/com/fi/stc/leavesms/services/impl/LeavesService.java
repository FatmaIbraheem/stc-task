package com.fi.stc.leavesms.services.impl;

import com.fi.stc.leavesms.dto.EmployeeDto;
import com.fi.stc.leavesms.dto.EmployeeLeaveDto;
import com.fi.stc.leavesms.integration.EmployeeIntegration;
import com.fi.stc.leavesms.models.Leaves;
import com.fi.stc.leavesms.services.ILeavesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fi.stc.leavesms.repository.ILeavesRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * {@inheritDoc}
 */

@Service
public class LeavesService implements ILeavesService {

    @Autowired
    EmployeeIntegration employeeIntegration;
    @Autowired
    ILeavesRepository leavesRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Flux<List<Leaves>> getAllLeaves() {
        List<Leaves> leaves = new ArrayList<Leaves>();
        leavesRepository.findAll().forEach(leaves::add);
        return Flux.just(leaves);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Leaves> getLeavesById(int leavesId) {
        Leaves leaves = null;

        Optional<Leaves> optionalLeaves = leavesRepository.findById(leavesId);
        if (optionalLeaves.isPresent()){
            leaves= optionalLeaves.get();
            return Mono.just(leaves);
        }

        return Mono.just(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Flux<EmployeeLeaveDto> getAllEmployeeLeavesById(int employeeId) {
        List<Leaves> leaves = new ArrayList<Leaves>();
        EmployeeLeaveDto employeeLeaveDto=new EmployeeLeaveDto();
        Optional<EmployeeDto> employeeDto=employeeIntegration.getEmployeeDetails(employeeId);
        if (employeeDto.isPresent()){
            employeeLeaveDto.setEmployeeName(employeeDto.get().getEmployeeName());
            employeeLeaveDto.setEmail(employeeDto.get().getEmail());
            employeeLeaveDto.setPhone(employeeDto.get().getPhone());
        }
        leavesRepository.findByEmployeeId(employeeId).forEach(leaves::add);
        employeeLeaveDto.setLeaves(leaves);
        return Flux.just(employeeLeaveDto);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Mono<Leaves> save(Leaves leaves) {
        Leaves updatedLeaves = leavesRepository.save(leaves);
        // select employee id from employee microservice
        employeeIntegration.updateEmployeeLeaves(leaves.getEmployeeId(),leaves.getNumberOfDays(),leaves.getLeaveType());
        return Mono.just(updatedLeaves);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(int leavesId) {
        leavesRepository.deleteById(leavesId);
    }
}
