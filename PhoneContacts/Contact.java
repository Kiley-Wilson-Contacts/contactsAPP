package PhoneContacts;
import java.util.Scanner;
public class Contact {
    private Scanner scanner;
    private String name;

    private String phone;

//    public Contact(Scanner scan){
//        this.scanner=scan;
//    }
    public Contact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }
//    public String getString(){
//        return Scanner.next
//    }
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
