package github.io.truongbn.xmlclients.databind;

import github.io.truongbn.xmlclients.XmlBench;
import github.io.truongbn.xmlclients.XmlUtils;
import github.io.truongbn.xmlclients.data.XmlSource;
import org.openjdk.jmh.annotations.Benchmark;

import javax.xml.bind.Marshaller;
import java.io.ByteArrayOutputStream;

public class Serialization extends XmlBench {
    public XmlSource XML_SOURCE() {
        return CLI_XML_SOURCE;
    }

    @Benchmark
    @Override
    public Object stream_xml() throws Exception {
        return XML_SOURCE().provider().streamXml().toXML(XML_SOURCE().nextPojo());
    }

    @Benchmark
    @Override
    public Object jackson_xml() throws Exception {
        return XML_SOURCE().provider().jacksonXml().writeValueAsString(XML_SOURCE().nextPojo());
    }

    @Benchmark
    @Override
    public Object context() throws Exception {
        Marshaller mar = XML_SOURCE().provider().context().createMarshaller();
        ByteArrayOutputStream baos = XmlUtils.byteArrayOutputStream();
        mar.marshal(XML_SOURCE().nextPojo(), baos);
        return baos;
    }
}
