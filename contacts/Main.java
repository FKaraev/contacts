package contacts;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static final Contacts contacts = new Contacts();

    public static void main(String[] args) throws Exception {
        PhoneBook phoneBook = null;
        if(args.length == 0) phoneBook = new PhoneBook(args[0]);
        else phoneBook = new PhoneBook();

        phoneBook.run();
    }
}
