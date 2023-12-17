package github.io.truongbn.jsonclients.provider;

import java.util.Map;

import com.dslplatform.json.DslJson;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface JsonProvider<T> {
    ObjectMapper jackson();

    ObjectMapper jacksonAfterburner();

    ObjectMapper jacksonBlackbird();

    JsonFactory jacksonFactory();

    Map<String, Object> jsonioStreamOptions();

    DslJson<Object> dsljson();

    DslJson<Object> dsljson_reflection();

    io.avaje.jsonb.JsonType<T> avajeJsonb_jackson();

    io.avaje.jsonb.JsonType<T> avajeJsonb_default();
}
