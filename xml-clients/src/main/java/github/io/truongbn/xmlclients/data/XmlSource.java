package github.io.truongbn.xmlclients.data;

import github.io.truongbn.xmlclients.RandomUtils;
import github.io.truongbn.xmlclients.data.gen.DataGenerator;
import github.io.truongbn.xmlclients.provider.XmlProvider;

public abstract class XmlSource<T> {
    private final XmlProvider<T> provider;
    private final T[] xmlAsObject;
    private final String[] xmlAsString;
    private final byte[][] xmlAsBytes;
    private final DataGenerator<T> dataGenerator;

    XmlSource(int quantity, int individualSize, XmlProvider provider,
              DataGenerator<T> dataGenerator) {
        this.provider = provider;
        this.xmlAsObject = newPojoArray(quantity);
        this.xmlAsString = new String[quantity];
        this.xmlAsBytes = new byte[quantity][];
        this.dataGenerator = dataGenerator;
        populateFields(quantity, individualSize);
    }

    private void populateFields(int quantity, int individualSize) {
        try {
            for (int i = 0; i < quantity; i++) {
                T obj = pojoType().newInstance();
                dataGenerator.populate(obj, individualSize);
                xmlAsObject[i] = obj;
                String xml = provider.streamXml().toXML(obj);
                xmlAsString[i] = xml;
                xmlAsBytes[i] = xml.getBytes();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }

    public XmlProvider<T> provider() {
        return provider;
    }

    public String nextString() {
        return xmlAsString[index(xmlAsString.length)];
    }

    public byte[] nextByteArray() {
        return xmlAsBytes[index(xmlAsBytes.length)];
    }

    public T nextPojo() {
        return xmlAsObject[index(xmlAsObject.length)];
    }

    abstract T[] newPojoArray(int quantity);

    public abstract Class<T> pojoType();

    private int index(int bound) {
        return bound == 1 ? 0 : RandomUtils.nextInt(bound);
    }
}
