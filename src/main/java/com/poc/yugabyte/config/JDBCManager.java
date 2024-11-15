package com.poc.yugabyte.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
import org.springframework.stereotype.Service;

import com.poc.yugabyte.model.TransactionInfc;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JDBCManager {
	private static final String OR_OPERATOR = "\n or ";

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Value("${chunkSize:50}")
	private int batchSize;

//	private static class IntHolder {
//		int counter;
//
//		public IntHolder(int counter) {
//			this.counter = counter;
//		}
//
//	}
//
//	public void insetBatchToYuga(List<TransactionInfc> data) {
//		if (org.springframework.util.CollectionUtils.isEmpty(data)) {
//			return;
//		}
//		log.info("Called");
//		IntHolder intHolder = new IntHolder(1);
//		ParameterizedPreparedStatementSetter<TransactionInfc> pss = (ps, t) -> {
//			t.populate(ps, /*intHolder.counter++*/0);
//			ps.addBatch();
//		};
//
//		final TransactionInfc transactionInfc = data.get(0);
//		final int size = data.size();
//		final String query;
//		if (size == 1) {
//			query = transactionInfc.getInsertFragment() + transactionInfc.getPlaceHolders();
//		} else {
//			StringBuilder sb = new StringBuilder();
//			sb.append(transactionInfc.getInsertFragment());
//
//			for (TransactionInfc curTransactionInfc : data) {
//				sb.append(curTransactionInfc.getPlaceHolders()).append(',');
//			}
//
//			query = sb.toString().substring(0, sb.length() - ",".length());
//		}
//
//		jdbcTemplate.batchUpdate(query, data, size, pss);
//
//	}

	@Autowired
	private DataSource dataSource;

	public void generateBatch(List<TransactionInfc> data) {
		if (org.springframework.util.CollectionUtils.isEmpty(data)) {
			return;
		}
		log.info("Called");
		final TransactionInfc transactionInfc = data.get(0);
		final int size = data.size();
		final String query;
//		if (size == 1) {
//			query = transactionInfc.getInsertFragment() + transactionInfc.getPlaceHolders();
//		} else {
//			StringBuilder sb = new StringBuilder();
//			sb.append(transactionInfc.getInsertFragment());
//
//			for (TransactionInfc curTransactionInfc : data) {
//				sb.append(curTransactionInfc.getPlaceHolders()).append(',');
//			}
//
//			query = sb.toString().substring(0, sb.length() - ",".length());
//		}
		query = transactionInfc.getInsertFragment() + transactionInfc.getPlaceHolders();
		try (Connection connection = dataSource.getConnection()) {
			boolean autoCommit = connection.getAutoCommit();
			connection.setAutoCommit(false);
			handlePreparedStatement(query, connection, data);
			connection.setAutoCommit(autoCommit);
		} catch (SQLException e) {
			log.error("", e);
		}

	}

	private void handlePreparedStatement(final String query, Connection connection, List<TransactionInfc> data)
			throws SQLException {
		try (PreparedStatement prepareStatement = connection.prepareStatement(query)) {
			int rowNum = 1;
			for (TransactionInfc curTransactionInfc : data) {
				curTransactionInfc.populate(prepareStatement, /*rowNum++*/0);
				prepareStatement.addBatch();
				if (rowNum % batchSize == 0 || rowNum == data.size()) {
					prepareStatement.executeBatch();
				}
			}
			prepareStatement.executeBatch();
			connection.commit();
		} catch (SQLException e) {
			log.error("", e);
			connection.rollback();
		}
	}

}
