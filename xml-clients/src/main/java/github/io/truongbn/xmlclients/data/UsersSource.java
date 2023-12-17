package github.io.truongbn.xmlclients.data;

import github.io.truongbn.xmlclients.data.gen.UsersGenerator;
import github.io.truongbn.xmlclients.model.Users;
import github.io.truongbn.xmlclients.provider.UsersXmlProvider;

import javax.xml.bind.JAXBException;

public class UsersSource extends XmlSource<Users> {
    private static final UsersXmlProvider usersXmlProvider;

    static {
        try {
            usersXmlProvider = new UsersXmlProvider();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    public UsersSource(int quantity, int individualSize) {
        super(quantity, individualSize, usersXmlProvider, new UsersGenerator());
    }

    @Override
    Users[] newPojoArray(int quantity) {
        return new Users[quantity];
    }

    @Override
    public Class<Users> pojoType() {
        return Users.class;
    }
}
