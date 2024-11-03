package lotto.util.validator;

import java.util.List;
import lotto.message.ExceptionMessage;

public class StringValidator {
    private static final String DELIMITER = ",";
    public static void valiateNumbersFormat(String inputNumbers){
        List<String> numbers = List.of(inputNumbers.split(DELIMITER));

        for (String number : numbers) {
            if (!number.matches("\\d+")) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBERS_FORMAT);
            }
        }
    }
}
