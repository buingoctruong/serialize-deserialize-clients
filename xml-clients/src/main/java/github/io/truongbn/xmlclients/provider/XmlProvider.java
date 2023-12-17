package github.io.truongbn.xmlclients.provider;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.thoughtworks.xstream.XStream;

import javax.xml.bind.JAXBContext;

public interface XmlProvider<T> {
    XStream streamXml();

    XmlMapper jacksonXml();

    JAXBContext context();
}
