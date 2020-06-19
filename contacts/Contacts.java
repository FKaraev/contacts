package contacts;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Contacts implements Serializable {
    List<Record> records;

    public Contacts() {
        records = new ArrayList<>();
    }

    public void addContact(Record record) {
        records.add(record);
    }

    public void update(int record, String field, String value){
        records.get(record-1).update(field, value);
    }

    public void remove(int position) {
        records.remove(position - 1);
    }

    public List<Record> search(String query) {
       return records.stream().
                filter(record ->
                        record.toString().toLowerCase().contains(query)
                                || record.getNumber().contains(query)).
                collect(Collectors.toList());
    }

    public void printListOfContacts() {
        if (records.isEmpty()) System.out.println("The phone book is empty");
        for (int i = 0; i < records.size(); i++) {
            System.out.printf("%d. %s\n", i + 1, records.get(i).toString());
        }
    }

    public int numberOfContacts() {
        return records.size();
    }

    public boolean isEmpty() {
        return records.isEmpty();
    }

    public void printInfo(int i) {
        records.get(i - 1).printInfo();
        System.out.println();
    }
}
