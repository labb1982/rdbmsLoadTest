package com.poc.yugabyte.common;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class StringToBoolCodeDeserializer extends JsonDeserializer<Boolean> {
	private static final Logger log = LoggerFactory
			.getLogger(com.poc.yugabyte.common.StringToBoolCodeDeserializer.class);

	public Boolean deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException {
		try {
			return Boolean.valueOf("Y".equalsIgnoreCase(jsonParser.getText()));
		} catch (Exception e) {
			log.error("Error while Getting value {}", jsonParser.getText());

			return Boolean.FALSE;
		}
	}
}
