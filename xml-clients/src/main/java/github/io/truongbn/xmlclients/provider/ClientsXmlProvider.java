package github.io.truongbn.xmlclients.provider;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.thoughtworks.xstream.XStream;
import github.io.truongbn.xmlclients.model.Clients;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

public class ClientsXmlProvider implements XmlProvider<Clients> {
    private final JAXBContext context = JAXBContext.newInstance(Clients.class);
    private final XStream streamXml = new XStream();
    private final XmlMapper jacksonXml = (XmlMapper) new XmlMapper().registerModule(new JavaTimeModule());

    public ClientsXmlProvider() throws JAXBException {
    }

    @Override
    public XStream streamXml() {
        streamXml.allowTypesByWildcard(new String[]{"github.io.truongbn.xmlclients.model.**", "java.lang.**"});
        return streamXml;
    }

    @Override
    public XmlMapper jacksonXml() {
        return jacksonXml;
    }

    @Override
    public JAXBContext context() {
        return context;
    }
}
