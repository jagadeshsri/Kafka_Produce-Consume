package com.gaurav.kafka.serializer;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.gaurav.kafka.pojo.Data;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomSerializer implements Serializer<Data> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {

	}

	@Override
	public byte[] serialize(String s, Data data) {
		ObjectMapper mapper = new ObjectMapper();
		if (data == null) {
			return null;
		}
		try {
			return mapper.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			throw new SerializationException("Error serializing JSON message", e);
		}
	}

	@Override
	public void close() {

	}

}