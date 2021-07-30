/**
 * 
 */
package com.intaroogroup.bootcamp.http.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intaroogroup.bootcamp.http.entity.TransaksiEntity;

/**
 * @author anitamarsafira
 *
 */
@Repository
public interface TransaksiRepository extends JpaRepository<TransaksiEntity, Long> {
	@Query(value = "Select max(id) from Transaksi",nativeQuery = true)
	Long getLastTransaksiId();

}
