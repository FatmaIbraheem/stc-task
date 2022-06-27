package com.fi.stc.leavesms.controller;

import com.fi.stc.leavesms.models.Leaves;
import com.fi.stc.leavesms.services.ILeavesService;
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
public class LeavesController {

    //autowire the EmployeesService class
    @Autowired
    ILeavesService leavesService;

    //creating a get mapping that retrieves all employees details from the database
    @GetMapping("/getAll")
    private Mono<ServerResponse> getAllLeaves()
    {
        return ServerResponse.ok().body(leavesService.getAllLeaves(), List.class);

    }

    //creating a get mapping that retrieves the details of a specific leaves
    @GetMapping("/{leavesId}")
    private Mono<ServerResponse> getLeaves(@PathVariable("leavesId") int leavesId)
    {
        return ServerResponse.ok().body(leavesService.getLeavesById(leavesId), Leaves.class);
    }

    //creating a get mapping that retrieves the details of a specific employee leaves
    @GetMapping("/{employeeId}")
    private Mono<ServerResponse> getLeavesByEmployeeId(@PathVariable("employeeId") int employeeId)
    {
        return ServerResponse.ok().body(leavesService.getAllEmployeeLeavesById(employeeId), List.class);
    }

    //creating a delete mapping that deletes a specified leaves
    @DeleteMapping("/delete/{leavesId}")
    private void deleteLeaves(@PathVariable("leavesId") int leavesId)
    {
        leavesService.delete(leavesId);
        ServerResponse.ok().body("done",String.class);
    }

    //creating post mapping that post the leaves detail in the database
    @PostMapping("/save")
    private void saveLeave(@RequestBody Leaves leave)
    {
        leavesService.save(leave);
        ServerResponse.ok().body("done",String.class);
    }

}
