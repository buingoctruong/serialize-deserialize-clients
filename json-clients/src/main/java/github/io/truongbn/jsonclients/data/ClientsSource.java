package github.io.truongbn.jsonclients.data;

import github.io.truongbn.jsonclients.data.gen.ClientsGenerator;
import github.io.truongbn.jsonclients.model.Clients;
import github.io.truongbn.jsonclients.provider.ClientsJsonProvider;

public class ClientsSource extends JsonSource<Clients> {
    private static final ClientsJsonProvider clientsJsonProvider = new ClientsJsonProvider();
    public ClientsSource(int quantity, int individualSize) {
        super(quantity, individualSize, clientsJsonProvider, new ClientsGenerator(), null, null);
    }

    @Override
    Clients[] newPojoArray(int quantity) {
        return new Clients[quantity];
    }

    @Override
    public Class<Clients> pojoType() {
        return Clients.class;
    }
}
