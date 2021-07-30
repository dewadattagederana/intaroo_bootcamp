/**
 * 
 */
package com.intaroogroup.bootcamp.http.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author anitamarsafira
 *
 */
@Data
public class TaxDTOResponse {
	@JsonProperty("status")
	private String status;
	@JsonProperty("nominal")
	private BigDecimal nominal;
}
