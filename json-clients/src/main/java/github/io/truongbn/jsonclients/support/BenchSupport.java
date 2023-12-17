package github.io.truongbn.jsonclients.support;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum BenchSupport {
    USERS(
            new Libapi(Library.JACKSON, Api.DATABIND, Api.STREAM),
            new Libapi(Library.JACKSON_AFTERBURNER, Api.DATABIND),
            new Libapi(Library.JACKSON_BLACKBIRD, Api.DATABIND),
            new Libapi(Library.FASTJSON, Api.DATABIND),
            new Libapi(Library.DSLJSON, Api.DATABIND),
            new Libapi(Library.DSLJSON_REFLECTION, Api.DATABIND),
            new Libapi(Library.AVAJEJSONB_JACKSON, Api.DATABIND),
            new Libapi(Library.AVAJEJSONB, Api.DATABIND)
    ),
    CLIENTS(
            new Libapi(Library.JACKSON, Api.DATABIND),
            new Libapi(Library.JACKSON_AFTERBURNER, Api.DATABIND),
            new Libapi(Library.JACKSON_BLACKBIRD, Api.DATABIND),
            new Libapi(Library.FASTJSON, Api.DATABIND),
            new Libapi(Library.DSLJSON, Api.DATABIND),
            new Libapi(Library.DSLJSON_REFLECTION, Api.DATABIND),
            new Libapi(Library.AVAJEJSONB_JACKSON, Api.DATABIND),
            new Libapi(Library.AVAJEJSONB, Api.DATABIND)
    );

    private final List<Libapi> libapis;

    BenchSupport(Libapi... libapis) {
        this.libapis = Arrays.asList(libapis);
    }

    public List<Libapi> libapis() {
        return libapis;
    }

    public Set<Library> supportedLibs() {
        return libapis.stream()
                .filter(Libapi::active)
                .map(Libapi::lib)
                .collect(Collectors.toSet());
    }
}
