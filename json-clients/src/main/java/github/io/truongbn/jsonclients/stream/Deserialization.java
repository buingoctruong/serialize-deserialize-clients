package github.io.truongbn.jsonclients.stream;

import java.io.IOException;

import org.openjdk.jmh.annotations.Benchmark;

import com.fasterxml.jackson.core.JsonParser;

import github.io.truongbn.jsonclients.JsonBench;
import github.io.truongbn.jsonclients.data.JsonSource;

public class Deserialization extends JsonBench {
    public JsonSource JSON_SOURCE() {
        return CLI_JSON_SOURCE;
    }

    @Benchmark
    @Override
    public Object jackson() throws IOException {
        try (JsonParser jParser = JSON_SOURCE().provider().jacksonFactory()
                .createParser(JSON_SOURCE().nextByteArray())) {
            return JSON_SOURCE().streamDeserializer().jackson(jParser);
        }
    }

    @Benchmark
    @Override
    public Object avajejsonb_jackson() throws IOException {
        return JSON_SOURCE().provider().avajeJsonb_jackson()
                .fromJson(JSON_SOURCE().nextByteArray());
    }

    @Benchmark
    @Override
    public Object avajejsonb() throws IOException {
        return JSON_SOURCE().provider().avajeJsonb_default()
                .fromJson(JSON_SOURCE().nextByteArray());
    }
}
