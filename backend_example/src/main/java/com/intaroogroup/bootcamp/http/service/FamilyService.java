/**
 * 
 */
package com.intaroogroup.bootcamp.http.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intaroogroup.bootcamp.http.entity.FamilyEntity;
import com.intaroogroup.bootcamp.http.repository.FamilyRepository;

/**
 * @author anitamarsafira
 *
 */



@Service
@Transactional
public class FamilyService {

	
	@Autowired
	private FamilyRepository familyRepository;
	
	
	public void doCreateFamily(FamilyEntity requestData) {
		// TODO Auto-generated method stub
		familyRepository.save(requestData);
	}
	 

	public Long getLastFamilyId() {
		// TODO Auto-generated method stub
		return familyRepository.getLastFamilyId();
	}

}
