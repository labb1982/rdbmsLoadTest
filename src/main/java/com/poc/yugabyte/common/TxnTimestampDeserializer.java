package com.poc.yugabyte.common;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class TxnTimestampDeserializer extends JsonDeserializer<Timestamp> {
	private static final Logger log = LoggerFactory.getLogger(TxnTimestampDeserializer.class);

	private final ThreadLocal<SimpleDateFormat> format = ThreadLocal
			.withInitial(() -> new SimpleDateFormat("yyyy:MM:dd HH:mm:ss"));

	public Timestamp deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
		final String text = jsonParser.getText();
		try {
			return new Timestamp(this.format.get().parse(text).getTime());
		} catch (Exception e) {
			log.error("Error while Getting value for {} value ::  {}, {}, {}", jsonParser.getCurrentName(), text,
					e.getMessage(), e);

			return null;
		}
	}
}
