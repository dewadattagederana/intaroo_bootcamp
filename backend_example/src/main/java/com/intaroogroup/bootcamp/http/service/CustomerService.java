/**
 * 
 */
package com.intaroogroup.bootcamp.http.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intaroogroup.bootcamp.http.entity.CustomerEntity;
import com.intaroogroup.bootcamp.http.repository.CustomerRepository;

/**
 * @author anitamarsafira
 *
 */

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	public void doCreateCustomer(CustomerEntity requestData) {
		// TODO Auto-generated method stub
		
		customerRepository.save(requestData);
	}

	public Long getLastCustomerId() {
		// TODO Auto-generated method stub
		
		return customerRepository.getLastCustomerId();
	}

	 
}
