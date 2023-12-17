package github.io.truongbn.jsonclients.support;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum Library {
    JACKSON,
    JACKSON_AFTERBURNER,
    JACKSON_BLACKBIRD,
    FASTJSON,
    DSLJSON,
    DSLJSON_REFLECTION,
    AVAJEJSONB_JACKSON,
    AVAJEJSONB;
    public static Set<Library> fromCsv(String str) {
        if (str == null || str.trim().isEmpty()) {
            return Collections.emptySet();
        }
        Set<Library> libs = new HashSet<>();
        String[] vals = str.trim().toUpperCase().split(",");
        for (String v : vals) {
            libs.add(Library.valueOf(v));
        }
        return libs;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
