package com.poc.yugabyte.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DatabaseManager implements IDatabaseManager{

	@Value("jdbc:yugabytedb://")
	private String dbBaseUrl;

	@Value("${database.hostname}")
	private String hostname;

	@Value("${database.port}")
	private String port;

	@Value("${database.name}")
	private String name;

	@Value("${database.user}")
	private String user;

	@Value("${database.password}")
	private String password;

	@Value("${database.is_loadbalance_required}")
	private boolean isLoadBalanceRequired;

	@Value("${database.loadbalance_server_refresh_interval_in_sec}")
	private String serverRefreshInterval;

	@Value("${database.topology_keys}")
	private String topologyKeys;

	@Value("${database.is_ssl_exit}")
	private boolean isSslExist;

//	sslmode		|	Eavesdropping protection	|	MITM (= man in the middle) protection
//	*************************************************************************************
//	prefer		|	Maybe						|	No
//	require		|	Yes							|	No
//	verify-ca	|	Yes							|	Depends on CA policy
//	verify-full	|	Yes							|	Yes

	@Value("${database.ssl_mode}")
	private String sslMode;

	@Value("${database.ssl_cert_path}")
	private String sslCertificatePath;
	
	private String dbConnectionString;
	
	
//	public DatabaseManager() {
//		dbConnectionString = init();
//	}
	
	public String init() {

		// Connection String Builder
		var connStringBuilder = new StringBuilder();
		
		if (!this.dbBaseUrl.isBlank()) {
			connStringBuilder.append(this.dbBaseUrl);
		} else {
			//throw new Exception("");
		}
		connStringBuilder.append(this.hostname);
		connStringBuilder.append(":");
		connStringBuilder.append(this.port);
		connStringBuilder.append("/");
		connStringBuilder.append(this.name);
		connStringBuilder.append("?");
		connStringBuilder.append("user="+this.user+"&");
		connStringBuilder.append("password="+this.password+"&");
		if(this.isLoadBalanceRequired) {
			connStringBuilder.append("load-balance="+this.isLoadBalanceRequired+"&");
			connStringBuilder.append("yb-servers-refresh-interval="+this.serverRefreshInterval+"&");
			connStringBuilder.append("topology-keys="+this.topologyKeys+"&");			
		}
		
		if(this.isSslExist) {
			connStringBuilder.append("ssl="+this.isSslExist+"&");
			connStringBuilder.append("sslmode="+this.sslMode+"&");
			connStringBuilder.append("sslrootcert="+this.sslCertificatePath+"&");
		}
		
//		if(connStringBuilder.lastIndexOf("&"))
		
		return connStringBuilder.toString();
	}
	
	@Bean
	@Primary
	@Override
	public Connection connect() {
		Connection conn = null;
		dbConnectionString = init();
		try {
			conn = DriverManager.getConnection(dbConnectionString);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return conn;
	}
	
}
