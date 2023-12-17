package github.io.truongbn.xmlclients.data;

import github.io.truongbn.xmlclients.data.gen.ClientsGenerator;
import github.io.truongbn.xmlclients.model.Clients;
import github.io.truongbn.xmlclients.provider.ClientsXmlProvider;

import javax.xml.bind.JAXBException;

public class ClientsSource extends XmlSource<Clients> {
    private static final ClientsXmlProvider clientsXmlProvider;

    static {
        try {
            clientsXmlProvider = new ClientsXmlProvider();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public ClientsSource(int quantity, int individualSize) {
        super(quantity, individualSize, clientsXmlProvider, new ClientsGenerator());
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
