package github.io.truongbn.xmlclients.model;


import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@XmlRootElement(name = "github.io.truongbn.xmlclients.model.Clients")
public class Clients {
    private List<Client> clients;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Clients)) {
            return false;
        }
        Clients that = (Clients) o;
        return Objects.equals(clients, that.clients);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(clients);
    }

    @Override
    public String toString() {
        return "Clients{" + "clients=" + clients + '}';
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public static final class Client {
        private long id;
        private int index;
        private UUID guid;
        private boolean isActive;
        private BigDecimal balance;
        private String picture;
        private int age;
        private EyeColor eyeColor;
        private String name;
        private String gender;
        private String company;
        private String[] emails;
        private long[] phones;
        private String address;
        private String about;
        private LocalDate registered;
        private double latitude;
        private double longitude;
        private List<String> tags;
        private List<Partner> partners;

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Client)) {
                return false;
            }
            Client client = (Client) o;
            return index == client.index && isActive == client.isActive && age == client.age
                    && Math.abs(Double.doubleToLongBits(client.latitude)
                    - Double.doubleToLongBits(latitude)) < 3
                    && Math.abs(Double.doubleToLongBits(client.longitude)
                    - Double.doubleToLongBits(longitude)) < 3
                    && Objects.equals(id, client.id) && Objects.equals(guid, client.guid)
                    && balance.compareTo(client.balance) == 0
                    && Objects.equals(picture, client.picture)
                    && Objects.equals(eyeColor, client.eyeColor)
                    && Objects.equals(name, client.name) && Objects.equals(gender, client.gender)
                    && Objects.equals(company, client.company)
                    && Arrays.equals(emails, client.emails) && Arrays.equals(phones, client.phones)
                    && Objects.equals(address, client.address)
                    && Objects.equals(about, client.about)
                    && Objects.equals(registered, client.registered)
                    && Objects.equals(tags, client.tags)
                    && Objects.equals(partners, client.partners);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, index, guid, isActive, balance, picture, age, eyeColor, name,
                    gender, company, Arrays.hashCode(emails), Arrays.hashCode(phones), address,
                    about, registered, tags, partners);
        }

        private String toStr(long[] nums) {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            boolean first = true;
            for (long l : nums) {
                if (first)
                    first = false;
                else
                    sb.append(',');
                sb.append(l);
            }
            sb.append(']');
            return sb.toString();
        }

        @Override
        public String toString() {
            return "XmlDataObj{" + "id=" + id + ", index=" + index + ", guid=" + guid
                    + ", isActive=" + isActive + ", balance=" + balance + ", picture=" + picture
                    + ", age=" + age + ", eyeColor=" + eyeColor + ", name=" + name + ", gender="
                    + gender + ", company=" + company + ", emails="
                    + (emails != null ? Arrays.asList(emails) : null) + ", phones=" + toStr(phones)
                    + ", address=" + address + ", about=" + about + ", registered=" + registered
                    + ", latitude=" + latitude + ", longitude=" + longitude + ", tags=" + tags
                    + ", partners=" + partners + '}';
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public UUID getGuid() {
            return guid;
        }

        public void setGuid(UUID guid) {
            this.guid = guid;
        }

        public boolean getIsActive() {
            return isActive;
        }

        public void setIsActive(boolean isActive) {
            this.isActive = isActive;
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public EyeColor getEyeColor() {
            return eyeColor;
        }

        public void setEyeColor(EyeColor eyeColor) {
            this.eyeColor = eyeColor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getCompany() {
            return company;
        }

        public void setCompany(String company) {
            this.company = company;
        }

        public String[] getEmails() {
            return emails;
        }

        public void setEmails(String[] emails) {
            this.emails = emails;
        }

        public long[] getPhones() {
            return phones;
        }

        public void setPhones(long[] phones) {
            this.phones = phones;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public LocalDate getRegistered() {
            return registered;
        }

        public void setRegistered(LocalDate registered) {
            this.registered = registered;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<Partner> getPartners() {
            return partners;
        }

        public void setPartners(List<Partner> partners) {
            this.partners = partners;
        }
    }

    public enum EyeColor {
        BROWN,
        BLUE,
        GREEN;

        public static EyeColor fromNumber(int i) {
            if (i == 0)
                return BROWN;
            if (i == 1)
                return BLUE;
            return GREEN;
        }
    }

    public static final class Partner {
        private long id;
        private String name;
        private OffsetDateTime since;

        public Partner() {
        }

        public static Partner create(long id, String name, OffsetDateTime since) {
            Partner partner = new Partner();
            partner.id = id;
            partner.name = name;
            partner.since = since;
            return partner;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Partner)) {
                return false;
            }
            Partner partner = (Partner) o;
            return id == partner.id && Objects.equals(since, partner.since)
                    && Objects.equals(name, partner.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, since, name);
        }

        @Override
        public String toString() {
            return "Partner{" + "id=" + id + ", name=" + name + ", since=" + since + '}';
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public OffsetDateTime getSince() {
            return since;
        }

        public void setSince(OffsetDateTime since) {
            this.since = since;
        }
    }
}
