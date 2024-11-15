package com.poc.yugabyte.config;

import java.sql.Connection;

public interface IDatabaseManager {
	Connection connect();
}
