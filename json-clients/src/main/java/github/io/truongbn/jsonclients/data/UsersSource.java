package github.io.truongbn.jsonclients.data;

import github.io.truongbn.jsonclients.data.gen.UsersGenerator;
import github.io.truongbn.jsonclients.model.Users;
import github.io.truongbn.jsonclients.provider.UsersJsonProvider;
import github.io.truongbn.jsonclients.stream.UsersStreamDeserializer;
import github.io.truongbn.jsonclients.stream.UsersStreamSerializer;

public class UsersSource extends JsonSource<Users> {
    private static final UsersJsonProvider usersJsonProvider = new UsersJsonProvider();
    public UsersSource(int quantity, int individualSize) {
        super(quantity, individualSize, usersJsonProvider, new UsersGenerator(),
                new UsersStreamSerializer(), new UsersStreamDeserializer());
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
