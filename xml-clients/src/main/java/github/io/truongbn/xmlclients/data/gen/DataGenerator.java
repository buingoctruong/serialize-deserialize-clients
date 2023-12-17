package github.io.truongbn.xmlclients.data.gen;

public interface DataGenerator<T> {
    int populate(T obj, int size);
}
