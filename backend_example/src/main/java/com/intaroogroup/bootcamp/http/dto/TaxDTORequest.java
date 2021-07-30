/**
 * 
 */
package com.intaroogroup.bootcamp.http.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author anitamarsafira
 *
 */
@Data
public class TaxDTORequest {
	@JsonProperty("ptkpStatus")
	private String ptkpStatus;
}
