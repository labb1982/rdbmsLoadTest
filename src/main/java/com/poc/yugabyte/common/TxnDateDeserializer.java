package com.poc.yugabyte.common;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TxnDateDeserializer extends JsonDeserializer<Date> {
	private static final Logger log = LoggerFactory
			.getLogger(com.poc.yugabyte.common.TxnDateDeserializer.class);

	private final SimpleDateFormat format = new SimpleDateFormat("yyyy:MM:dd");

	public Date deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
		try {
			return new Date(this.format.parse(jsonParser.getText()).getTime());
		} catch (Exception e) {
			log.error("Error while Getting value for {} value ::  {} {}",
					new Object[] { jsonParser.getCurrentName(), jsonParser.getText(), e.getMessage() });

			return null;
		}
	}
}
