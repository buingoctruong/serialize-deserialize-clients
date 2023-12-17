package github.io.truongbn.xmlclients.support;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum Api {
    DATABIND;

    public static Set<Api> fromCsv(String str) {
        if (str == null || str.trim().isEmpty()) {
            return Collections.emptySet();
        }
        Set<Api> libs = new HashSet<>();
        String[] vals = str.trim().toUpperCase().split(",");
        for (String v : vals) {
            libs.add(Api.valueOf(v));
        }
        return libs;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
