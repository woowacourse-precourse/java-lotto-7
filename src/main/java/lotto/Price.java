package lotto;

public class Price {
    private final int value;

    public Price(int value) {
        validate(value);
        this.value = value;
    }

    public static Price from(String input) {
        try {
            return new Price(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validate(int value) {

    }
}
