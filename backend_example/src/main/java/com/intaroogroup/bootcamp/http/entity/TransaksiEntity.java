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
@Table(name = "transaksi") 
@Data
public class TransaksiEntity {
	
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "name",length = 255)
	private String name;
	@Column(name="total")
	private BigDecimal total;
	
	
	
	 
}
