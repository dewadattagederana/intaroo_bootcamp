/**
 * 
 */
package com.intaroogroup.bootcamp.http.dto;

import lombok.Data;

/**
 * @author anitamarsafira
 *
 */
@Data
public class EmployeeDTORequest {
	private Long id; 
	private String name; 
	private String address; 
	private int salary;
}
