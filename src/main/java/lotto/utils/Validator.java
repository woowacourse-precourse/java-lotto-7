package lotto.utils;

public class Validator {

    public static void priceValidator(String input) {
        int price;

        try {
            price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("temp");
        }

        if (price % 1000 != 0) {
            throw new IllegalArgumentException("temp");
        }
    }
}
