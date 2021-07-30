/**
 * 
 */
package com.intaroogroup.bootcamp.http.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intaroogroup.bootcamp.http.entity.CustomerEntity; 

/**
 * @author anitamarsafira
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	@Query(value = "Select max(id) from Customer",nativeQuery = true)
	Long getLastCustomerId();

}
