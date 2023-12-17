package github.io.truongbn.jsonclients.stream;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

import github.io.truongbn.jsonclients.model.Users;
import github.io.truongbn.jsonclients.model.Users.Friend;
import github.io.truongbn.jsonclients.model.Users.User;

public class UsersStreamSerializer implements StreamSerializer<Users> {
    @Override
    public void jackson(JsonGenerator j, Users obj) throws IOException {
        j.writeStartObject();
        if (obj.getUsers() != null) {
            j.writeFieldName("users");
            j.writeStartArray();
            for (User u : obj.getUsers()) {
                jackson(j, u);
            }
            j.writeEndArray();
        }
        j.writeEndObject();
    }

    private void jackson(JsonGenerator j, User u) throws IOException {
        j.writeStartObject();
        if (u.getId() != null) {
            j.writeFieldName("id");
            j.writeString(u.getId());
        }
        j.writeFieldName("index");
        j.writeNumber(u.getIndex());
        if (u.getGuid() != null) {
            j.writeFieldName("guid");
            j.writeString(u.getGuid());
        }
        j.writeFieldName("isActive");
        j.writeBoolean(u.getIsActive());
        if (u.getBalance() != null) {
            j.writeFieldName("balance");
            j.writeString(u.getBalance());
        }
        if (u.getPicture() != null) {
            j.writeFieldName("picture");
            j.writeString(u.getPicture());
        }
        j.writeFieldName("age");
        j.writeNumber(u.getAge());
        if (u.getEyeColor() != null) {
            j.writeFieldName("eyeColor");
            j.writeString(u.getEyeColor());
        }
        if (u.getName() != null) {
            j.writeFieldName("name");
            j.writeString(u.getName());
        }
        if (u.getGender() != null) {
            j.writeFieldName("gender");
            j.writeString(u.getGender());
        }
        if (u.getCompany() != null) {
            j.writeFieldName("company");
            j.writeString(u.getCompany());
        }
        if (u.getEmail() != null) {
            j.writeFieldName("email");
            j.writeString(u.getEmail());
        }
        if (u.getPhone() != null) {
            j.writeFieldName("phone");
            j.writeString(u.getPhone());
        }
        if (u.getAddress() != null) {
            j.writeFieldName("address");
            j.writeString(u.getAddress());
        }
        if (u.getAbout() != null) {
            j.writeFieldName("about");
            j.writeString(u.getAbout());
        }
        if (u.getRegistered() != null) {
            j.writeFieldName("registered");
            j.writeString(u.getRegistered());
        }
        j.writeFieldName("latitude");
        j.writeNumber(u.getLatitude());
        j.writeFieldName("longitude");
        j.writeNumber(u.getLongitude());
        if (u.getTags() != null) {
            j.writeFieldName("tags");
            j.writeStartArray();
            for (String t : u.getTags()) {
                j.writeString(t);
            }
            j.writeEndArray();
        }
        if (u.getFriends() != null) {
            j.writeFieldName("friends");
            j.writeStartArray();
            for (Friend f : u.getFriends()) {
                j.writeStartObject();
                j.writeFieldName("id");
                j.writeString(f.getId());
                j.writeFieldName("name");
                j.writeString(f.getName());
                j.writeEndObject();
            }
            j.writeEndArray();
        }
        if (u.getGreeting() != null) {
            j.writeFieldName("greeting");
            j.writeString(u.getGreeting());
        }
        if (u.getFavoriteFruit() != null) {
            j.writeFieldName("favoriteFruit");
            j.writeString(u.getFavoriteFruit());
        }
        j.writeEndObject();
    }
}
