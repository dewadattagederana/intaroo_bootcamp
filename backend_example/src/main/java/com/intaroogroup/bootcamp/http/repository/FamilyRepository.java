/**
 * 
 */
package com.intaroogroup.bootcamp.http.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intaroogroup.bootcamp.http.entity.FamilyEntity;

/**
 * @author anitamarsafira
 *
 */

@Repository
public interface FamilyRepository  extends JpaRepository<FamilyEntity, Long> {
	 @Query(value = "Select max(id) from Family",nativeQuery = true)
	
	Long getLastFamilyId();

}
