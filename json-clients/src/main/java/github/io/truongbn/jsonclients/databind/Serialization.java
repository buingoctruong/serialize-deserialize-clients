package github.io.truongbn.jsonclients.databind;

import java.io.ByteArrayOutputStream;

import org.openjdk.jmh.annotations.Benchmark;

import com.alibaba.fastjson.JSON;

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
        JSON_SOURCE().provider().jackson().writeValue(baos, JSON_SOURCE().nextPojo());
        return baos;
    }

    @Benchmark
    @Override
    public Object jackson_afterburner() throws Exception {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON_SOURCE().provider().jacksonAfterburner().writeValue(baos, JSON_SOURCE().nextPojo());
        return baos;
    }

    @Benchmark
    @Override
    public Object jackson_blackbird() throws Exception {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON_SOURCE().provider().jacksonBlackbird().writeValue(baos, JSON_SOURCE().nextPojo());
        return baos;
    }

    @Benchmark
    @Override
    public Object fastjson() throws Exception {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON.writeJSONString(baos, JSON_SOURCE().nextPojo());
        return baos;
    }

    @Benchmark
    @Override
    public Object dsljson() throws Exception {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON_SOURCE().provider().dsljson().serialize(JSON_SOURCE().nextPojo(), baos);
        return baos;
    }

    @Benchmark
    @Override
    public Object dsljson_reflection() throws Exception {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON_SOURCE().provider().dsljson_reflection().serialize(JSON_SOURCE().nextPojo(), baos);
        return baos;
    }

    @Benchmark
    @Override
    public Object avajejsonb_jackson() {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON_SOURCE().provider().avajeJsonb_jackson().toJson(JSON_SOURCE().nextPojo(), baos);
        return baos;
    }

    @Benchmark
    @Override
    public Object avajejsonb() {
        ByteArrayOutputStream baos = JsonUtils.byteArrayOutputStream();
        JSON_SOURCE().provider().avajeJsonb_default().toJson(JSON_SOURCE().nextPojo(), baos);
        return baos;
    }
}
