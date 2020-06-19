package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Record implements Serializable {

    protected PhoneNumber number;
    protected LocalDateTime createdAt;
    protected LocalDateTime lastModified;


    public Record() {
        createdAt = LocalDateTime.now();
        lastModified = LocalDateTime.now();
    }

    public Record(String number){
        this.number = new PhoneNumber(number);
        createdAt = LocalDateTime.now();
        lastModified = LocalDateTime.now();
    }

    public void update(String field, String value){
    }

    public void setNumber(String number) {
        this.number = new PhoneNumber(number);
    }

    public void printInfo(){
        System.out.println(this);
    }

    public String getNumber() {
        return number.toString();
    }

    @Override
    public String toString() {
        return String.format("Number: %s\nTime created: %s\nTime last edit: %s\n",
                number.toString(), createdAt.toString(), lastModified.toString());
    }
}


