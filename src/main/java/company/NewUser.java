package company;

public class NewUser {
    private int userId;
    private int id;
    private String name;
    private String userName;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    NewUser(NewUserBuilder builder) {
        this.userId = builder.userId;
        this.id = builder.id;
        this.name = builder.name;
        this.userName = builder.userName;
        this.email = builder.email;
        this.address = builder.address;
        this.phone = builder.phone;
        this.website = builder.website;
        this.company = builder.company;
    }

    public static class NewUserBuilder{
        private int userId;
        private int id;
        private String name;
        private String userName;
        private String email;
        private Address address;
        private String phone;
        private String website;
        private Company company;

        public NewUserBuilder setUserId(int userId) {
            this.userId = userId;
            return this;
        }

        public NewUserBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public NewUserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public NewUserBuilder setUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public NewUserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public NewUserBuilder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public NewUserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public NewUserBuilder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public NewUserBuilder setCompany(Company company) {
            this.company = company;
            return this;
        }

        public NewUser build() {
            return new NewUser(this);
        }
    }
}










