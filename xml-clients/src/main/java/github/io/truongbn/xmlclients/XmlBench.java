package github.io.truongbn.xmlclients;

import github.io.truongbn.xmlclients.data.XmlSource;
import github.io.truongbn.xmlclients.data.XmlSourceFactory;

public abstract class XmlBench {
    protected static final XmlSource CLI_XML_SOURCE = XmlSourceFactory.create();

    public abstract XmlSource XML_SOURCE();

    public Object stream_xml() throws Exception {
        return null;
    }

    public Object jackson_xml() throws Exception {
        return null;
    }

    public Object context() throws Exception {
        return null;
    }
}
