/**
 * 
 */
package com.intaroogroup.bootcamp.http.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intaroogroup.bootcamp.http.entity.StudentEntity;
import com.intaroogroup.bootcamp.http.repository.StudentRepository;

/**
 * @author anitamarsafira
 *
 */
@Service
@Transactional
public class StudentService {
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	
	
	public void doCreateStudent(StudentEntity requestData) {
		// TODO Auto-generated method stub
		
		studentRepository.save(requestData);
	}

	public Long getLastStudentId() {
		// TODO Auto-generated method stub
		
		return studentRepository.getLastStudentId();
	}

	public void doUpdateStudent(StudentEntity requestData, Long studentId) {
		// TODO Auto-generated method stub
		Optional<StudentEntity> dataToUpdate = studentRepository.findById(studentId);
		StudentEntity data = dataToUpdate.get();
		data.setName(requestData.getName());
		studentRepository.save(data);
	}

	public Optional<StudentEntity> getStudentById(Long studentId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(studentId);
	}

	public List<StudentEntity> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

}
