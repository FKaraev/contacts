package contacts;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final Contacts contacts = new Contacts();

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.run();
    }
//
//    public Contacts loadPhoneBook(String file) {
//        Contacts contacts = null;
//        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
//            contacts = (Contacts) ois.readObject();
//
//        } catch (IOException | ClassNotFoundException e) {
//
//        }
//
//    }
}
