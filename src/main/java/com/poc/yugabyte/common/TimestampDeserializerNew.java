package com.poc.yugabyte.common;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TimestampDeserializerNew extends JsonDeserializer<Timestamp> {
	private static final Logger log = LoggerFactory
			.getLogger(com.poc.yugabyte.common.TimestampDeserializerNew.class);

	private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");

	public Timestamp deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
		try {
			return new Timestamp(this.format.parse(jsonParser.getText()).getTime());
		} catch (Exception e) {
			log.error("Error while Getting value for {} value ::  {} {}",
					new Object[] { jsonParser.getCurrentName(), jsonParser.getText(), e.getMessage() });

			return null;
		}
	}
}
