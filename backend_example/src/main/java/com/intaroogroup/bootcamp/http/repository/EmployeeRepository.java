/**
 * 
 */
package com.intaroogroup.bootcamp.http.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intaroogroup.bootcamp.http.entity.EmployeeEntity;

/**
 * @author anitamarsafira
 *
 */

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
	@Query(value = "Select max(id) from Employee",nativeQuery = true)
	Long getLastEmployeeId();
 

}
