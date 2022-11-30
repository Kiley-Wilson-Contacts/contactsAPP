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

    private int start = 0;
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
                    readContacts();
                    break;
                case "2":
                    addContact();
                    break;
                case "3":
                    searchContact();
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
            writeContacts();
        }

    }

    public static boolean goodToGo() throws IOException {
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

    public static void readContacts() throws IOException {
        if (goodToGo()) {
            try {
                contacts = Files.readAllLines(contactsPath);
            } catch (IOException e) {
                System.out.println("failed to load");
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
        if (goodToGo()) {
            try {
                Files.write(contactsPath, contacts);
            } catch (IOException e) {
                System.out.println("There was an error writing to the file.");
                System.out.println(e.getMessage());
            }
        }
    }
    public static void searchContact() {
        boolean fake = false;
        int index = 0;
        Scanner search = new Scanner(System.in);
        Input find = new Input(search);
        System.out.println("3. Search by name ");
        String name = find.getString("Enter a Name");

        for (int i = 0; i < contacts.size(); i++) {
            String[] entry = contacts.get(i).split(" , ");
            if (entry[0].equalsIgnoreCase(name)) {
                fake = true;
                index = i;
            }
        } if(fake){
            String[] entry = contacts.get(index).split(" , ");
            System.out.println(entry);
        }else{
            System.out.println("No Contact Exist");
        }

    }

}
