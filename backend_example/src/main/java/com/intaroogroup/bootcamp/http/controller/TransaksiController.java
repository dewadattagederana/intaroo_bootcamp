/**
 * 
 */
package com.intaroogroup.bootcamp.http.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intaroogroup.bootcamp.http.entity.TransaksiEntity;
import com.intaroogroup.bootcamp.http.service.TransaksiService;
import com.intaroogroup.bootcamp.http.utils.GlobalExceptionHandler;
import com.intaroogroup.bootcamp.http.utils.Response;
import com.intaroogroup.bootcamp.http.utils.RestApiUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anitamarsafira
 *
 */
@Slf4j
@RestController
@RequestMapping("/transaksi")
public class TransaksiController {
	@Value("${spring.application.name}")
    String applicationName;
	 
	@Autowired 
    TransaksiService transaksiService;
	
    @Autowired
    RestApiUtil restApiUtil;
	@PostMapping("/")
    public Response<Object> createTransaksi(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws Exception {
        try {
           TransaksiEntity requestData = restApiUtil.requestToObject(httpRequest, TransaksiEntity.class);
            transaksiService.doCreateTransaksi(requestData);
            Long transaksiId = transaksiService.getLastTransaksiId();
            
            String responseData = "Transaksi has been created with transaksi_id"+transaksiId; 
            return Response.status(httpServletResponse, HttpStatus.OK, responseData);
        }catch (Exception e){
        	log.error("Error Process Create Transaksi : " + e,e );
            return GlobalExceptionHandler.ChekingExceptionGlobal(applicationName, httpServletResponse, e);
        }
    }
}

