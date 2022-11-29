package PhoneContacts;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContactsList {
    public static void main(String[] args) throws IOException {
        String directory = "./data";
        String filename = "contacts.txt";
        Path dataDirectory = Paths.get(directory);
        Path dataFile = Paths.get(directory,filename);

        if(Files.notExists(dataDirectory)){
            Files.createDirectories(dataDirectory);
        }

        if(Files.notExists(dataFile)){
            Files.createFile(dataFile);
        }

    }
}
