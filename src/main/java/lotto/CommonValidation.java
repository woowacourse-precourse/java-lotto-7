package lotto;

import java.util.List;

public class CommonValidation {
    public static int convertStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NUMERIC_VALUE_ERROR.getMessage());
        }
    }

    public static void validateNumbersRange(List<Integer> numbers) {
        boolean condition = numbers.stream().allMatch(number ->
                number >= LottoInfo.FIRST_NUMBER.getInfo() && number <= LottoInfo.LAST_NUMBER.getInfo());
        if (!condition) {
           throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_RANGE_ERROR.getMessage());
        }
    }
}
