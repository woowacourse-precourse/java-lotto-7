package lotto.validation;

import java.math.BigDecimal;
import java.util.List;
import lotto.util.enums.ValidateMessage;

public class NumberValidator {
    private static final int FIFTY_FIVE = 45;
    private static final int ZERO = 0;

    public static void validateNumberCondition(List<Integer> numbers) {
        numbers.forEach(number -> {
            if (overThanFiftyFive(number)) {
                throw new IllegalArgumentException(ValidateMessage.NUMBER_RANGE_ERROR.getMessage());
            }
            if (isEqualOrLessThanZero(number)) {
                throw new IllegalArgumentException(ValidateMessage.POSITIVE_NUMBER_ERROR.getMessage());
            }
            if (isDouble(number)) {
                throw new IllegalArgumentException(ValidateMessage.DOUBLE_ERROR.getMessage());
            }
        });
    }

    private static boolean overThanFiftyFive(int number) {
        return number >= FIFTY_FIVE;
    }

    private static boolean isEqualOrLessThanZero(int number) {
        return number <= ZERO;
    }

    private static boolean isDouble(int number) {
        BigDecimal bigDecimal = new BigDecimal(number);
        int intValue = bigDecimal.intValue();
        BigDecimal decimalValue = bigDecimal.subtract(new BigDecimal(intValue));
        return decimalValue.doubleValue() > 0;
    }
}
