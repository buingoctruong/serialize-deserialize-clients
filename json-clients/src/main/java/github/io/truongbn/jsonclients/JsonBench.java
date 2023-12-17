package github.io.truongbn.jsonclients;

import github.io.truongbn.jsonclients.data.JsonSource;
import github.io.truongbn.jsonclients.data.JsonSourceFactory;

public abstract class JsonBench {
    protected static final JsonSource CLI_JSON_SOURCE = JsonSourceFactory.create();
    public abstract JsonSource JSON_SOURCE();

    public Object jackson() throws Exception {
        return null;
    }

    public Object jackson_afterburner() throws Exception {
        return null;
    }

    public Object jackson_blackbird() throws Exception {
        return null;
    }

    public Object fastjson() throws Exception {
        return null;
    }

    public Object dsljson() throws Exception {
        return null;
    }

    public Object dsljson_reflection() throws Exception {
        return null;
    }

    public Object avajejsonb_jackson() throws Exception {
        return null;
    }

    public Object avajejsonb() throws Exception {
        return null;
    }
}
