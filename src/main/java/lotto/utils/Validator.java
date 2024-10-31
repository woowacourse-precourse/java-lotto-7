package lotto.utils;

import java.util.Arrays;
import java.util.List;

public class Validator {

    public static final String WINNING_NUM_PATTERN = "^(\\d+,)+\\d+$";

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

    public static void winningNumValidator(String input) {

        if (!WINNING_NUM_PATTERN.matches(input)) {
            throw new IllegalArgumentException("temp");
        }

        List<String> numbers = Arrays.asList(input.split(","));
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("temp");
        }
    }

    public static void lottoNumValidator(String input) {
        int price;

        try {
            price = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("temp");
        }

        if (price <= 0 || 46 <= price) {
            throw new IllegalArgumentException("temp");
        }

    }
}
