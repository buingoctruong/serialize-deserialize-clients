package github.io.truongbn.jsonclients.data.gen;

public interface DataGenerator<T> {
    int populate(T obj, int size);
}
