package contacts;

import java.io.Serializable;

public class PhoneNumber implements Serializable {
    private final String CORRECT_PATTERN1 = "\\+?\\(?(\\w+)\\)?";
    private final String CORRECT_PATTERN2 = "\\+?\\(?(\\w+)\\)?[- ](\\w{2,}[- ]*)*";
    private final String CORRECT_PATTERN3 = "\\+?(\\w+)[- ](\\(?\\w{2,}\\)?[- ]*)*";

    private String value;

    public PhoneNumber(String value) {
        if (isCorrect(value)) this.value = value;
        else {
            System.out.println("Wrong format!");
            this.value = "[no number]";
        }
    }

    public String getValue() {
        return value;
    }


    public boolean isCorrect(String input) {
        return !input.isBlank() &&
                (input.matches(CORRECT_PATTERN1) ||
                        input.matches(CORRECT_PATTERN2) ||
                        input.matches(CORRECT_PATTERN3));
    }

    @Override
    public String toString() {
        return value;
    }
}
