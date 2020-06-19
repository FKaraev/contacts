package contacts;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

public class PhoneBook {
    private Contacts contacts;
    private Scanner scanner;

    public PhoneBook() {
        contacts = new Contacts();
    }


    public void run() {
        scanner = new Scanner(System.in);
        performMenuAction();
    }

    private void performMenuAction() {

        do {

            System.out.println("[menu]Enter action (add, list, search, count, info, exit): ");
            String action = scanner.nextLine();
            if (action.equals("exit")) exit(0);

            switch (action) {
                case "add":
                    create();
                    break;
                case "list":
                    performListAction();
                    break;
                case "search":
                    search();
                    performSearchAction();
                    break;
                case "count":
                    printNumberOfContacts();
                    break;
                case "info":
                    contacts.printListOfContacts();
                    System.out.println("Select a record:");
                    int i = scanner.nextInt();
                    scanner.nextLine();

                    printInfo(i);
                    break;
            }
        } while (true);

    }

    private void performSearchAction() {
        System.out.println("[search]Enter action([number], back, again):");
        String action = scanner.nextLine();

        switch (action) {
            case "back":
                performMenuAction();
                break;
            case "again":
                search();
                performSearchAction();
                break;
            default:
                performRecordAction(Integer.parseInt(action));
                break;
        }

    }

    private void performRecordAction(int i) {
        contacts.printInfo(i);
        System.out.println("[record] Enter action(edit, delete, menu):");
        String query = scanner.nextLine();
        switch (query) {
            case "edit":
                edit(i);
                break;
            case "delete":
                remove();
                break;
            case "menu":
                performMenuAction();
                break;
        }
    }

    private void performListAction() {
        contacts.printListOfContacts();
        System.out.println();

        if (contacts.isEmpty()) return;

        System.out.println("[list]Enter action([number], back):");

        String action = scanner.nextLine();

        switch (action) {
            case "back":
                performMenuAction();
                break;
            default:
                performRecordAction(Integer.parseInt(action));
                break;
        }

    }

    private void create() {
        System.out.println("Enter the type(person, organization):");
        String type = scanner.nextLine();
        if ("person".equals(type)) createPerson();
        else if ("organization".equals(type)) createOrganization();

    }

    private void createPerson() {

        System.out.println("Enter the name of the person:");
        String firstName = scanner.nextLine();

        System.out.println("Enter the surname of the person:");
        String lastName = scanner.nextLine();

        System.out.println("Enter birth date:");
        String birthDate = scanner.nextLine();

        if (!birthDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("Bad birth date");
        }

        System.out.println("Enter gender(M, F):");
        String gender = scanner.nextLine();

        if (!gender.equalsIgnoreCase("M")
                && !gender.equalsIgnoreCase("F")) {
            System.out.println("Bad gender");
        }

        System.out.println("Enter the number :");
        String number = scanner.nextLine();

        contacts.addContact(Person.create(firstName, lastName, number, birthDate, gender));
        System.out.println("Record added\n");

    }

    private void createOrganization() {
        System.out.println("Enter the organization name:");
        String name = scanner.nextLine();

        System.out.println("Enter the address:");
        String address = scanner.nextLine();

        System.out.println("Enter the number:");
        String number = scanner.nextLine();

        contacts.addContact(new Organization(name, address, number));
        System.out.println("Record added\n");
    }

    private void edit(int i) {

        System.out.println("Select a field");
        String field = scanner.nextLine();

        System.out.println("Enter " + field );;
        String value = scanner.nextLine();

        contacts.update(i, field, value);

        System.out.println("Record updated\n");

    }

    private void remove() {
        if (contacts.isEmpty()) {
            System.out.println("No records to remove!");
        } else {
            contacts.printListOfContacts();
            System.out.println("Select a record:");
            int i = scanner.nextInt();
            scanner.nextLine();
            contacts.remove(i);
            System.out.println("Record removed");
        }
    }

    private void search() {
        System.out.println("Enter search query ");
        String query = scanner.nextLine();

        List<Record> searchResult = contacts.search(query.toLowerCase());
        if(!searchResult.isEmpty()) {
            for (int i = 0; i < searchResult.size(); i++) {
                System.out.println(i + 1 + ". " + searchResult.get(i).toString());
            }
        }
        System.out.println();
    }

    private void printInfo(int i) {

        if (!contacts.isEmpty()) {
            contacts.printInfo(i);
        }
    }

    private void printNumberOfContacts() {
        System.out.printf("The phone book has %d records\n", contacts.numberOfContacts());
        System.out.println();
    }
}
