package github.io.truongbn.jsonclients.stream;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;

public interface StreamDeserializer<T> {
    T jackson(JsonParser jParser) throws IOException;
}
