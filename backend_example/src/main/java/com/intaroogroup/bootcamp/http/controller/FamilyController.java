/**
 * 
 */
package com.intaroogroup.bootcamp.http.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intaroogroup.bootcamp.http.entity.FamilyEntity;
import com.intaroogroup.bootcamp.http.service.FamilyService;
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
@RequestMapping("/family")
public class FamilyController {
	//attr:start
	@Value("${spring.application.name}")
    String applicationName;
	 
	@Autowired 
	FamilyService familyService;
	
    @Autowired
    RestApiUtil restApiUtil;
    //attr:stop
  
    
    
    
    @PostMapping("/")
    public Response<Object> createFamily(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            FamilyEntity requestData = restApiUtil.requestToObject(httpRequest, FamilyEntity.class);
            familyService.doCreateFamily(requestData);
            Long familyId = familyService.getLastFamilyId();
            
            String responseData = "Family has been created with family_id "+familyId; 
            return Response.status(httpServletResponse, HttpStatus.OK, responseData);
        }catch (Exception e){
        	log.error("Error Process Family Employee : " + e,e );
            return GlobalExceptionHandler.ChekingExceptionGlobal(applicationName, httpServletResponse, e);
        }
    }
    
    
    
}
