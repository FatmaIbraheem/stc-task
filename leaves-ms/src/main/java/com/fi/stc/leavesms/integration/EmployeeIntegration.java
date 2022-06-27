package com.fi.stc.leavesms.integration;

import com.fi.stc.leavesms.dto.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;


@Service
public class EmployeeIntegration implements IntegrationService{

    @Autowired
    RestTemplate restTemplate;

    @Value("${employee.base.url}")
    private String employeeMsBaseUrl;

    @Value("${update.employee.leaves.url}")
    private String updateEmployeeLeavesUrl;
    @Value("${get.employee.details.url}")
    private String getEmployeeDetailsUrl;

    public ResponseEntity updateEmployeeLeaves(int employeeId,int numberOfDays,int leaveType){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<>(headers);
        return IntegrationService.super.callApi(
                restTemplate,
                handleUpdateEmployeeLeavesUrl(employeeMsBaseUrl,updateEmployeeLeavesUrl,employeeId,numberOfDays,leaveType),
                null,
                entity,
                HttpMethod.GET,
                null
                );

    }

    private String handleUpdateEmployeeLeavesUrl(String employeeMsBaseUrl,String updateEmployeeLeavesUrl,int employeeId,int numberOfDays,int leaveType){
        String getEmployeeIdUrl=String.format(updateEmployeeLeavesUrl,employeeId,numberOfDays,leaveType);
        return employeeMsBaseUrl+getEmployeeIdUrl;
    }



    public Optional<EmployeeDto> getEmployeeDetails(int employeeId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<>(headers);
        ResponseEntity responseEntity= IntegrationService.super.callApi(
                restTemplate,
                handleGetEmployeeDetailsUrl(employeeMsBaseUrl,getEmployeeDetailsUrl,employeeId),
                null,
                entity,
                HttpMethod.GET,
                EmployeeDto.class
        );
        if (responseEntity.getStatusCode().is2xxSuccessful()){
            return Optional.of((EmployeeDto) responseEntity.getBody());
        }else {
            return Optional.empty();
        }
    }
    private String handleGetEmployeeDetailsUrl(String employeeMsBaseUrl,String getEmployeeDetailsUrl,int employeeId){
        String getEmployeeIdUrl=String.format(getEmployeeDetailsUrl,employeeId);
        return employeeMsBaseUrl+getEmployeeIdUrl;
    }
}
