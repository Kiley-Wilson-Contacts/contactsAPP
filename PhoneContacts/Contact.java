package PhoneContacts;

public class Contact {
    private String name;

    private String phone;

    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public String setName() {
        return (this.name = name);
    }


    public String getPhone() {
        return this.phone;
    }

    public String setPhone() {
        return (this.phone = phone);
    }

}
