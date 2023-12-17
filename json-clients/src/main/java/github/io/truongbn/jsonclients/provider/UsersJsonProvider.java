package github.io.truongbn.jsonclients.provider;

import java.util.HashMap;
import java.util.Map;

import com.dslplatform.json.DslJson;
import com.dslplatform.json.runtime.Settings;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.afterburner.AfterburnerModule;
import com.fasterxml.jackson.module.blackbird.BlackbirdModule;

import github.io.truongbn.jsonclients.model.Users;
import io.avaje.jsonb.JsonType;
import io.avaje.jsonb.jackson.JacksonAdapter;
import io.avaje.jsonb.stream.JsonStream;

public class UsersJsonProvider implements JsonProvider<Users> {
    private final ObjectMapper jackson = new ObjectMapper();
    private final ObjectMapper jacksonAfterburner = new ObjectMapper()
            .registerModule(new AfterburnerModule());
    private final ObjectMapper jacksonBlackbird = new ObjectMapper()
            .registerModule(new BlackbirdModule());
    private final JsonFactory jacksonFactory = new JsonFactory();
    private final DslJson<Object> dsljson = new DslJson<>(
            Settings.withRuntime().includeServiceLoader());
    private final DslJson<Object> dsljson_reflection = new DslJson<>(Settings.withRuntime());
    private final Map<String, Object> jsonioStreamOptions = new HashMap<>();
    private final JsonType<Users> avajeJsonb_jackson = io.avaje.jsonb.Jsonb.newBuilder()
            .adapter(new JacksonAdapter(true, true, false)).build().type(Users.class);
    private final JsonType<Users> avajeJsonb_default = io.avaje.jsonb.Jsonb.newBuilder()
            .adapter(new JsonStream(true, true, false)).build().type(Users.class);
    public UsersJsonProvider() {
    }

    @Override
    public ObjectMapper jackson() {
        return jackson;
    }

    @Override
    public ObjectMapper jacksonAfterburner() {
        return jacksonAfterburner;
    }

    @Override
    public ObjectMapper jacksonBlackbird() {
        return jacksonBlackbird;
    }

    @Override
    public JsonFactory jacksonFactory() {
        return jacksonFactory;
    }

    @Override
    public Map<String, Object> jsonioStreamOptions() {
        return jsonioStreamOptions;
    }

    @Override
    public DslJson<Object> dsljson() {
        return dsljson;
    }

    @Override
    public DslJson<Object> dsljson_reflection() {
        return dsljson_reflection;
    }

    @Override
    public JsonType<Users> avajeJsonb_jackson() {
        return avajeJsonb_jackson;
    }

    @Override
    public JsonType<Users> avajeJsonb_default() {
        return avajeJsonb_default;
    }
}
