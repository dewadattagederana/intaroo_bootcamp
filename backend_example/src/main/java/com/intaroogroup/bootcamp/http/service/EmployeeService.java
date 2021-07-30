/**
 * 
 */
package com.intaroogroup.bootcamp.http.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intaroogroup.bootcamp.http.entity.EmployeeEntity;
import com.intaroogroup.bootcamp.http.repository.EmployeeRepository;

/**
 * @author anitamarsafira
 *
 */

@Service
@Transactional
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	
	
	public void doCreateStudent(EmployeeEntity requestData) {
		// TODO Auto-generated method stub
		employeeRepository.save(requestData);
	}
	 

	public Long getLastEmployeeId() {
		// TODO Auto-generated method stub
		return employeeRepository.getLastEmployeeId();
	}

}
