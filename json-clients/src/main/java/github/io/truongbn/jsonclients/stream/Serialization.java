package github.io.truongbn.jsonclients.stream;

import java.io.ByteArrayOutputStream;

import org.openjdk.jmh.annotations.Benchmark;

import com.fasterxml.jackson.core.JsonGenerator;

import github.io.truongbn.jsonclients.JsonBench;
import github.io.truongbn.jsonclients.JsonUtils;
import github.io.truongbn.jsonclients.data.JsonSource;

public class Serialization extends JsonBench {
    public JsonSource JSON_SOURCE() {
        return CLI_JSON_SOURCE;
    }

    @Benchmark
    @Override
    public Object jackson() throws Exception {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        try (JsonGenerator jGenerator = JSON_SOURCE().provider().jacksonFactory()
                .createGenerator(baos)) {
            JSON_SOURCE().streamSerializer().jackson(jGenerator, JSON_SOURCE().nextPojo());
        }
        return baos;
    }

    @Benchmark
    @Override
    public Object avajejsonb_jackson() throws Exception {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON_SOURCE().provider().avajeJsonb_jackson().toJson(JSON_SOURCE().nextPojo(), baos);
        return baos;
    }

    @Benchmark
    @Override
    public Object avajejsonb() throws Exception {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON_SOURCE().provider().avajeJsonb_default().toJson(JSON_SOURCE().nextPojo(), baos);
        return baos;
    }
}
