package com.dailycodework.dreamshops.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;

public class BlobSerializer extends JsonSerializer<Blob> {
    @Override
    public void serialize(Blob blob, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        try {
            jsonGenerator.writeString(Base64.getEncoder().encodeToString(blob.getBytes(1, (int) blob.length())));
        } catch (SQLException e) {
            throw new IOException(e);
        }
    }
}
