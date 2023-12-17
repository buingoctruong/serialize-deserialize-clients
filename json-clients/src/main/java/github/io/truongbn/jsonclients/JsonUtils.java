package github.io.truongbn.jsonclients;

import java.io.ByteArrayOutputStream;

public final class JsonUtils {
    private JsonUtils() {
    }

    public static ByteArrayOutputStream byteArrayOutputStream() {
        ByteArrayOutputStream baos = THREAD_BYTE_ARRAY_OUTPUT_STREAM.get();
        baos.reset();
        return baos;
    }
    private static final ThreadLocal<ByteArrayOutputStream> THREAD_BYTE_ARRAY_OUTPUT_STREAM = ThreadLocal
            .withInitial(ByteArrayOutputStream::new);
}
