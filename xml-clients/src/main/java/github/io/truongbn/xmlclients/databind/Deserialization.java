package github.io.truongbn.xmlclients.databind;

import github.io.truongbn.xmlclients.XmlBench;
import github.io.truongbn.xmlclients.data.XmlSource;
import org.openjdk.jmh.annotations.Benchmark;

import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Deserialization extends XmlBench {
    public XmlSource XML_SOURCE() {
        return CLI_XML_SOURCE;
    }

    @Benchmark
    @Override
    public Object stream_xml() throws Exception {
        return XML_SOURCE().provider().streamXml().fromXML(XML_SOURCE().nextString());
    }

    @Benchmark
    @Override
    public Object jackson_xml() throws IOException {
        return XML_SOURCE().provider().jacksonXml().readValue(XML_SOURCE().nextString(), XML_SOURCE().pojoType());
    }

    @Benchmark
    @Override
    public Object context() throws Exception {
        InputStream targetStream = new ByteArrayInputStream(XML_SOURCE().nextString().getBytes());
        Unmarshaller mar = XML_SOURCE().provider().context().createUnmarshaller();
        return mar.unmarshal(targetStream);
    }
}
