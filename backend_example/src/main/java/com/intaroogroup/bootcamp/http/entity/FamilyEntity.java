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
@Table(name = "family")  
public class FamilyEntity {
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "name",length = 255)
	private String name;
	@Column(name = "address",length = 255)
	private String address;
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "FamilyEntity [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
