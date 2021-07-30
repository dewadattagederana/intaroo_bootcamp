/**
 * 
 */
package com.intaroogroup.bootcamp.http.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author anitamarsafira
 *
 */
@Entity
@Data
@Table(name = "employee")  
public class EmployeeEntity {
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "name",length = 255)
	private String name;
	@Column(name = "address",length = 255)
	private String address;
	@Column(name = "salary")
	private BigDecimal salary;
	
	
	
}
