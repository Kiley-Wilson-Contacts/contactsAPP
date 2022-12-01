package PhoneContacts;


import util.Input;

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
    static List<String> contacts;
    private static boolean terminate = false;
    private static int start = 0;
    private static final String directory = "./data";
    private static final String fileName = "contacts.txt";
    static Path dataDirectory = Paths.get(directory);
    static Path contactsPath = Paths.get(directory, fileName);

    public static void main(String[] args) throws IOException {


        BufferedReader prompt;
        prompt = new BufferedReader(new InputStreamReader(System.in));
        String choice = "";

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
                System.out.println("Menu Error");
                System.out.println(e.getMessage());
            }
            switch (choice) {
                case "1":
                    readContact();
                    break;
                case "2":
                    addContact();
                    break;
                case "3":
                    searchContact();
                    break;
                case "4":
                    deleteContact();
                    break;
                case "5":
                    System.exit(0);
                    break;
                default:
                    System.out.println("invalid input try again");
                    break;
            }
            writeContacts();
        }

    }

    public static boolean fileMaker() throws IOException {
        Path dataFile = Paths.get(directory, fileName);

        if (Files.notExists(dataDirectory)) {
            Files.createDirectories(dataDirectory);
        }

        if (Files.notExists(dataFile)) {
            Files.createFile(dataFile);
        }
        return true;
    }

    public static void addContact() throws IOException {
        Scanner myScanner = new Scanner(System.in);
        System.out.println(" Enter Name of Contact: ");
        String name = myScanner.nextLine();
        System.out.println("Enter A phone number ***-****: ");
        String phone = myScanner.nextLine();
        contacts.add(name + " , " + phone);

    }

    public static void readContact() throws IOException {
        if (fileMaker()) {
            try {
                contacts = Files.readAllLines(contactsPath);
            } catch (IOException e) {
                System.out.println("failed to load contact list");
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        System.out.println("Your Contact List");
        System.out.println("Contact | Phone Number");
        System.out.println("<--------------------------->");
        for (int c = 0; c < contacts.size(); c++) {
            System.out.println(contacts.get(c));
        }
        System.out.println("<--------------------------->");
        System.out.println();
    }

    public static void writeContacts() throws IOException {
        if (fileMaker()) {
            try {
                Files.write(contactsPath, contacts);
            } catch (IOException e) {
                System.out.println("There was an error writing to the file.");
                System.out.println(e.getMessage());
            }
        }
    }

    public static void searchContact() {

        Scanner search = new Scanner(System.in);
        Input find = new Input(search);
        String name = find.getString("Enter a Name");

        for (int i = 0; i < contacts.size(); i++) {
            String[] entry = contacts.get(i).split(" , ", 2);
            if (entry[0].equalsIgnoreCase(name)) {
                terminate = true;
                start = i;
            }
        }
        if (terminate) {
            String[] entry = contacts.get(start).split(" , ", 2);
            System.out.println("Here is that contact:");
            System.out.println("<--------------------->");
            System.out.println("Name      |      Number");
            System.out.println("<--------------------->");
            System.out.println(entry[0] + " | " + entry[1]);
            System.out.println();
        } else {
            System.out.println("No Contact Exist");
        }

    }public static void deleteContact() throws IOException {

        Scanner scn = new Scanner(System.in);
        Input delete = new Input(scn);
        String name = delete.getString("Enter a Name to delete");

        for (int i = 0; i < contacts.size(); i++) {
            String[] entry = contacts.get(i).split(" , ", 2);
            if (entry[0].equalsIgnoreCase(name)) {
                terminate = true;
                start = i;
            }
        }
        if (terminate) {
            String[] entry = contacts.get(start).split(" , ", 2);
            System.out.println("Here is that contact:");
            System.out.println("<--------------------->");
            System.out.println("Name      |      Number");
            System.out.println("<--------------------->");
            System.out.println(entry[0] + " | " + entry[1]);
            String gone = delete.getString("Would you like to delete this contact, enter yes");
            if(gone.equalsIgnoreCase("yes")){
                contacts.remove(contacts.get(start));
            }
        } else {
            System.out.println("No Contact Exist");
        }

    }

}
