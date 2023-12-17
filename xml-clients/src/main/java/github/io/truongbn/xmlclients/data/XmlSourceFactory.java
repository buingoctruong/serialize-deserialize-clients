package github.io.truongbn.xmlclients.data;

import github.io.truongbn.xmlclients.Cli;
import github.io.truongbn.xmlclients.Config;
import github.io.truongbn.xmlclients.support.BenchSupport;

public final class XmlSourceFactory {
    private XmlSourceFactory() {
    }

    public static XmlSource<?> create() {
        Cli.AbstractCommand cmd = Config.load();
        return create(cmd.dataType, cmd.numberOfPayloads, cmd.sizeOfEachPayloadInKb * 1000);
    }

    public static XmlSource<?> create(String dataType, int quantity, int size) {
        BenchSupport bs = BenchSupport.valueOf(dataType.toUpperCase());
        switch (bs) {
            case USERS:
                return new UsersSource(quantity, size);
            case CLIENTS:
                return new ClientsSource(quantity, size);
            default:
                throw new RuntimeException();
        }
    }
}
