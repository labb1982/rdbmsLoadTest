package com.poc.yugabyte;

import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.poc.yugabyte.config.IDatabaseManager;

@SpringBootApplication
public class YugabyteApplication {
	
//	@Autowired
//	private IDatabaseManager dbconn;

	public static void main(String[] args) {
		ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(YugabyteApplication.class, args);
		
//		IDatabaseManager dbconn = configurableApplicationContext.getBean(IDatabaseManager.class);
//		
//		var conn = dbconn.connect();
//		try {
//			Statement stmt = conn.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	
		
	}

}
