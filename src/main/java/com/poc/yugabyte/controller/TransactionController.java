/**
 * 
 */
package com.poc.yugabyte.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.poc.yugabyte.config.JDBCManager;
import com.poc.yugabyte.model.TransactionInfc;

/**
 * 
 */
@RestController
public class TransactionController {
	
	@Autowired
	private JDBCManager yuga;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@PostMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public boolean insertValue(@RequestBody List<String> data) {
		int a = 10;
		List<TransactionInfc> dataList = new ArrayList<>();
		data.forEach(val -> {
			try {
				
				TransactionInfc transaction = (TransactionInfc) this.objectMapper.readValue(val,
						Class.forName("com.poc.yugabyte.model.Upi"));
				dataList.add(transaction);
			} catch (Exception ex) {
				//log.error("Error while parsing and converting data {} :: Error :: {} ", val, ex);
			}
		});
		
		//yuga.insetBatchToYuga(dataList);
		yuga.generateBatch(dataList);
		
		return false;
		
	}

}
