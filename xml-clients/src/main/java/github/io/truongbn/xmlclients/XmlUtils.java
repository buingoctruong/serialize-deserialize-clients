package github.io.truongbn.xmlclients;

import java.io.ByteArrayOutputStream;

public final class XmlUtils {
    private XmlUtils() {
    }

    public static ByteArrayOutputStream byteArrayOutputStream() {
        ByteArrayOutputStream baos = THREAD_BYTE_ARRAY_OUTPUT_STREAM.get();
        baos.reset();
        return baos;
    }

    private static final ThreadLocal<ByteArrayOutputStream> THREAD_BYTE_ARRAY_OUTPUT_STREAM = ThreadLocal
            .withInitial(ByteArrayOutputStream::new);
}
