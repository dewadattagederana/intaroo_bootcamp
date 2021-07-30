/**
 * 
 */
package com.intaroogroup.bootcamp.http.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author anitamarsafira
 *
 */
@Entity
@Table(name = "student")  
public class StudentEntity {
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "name",length = 255)
	private String name;
	
	
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
