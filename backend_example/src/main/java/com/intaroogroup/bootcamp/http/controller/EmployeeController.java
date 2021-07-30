/**
 * 
 */
package com.intaroogroup.bootcamp.http.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intaroogroup.bootcamp.http.dto.EmployeeDTORequest;
import com.intaroogroup.bootcamp.http.entity.EmployeeEntity;
import com.intaroogroup.bootcamp.http.service.EmployeeService;
import com.intaroogroup.bootcamp.http.utils.GlobalExceptionHandler;
import com.intaroogroup.bootcamp.http.utils.Response;
import com.intaroogroup.bootcamp.http.utils.RestApiUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anitamarsafira
 *
 */


@Slf4j
@RestController
@RequestMapping("/employee")

public class EmployeeController {
	//attr:start
	@Value("${spring.application.name}")
    String applicationName;
	 
	@Autowired 
	EmployeeService employeeService;
	
    @Autowired
    RestApiUtil restApiUtil;
    
    @Value("${spring.application.url.tax}")
    static String urlTax;
    //attr:stop
    
 
    
    @PostMapping("/")
    public Response<Object> createEmp(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            EmployeeDTORequest requestData = restApiUtil.requestToObject(httpRequest, EmployeeDTORequest.class);
            
            
            EmployeeEntity entityData = new EmployeeEntity();
            entityData.setAddress(requestData.getAddress());
            entityData.setId(requestData.getId());
            entityData.setName(requestData.getName());
            entityData.setSalary(new BigDecimal(requestData.getSalary()));
            
            
            employeeService.doCreateStudent(entityData);
            Long employeeId = employeeService.getLastEmployeeId();
            
            String responseData = "Employee has been created with employee_id "+employeeId; 
            return Response.status(httpServletResponse, HttpStatus.OK, responseData);
        }catch (Exception e){
        	log.error("Error Process Create Employee : " + e,e );
            return GlobalExceptionHandler.ChekingExceptionGlobal(applicationName, httpServletResponse, e);
        }
    }
}
