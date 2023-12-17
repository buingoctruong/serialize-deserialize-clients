package github.io.truongbn.jsonclients.data;

import github.io.truongbn.jsonclients.Cli;
import github.io.truongbn.jsonclients.Config;
import github.io.truongbn.jsonclients.support.BenchSupport;

public final class JsonSourceFactory {
    private JsonSourceFactory() {
    }

    public static JsonSource<?> create() {
        Cli.AbstractCommand cmd = Config.load();
        return create(cmd.dataType, cmd.numberOfPayloads, cmd.sizeOfEachPayloadInKb * 1000);
    }

    public static JsonSource<?> create(String dataType, int quantity, int size) {
        BenchSupport bs = BenchSupport.valueOf(dataType.toUpperCase());
        switch (bs) {
            case USERS :
                return new UsersSource(quantity, size);
            case CLIENTS :
                return new ClientsSource(quantity, size);
            default :
                throw new RuntimeException();
        }
    }
}
