package github.io.truongbn.jsonclients.stream;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

public interface StreamSerializer<T> {
    void jackson(JsonGenerator j, T obj) throws IOException;
}
