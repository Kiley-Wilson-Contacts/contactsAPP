package PhoneContacts;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsList {
    static List<String> contacts = new ArrayList<>();
    private int start = 0;

    public static void main(String[] args) throws IOException {
        ContactsList list = new ContactsList();

        BufferedReader prompt;
        prompt = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";

        String directory = "./data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, filename);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (Files.notExists(dataFile)) {
            Files.createFile(dataFile);
        }
        Path contactsPath = Paths.get(directory, filename);
//        System.out.println("Files.exists(contactsPath) = " + Files.exists(contactsPath));
        while (true) {
            System.out.println(" Welcome to your Contacts ");
            System.out.println("<========================>");
            System.out.println("Please choose an option:");
            System.out.println("1. View Contacts.");
            System.out.println("2. Add a new contact.");
            System.out.println("3. Search contact by name.");
            System.out.println("4. Delete a contact.");
            System.out.println("5. Exit");

            try {
                choice = prompt.readLine();
            } catch (IOException e) {

                System.out.println("Error");
            }
            switch (choice) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":

                    break;
                case "4":

                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid input try again");
                    break;
            }
        }

    }
    public static void addContact() throws IOException{
        Scanner myScanner = new Scanner(System.in);
        System.out.println("1. Add Contact");
        System.out.println(" Enter Name: ");
        String name = myScanner.nextLine();
        System.out.println("Enter A Phone number: ");
        String phone = myScanner.nextLine();



    }

}
