/**
 * 
 */
package com.intaroogroup.bootcamp.http.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intaroogroup.bootcamp.http.entity.TransaksiEntity;
import com.intaroogroup.bootcamp.http.repository.TransaksiRepository;

/**
 * @author anitamarsafira
 *
 */
@Service
@Transactional
public class TransaksiService {
	@Autowired
	private TransaksiRepository transaksiRepository;
	public void doCreateTransaksi(TransaksiEntity requestData) {
		// TODO Auto-generated method stub
		
	 transaksiRepository.save(requestData);
	}

	public Long getLastTransaksiId() {
		// TODO Auto-generated method stub
		
		return transaksiRepository.getLastTransaksiId();
	}

	public void doUpdateTransaksi(TransaksiEntity requestData, Long transaksiId) {
		// TODO Auto-generated method stub
		Optional<TransaksiEntity> dataToUpdate = transaksiRepository.findById(transaksiId);
		TransaksiEntity data = dataToUpdate.get();
		data.setName(requestData.getName());
		transaksiRepository.save(data);
	}
 
	
  
}
