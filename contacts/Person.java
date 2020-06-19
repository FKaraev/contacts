package contacts;

import java.time.LocalDate;

public class Person extends Record {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;

    public Person(String firstName, String lastName, String number, String birthDate, String gender) {
        super(number);
        setFirstName(firstName);
        setLastName(lastName);
        setBirthDate(birthDate);
        setGender(gender);
    }

    public static Person create(String firstName, String lastName, String number, String birthDate, String gender) {
        return new Person(firstName, lastName, number, birthDate, gender);
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNumber(String number) {
        this.number = new PhoneNumber(number);
    }

    public void setBirthDate(String birthDate) {
        if (!birthDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            birthDate = "[no data]";
        }

        this.birthDate = birthDate;
    }

    public void setGender(String gender) {
        if (!gender.matches("m|f|M|F")) gender = "[no data]";

        this.gender = gender;
    }

    @Override
    public void update(String field, String value) {
        switch (field) {
            case "name":
                setFirstName(value);
                break;
            case "surname":
                setLastName(value);
                break;
            case "number":
                setNumber(value);
                break;
            case "birth date":
                setBirthDate(value);
                break;
            case "gender":
                setGender(value);
                break;
            default:
                break;
        }
    }

    @Override
    public void printInfo() {
        System.out.printf("Name: %s\nSurname: %s\nBirth date: %s\nGender: %s\n%s",
                firstName, lastName, birthDate, gender, super.toString());
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

}
