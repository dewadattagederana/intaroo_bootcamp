/**
 * 
 */
package com.intaroogroup.bootcamp.http.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intaroogroup.bootcamp.http.entity.StudentEntity;
import com.intaroogroup.bootcamp.http.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {
	//attr:start
	@Value("${spring.application.name}")
    String applicationName;
	 
	@Autowired 
	StudentService studentService;
	
    @Autowired
    RestApiUtil restApiUtil;
    //attr:stop
    
    
    @PostMapping("/")
    public Response<Object> createTrx(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            StudentEntity requestData = restApiUtil.requestToObject(httpRequest, StudentEntity.class);
            studentService.doCreateStudent(requestData);
            Long studentId = studentService.getLastStudentId();
            
            String responseData = "Student has been created with student_id"+studentId; 
            return Response.status(httpServletResponse, HttpStatus.OK, responseData);
        }catch (Exception e){
        	log.error("Error Process Create Student : " + e,e );
            return GlobalExceptionHandler.ChekingExceptionGlobal(applicationName, httpServletResponse, e);
        }
    }

    @PatchMapping("/{id}")
    //update
    public Response<Object> patchPemesananBarang(@PathVariable("id") Long studentId,HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
            StudentEntity requestData = restApiUtil.requestToObject(httpRequest, StudentEntity.class);

             studentService.doUpdateStudent(requestData,studentId);
             String responseData = "Student has been update with student_id "+studentId; 
             return Response.status(httpServletResponse, HttpStatus.OK, responseData);
        }catch (Exception e){
        	log.error("Error Process Update Student : " + e );
            return GlobalExceptionHandler.ChekingExceptionGlobal(applicationName, httpServletResponse, e);

        }
    }

    @GetMapping("/{id}")
    public Response<Object> getStudentById(@PathVariable("id") Long studentId, HttpServletResponse httpServletResponse) throws Exception {
        try {
        	Optional<StudentEntity> responseData = studentService.getStudentById(studentId);
             
            return Response.status(httpServletResponse, HttpStatus.OK, responseData);
        }catch (Exception e){
        	log.error("Error Process Get Student By Id : " + e ,e );
            return GlobalExceptionHandler.ChekingExceptionGlobal(applicationName, httpServletResponse, e);

        }
    }
    @GetMapping("/")
    public Response<Object> getAllStudent(HttpServletResponse httpServletResponse) throws Exception {
        try {
        	List<StudentEntity> responseData = studentService.getAllStudent();
             
            return Response.status(httpServletResponse, HttpStatus.OK, responseData);
        }catch (Exception e){
        	log.error("Error Process Get All Student : " + e ,e );
            return GlobalExceptionHandler.ChekingExceptionGlobal(applicationName, httpServletResponse, e);

        }
    }
}
