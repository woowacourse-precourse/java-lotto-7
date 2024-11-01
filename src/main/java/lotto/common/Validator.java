package lotto.common;

import java.util.List;
import java.util.regex.Pattern;

public class Validator {
    private static final int CRITERIA_PRICE = 1000;
    private static final String REGEX_NUMBER_PATTERN = "^(?:[1-9]|[1-3][0-9]|4[0-5])$";
    private static final String REGEX_INVALID_DELIMITER_PATTERN = ".*[^,\\w\\s].*";
    private static final Pattern validNumber = Pattern.compile(REGEX_NUMBER_PATTERN);
    private static final Pattern InvalidDelimiter = Pattern.compile(REGEX_INVALID_DELIMITER_PATTERN);

    public void validatePrice(int price) {
        isPositivePrice(price);
        isValidPrice(price);
    }

    public int isNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ExceptionCode.INVALID_NUMBER.message());
        }
    }

    private void isValidPrice(int price) {
        if (price % CRITERIA_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionCode.PRICE_DOES_NOT_DIVIDE.message());
        }
    }

    private void isPositivePrice(int price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_POSITIVE_PRICE.message());
        }
    }

    public int parseQuantity(int price) {
        return price / CRITERIA_PRICE;
    }

    public void validateDelimiter(String input) {
        if (InvalidDelimiter.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_DELIMITER.message());
        }
    }

    public void isNumberInRange(String input) {
        if (!validNumber.matcher(input).matches()) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_RANGE_NUMBER.message());
        }
    }

    public void isUniqueBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        boolean isDuplicate = winningNumbers.stream()
                .anyMatch(num -> num.equals(bonusNumber));
        if (isDuplicate) {
            throw new IllegalArgumentException(ExceptionCode.BONUS_NUMBER_DOES_NOT_UNIQUE.message());
        }
    }
}
