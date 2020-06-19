package contacts;

import java.time.LocalDateTime;

public class Organization extends Record{

    private String name;
    private String address;


    public Organization(String name, String address, String number){
        super(number);
        this.name = name;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public void update(String field, String value) {
        switch (field){
            case "name":
                setName(value);
                break;
            case "address":
                setAddress(value);
                break;
            case "number":
                setNumber(value);
                break;
            default:
                break;
        }

        lastModified = LocalDateTime.now();
    }

    @Override
    public void printInfo() {
        System.out.printf("Organization name: %s\nAddress: %s\n%s",
                name, address, super.toString());
    }

    @Override
    public String toString() {
       return name;
    }
}
