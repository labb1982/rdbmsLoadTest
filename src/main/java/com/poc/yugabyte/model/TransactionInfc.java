package com.poc.yugabyte.model;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface TransactionInfc {

	String getInsertFragment();

	void populate(PreparedStatement ps, int rowNum) throws SQLException;

	String getPlaceHolders();
}
