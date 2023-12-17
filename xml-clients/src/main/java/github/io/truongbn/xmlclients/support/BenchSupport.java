package github.io.truongbn.xmlclients.support;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum BenchSupport {
    USERS(
            new Libapi(Library.STREAM_XML, Api.DATABIND),
            new Libapi(Library.JACKSON_XML, Api.DATABIND),
            new Libapi(Library.CONTEXT, Api.DATABIND)
    ),
    CLIENTS(
            new Libapi(Library.STREAM_XML, Api.DATABIND),
            new Libapi(Library.JACKSON_XML, Api.DATABIND),
            new Libapi(Library.CONTEXT, Api.DATABIND)
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
