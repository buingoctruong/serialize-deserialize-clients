package github.io.truongbn.jsonclients.stream;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParser;

import github.io.truongbn.jsonclients.model.Users;
import github.io.truongbn.jsonclients.model.Users.Friend;
import github.io.truongbn.jsonclients.model.Users.User;

public class UsersStreamDeserializer implements StreamDeserializer<Users> {
    @Override
    public Users jackson(JsonParser jParser) throws IOException {
        Users uc = new Users();
        while (jParser.nextToken() != com.fasterxml.jackson.core.JsonToken.END_OBJECT) {
            String fieldname = jParser.getCurrentName();
            if ("users".equals(fieldname)) {
                if (jParser.nextToken() == com.fasterxml.jackson.core.JsonToken.START_ARRAY) {
                    uc.setUsers(new ArrayList<>());
                    while (jParser.nextToken() != com.fasterxml.jackson.core.JsonToken.END_ARRAY) {
                        uc.getUsers().add(jacksonUser(jParser));
                        if (jParser.isClosed()) {
                            throw new IOException("parser closed");
                        }
                    }
                }
            }
        }
        return uc;
    }

    private User jacksonUser(JsonParser jParser) throws IOException {
        User r = new User();
        while (jParser.nextToken() != com.fasterxml.jackson.core.JsonToken.END_OBJECT) {
            String fieldname = jParser.getCurrentName();
            if (fieldname == null) {
                break;
            }
            switch (fieldname) {
                case "id" :
                    jParser.nextToken();
                    r.setId(jParser.getValueAsString());
                    break;
                case "index" :
                    jParser.nextToken();
                    r.setIndex(jParser.getIntValue());
                    break;
                case "guid" :
                    jParser.nextToken();
                    r.setGuid(jParser.getValueAsString());
                    break;
                case "isActive" :
                    jParser.nextToken();
                    r.setIsActive(jParser.getBooleanValue());
                    break;
                case "balance" :
                    jParser.nextToken();
                    r.setBalance(jParser.getValueAsString());
                    break;
                case "picture" :
                    jParser.nextToken();
                    r.setPicture(jParser.getValueAsString());
                    break;
                case "age" :
                    jParser.nextToken();
                    r.setAge(jParser.getIntValue());
                    break;
                case "eyeColor" :
                    jParser.nextToken();
                    r.setEyeColor(jParser.getValueAsString());
                    break;
                case "name" :
                    jParser.nextToken();
                    r.setName(jParser.getValueAsString());
                    break;
                case "gender" :
                    jParser.nextToken();
                    r.setGender(jParser.getValueAsString());
                    break;
                case "company" :
                    jParser.nextToken();
                    r.setCompany(jParser.getValueAsString());
                    break;
                case "email" :
                    jParser.nextToken();
                    r.setEmail(jParser.getValueAsString());
                    break;
                case "phone" :
                    jParser.nextToken();
                    r.setPhone(jParser.getValueAsString());
                    break;
                case "address" :
                    jParser.nextToken();
                    r.setAddress(jParser.getValueAsString());
                    break;
                case "about" :
                    jParser.nextToken();
                    r.setAbout(jParser.getValueAsString());
                    break;
                case "registered" :
                    jParser.nextToken();
                    r.setRegistered(jParser.getValueAsString());
                    break;
                case "latitude" :
                    jParser.nextToken();
                    r.setLatitude(jParser.getDoubleValue());
                    break;
                case "longitude" :
                    jParser.nextToken();
                    r.setLongitude(jParser.getDoubleValue());
                    break;
                case "greeting" :
                    jParser.nextToken();
                    r.setGreeting(jParser.getValueAsString());
                    break;
                case "favoriteFruit" :
                    jParser.nextToken();
                    r.setFavoriteFruit(jParser.getValueAsString());
                    break;
                case "tags" :
                    r.setTags(new ArrayList<>());
                    jParser.nextToken();
                    while (jParser.nextToken() != com.fasterxml.jackson.core.JsonToken.END_ARRAY) {
                        r.getTags().add(jParser.getValueAsString());
                    }
                    break;
                case "friends" :
                    r.setFriends(new ArrayList<>());
                    jParser.nextToken(); // current token is "[", move next.
                    while (jParser.nextToken() != com.fasterxml.jackson.core.JsonToken.END_ARRAY) {
                        Friend f = new Friend();
                        while (jParser
                                .nextToken() != com.fasterxml.jackson.core.JsonToken.END_OBJECT) {
                            String fn = jParser.getCurrentName();
                            if (fn == null) {
                                continue;
                            }
                            switch (fn) {
                                case "id" :
                                    jParser.nextToken();
                                    f.setId(jParser.getValueAsString());
                                    break;
                                case "name" :
                                    jParser.nextToken();
                                    f.setName(jParser.getValueAsString());
                                    break;
                            }
                        }
                        r.getFriends().add(f);
                    }
                    break;
            }
        }
        return r;
    }
}
