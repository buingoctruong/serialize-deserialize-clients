package github.io.truongbn.jsonclients.databind;

import java.io.IOException;

import org.openjdk.jmh.annotations.Benchmark;

import com.alibaba.fastjson.JSON;

import github.io.truongbn.jsonclients.JsonBench;
import github.io.truongbn.jsonclients.data.JsonSource;

public class Deserialization extends JsonBench {
    public JsonSource JSON_SOURCE() {
        return CLI_JSON_SOURCE;
    }

    @Benchmark
    @Override
    public Object jackson() throws Exception {
        return JSON_SOURCE().provider().jackson().readValue(JSON_SOURCE().nextByteArray(),
                JSON_SOURCE().pojoType());
    }

    @Benchmark
    @Override
    public Object jackson_afterburner() throws IOException {
        return JSON_SOURCE().provider().jacksonAfterburner()
                .readValue(JSON_SOURCE().nextByteArray(), JSON_SOURCE().pojoType());
    }

    @Benchmark
    @Override
    public Object jackson_blackbird() throws IOException {
        return JSON_SOURCE().provider().jacksonBlackbird().readValue(JSON_SOURCE().nextByteArray(),
                JSON_SOURCE().pojoType());
    }

    @Benchmark
    @Override
    public Object fastjson() {
        return JSON.parseObject(JSON_SOURCE().nextByteArray(), JSON_SOURCE().pojoType());
    }

    @Benchmark
    @Override
    public Object dsljson() throws Exception {
        byte[] buffer = JSON_SOURCE().nextByteArray();
        return JSON_SOURCE().provider().dsljson().deserialize(JSON_SOURCE().pojoType(), buffer,
                buffer.length);
    }

    @Benchmark
    @Override
    public Object dsljson_reflection() throws Exception {
        byte[] buffer = JSON_SOURCE().nextByteArray();
        return JSON_SOURCE().provider().dsljson_reflection().deserialize(JSON_SOURCE().pojoType(),
                buffer, buffer.length);
    }

    @Benchmark
    @Override
    public Object avajejsonb_jackson() throws Exception {
        byte[] buffer = JSON_SOURCE().nextByteArray();
        return JSON_SOURCE().provider().avajeJsonb_jackson().fromJson(buffer);
    }

    @Benchmark
    @Override
    public Object avajejsonb() throws Exception {
        byte[] buffer = JSON_SOURCE().nextByteArray();
        return JSON_SOURCE().provider().avajeJsonb_default().fromJson(buffer);
    }
}
