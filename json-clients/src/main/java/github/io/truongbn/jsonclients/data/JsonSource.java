package github.io.truongbn.jsonclients.data;

import java.io.ByteArrayInputStream;

import github.io.truongbn.jsonclients.RandomUtils;
import github.io.truongbn.jsonclients.data.gen.DataGenerator;
import github.io.truongbn.jsonclients.provider.JsonProvider;
import github.io.truongbn.jsonclients.stream.StreamDeserializer;
import github.io.truongbn.jsonclients.stream.StreamSerializer;

public abstract class JsonSource<T> {
    private final JsonProvider<T> provider;
    private final T[] jsonAsObject;
    private final String[] jsonAsString;
    private final byte[][] jsonAsBytes;
    private final ThreadLocal<ByteArrayInputStream[]> jsonAsByteArrayInputStream;
    private final DataGenerator<T> dataGenerator;
    private final StreamSerializer<T> streamSerializer;
    private final StreamDeserializer<T> streamDeserializer;
    JsonSource(int quantity, int individualSize, JsonProvider provider,
            DataGenerator<T> dataGenerator, StreamSerializer<T> streamSerializer,
            StreamDeserializer<T> streamDeserializer) {
        this.provider = provider;
        this.jsonAsObject = newPojoArray(quantity);
        this.jsonAsString = new String[quantity];
        this.jsonAsBytes = new byte[quantity][];
        this.dataGenerator = dataGenerator;
        this.streamSerializer = streamSerializer;
        this.streamDeserializer = streamDeserializer;
        populateFields(quantity, individualSize);
        this.jsonAsByteArrayInputStream = ThreadLocal.withInitial(() -> {
            ByteArrayInputStream[] arr = new ByteArrayInputStream[quantity];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new ByteArrayInputStream(jsonAsBytes[i]);
            }
            return arr;
        });
    }

    private void populateFields(int quantity, int individualSize) {
        try {
            for (int i = 0; i < quantity; i++) {
                T obj = pojoType().newInstance();
                dataGenerator.populate(obj, individualSize);
                jsonAsObject[i] = obj;
                String json = provider.jackson().writeValueAsString(obj);
                jsonAsString[i] = json;
                jsonAsBytes[i] = json.getBytes();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public JsonProvider<T> provider() {
        return provider;
    }

    public byte[] nextByteArray() {
        return jsonAsBytes[index(jsonAsBytes.length)];
    }

    public T nextPojo() {
        return jsonAsObject[index(jsonAsObject.length)];
    }

    public StreamSerializer<T> streamSerializer() {
        return streamSerializer;
    }

    public StreamDeserializer<T> streamDeserializer() {
        return streamDeserializer;
    }

    abstract T[] newPojoArray(int quantity);

    public abstract Class<T> pojoType();

    private int index(int bound) {
        return bound == 1 ? 0 : RandomUtils.nextInt(bound);
    }
}
