 
package com.intaroogroup.bootcamp.http.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intaroogroup.bootcamp.http.entity.StudentEntity;

/**
 * @author anitamarsafira
 *
 */
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
	@Query(value = "Select max(id) from Student",nativeQuery = true)
	Long getLastStudentId();

}
