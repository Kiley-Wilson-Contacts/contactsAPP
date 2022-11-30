package PhoneContacts;


import java.io.BufferedReader;
import java.io.File;
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
    private static final String directory = "./data";
    private static final String fileName = "contacts.txt";
    Path dataDirectory = Paths.get(directory);
    static Path contactsPath = Paths.get(directory, fileName);

    public static void main(String[] args) throws IOException {
        ContactsList list = new ContactsList();

        BufferedReader prompt;
        prompt = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";



        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory, fileName);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (Files.notExists(dataFile)) {
            Files.createFile(dataFile);
        }
        Path contactsPath = Paths.get(directory, fileName);
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
                    addContact();
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
        System.out.println(" Enter Name of Contact: ");
        String name = myScanner.nextLine();
        System.out.println("Enter A Phone number: ");
        String phone = myScanner.nextLine();
        Files.write(contactsPath, contacts);



    }

}
