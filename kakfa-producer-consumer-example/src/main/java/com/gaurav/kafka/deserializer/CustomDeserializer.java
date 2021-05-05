package com.gaurav.kafka.deserializer;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaurav.kafka.pojo.Data;

public class CustomDeserializer implements Deserializer<Data> {
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public Data deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		Data object = null;
		try {
			object = mapper.readValue(data, Data.class);
		} catch (Exception exception) {
			System.out.println("Error in deserializing bytes " + exception);
		}
		return object;
	}

	@Override
	public void close() {
	}
}