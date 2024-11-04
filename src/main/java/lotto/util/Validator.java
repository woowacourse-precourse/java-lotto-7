package lotto.util;

import java.util.List;

public class Validator {
    public static boolean isDuplicate(List<?> items) {
        return items.stream().distinct().count() != items.size();
    }

    public static boolean isInteger(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isPositive(String value) {
        int castedValue = Integer.parseInt(value);
        return castedValue > 0;
    }

    public static boolean areAllNumbersInRange1To45(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}