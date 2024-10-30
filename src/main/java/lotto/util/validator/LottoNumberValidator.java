package lotto.util.validator;

import static lotto.util.message.ExceptionMessage.DUPLICATED_BONUS_NUMBER;
import static lotto.util.message.ExceptionMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.util.message.ExceptionMessage.ILLEGAL_DELIMITER_USE;
import static lotto.util.message.ExceptionMessage.LOTTO_NUMBER_COUNT_NOT_SIX;
import static lotto.util.message.ExceptionMessage.WINNING_NUMBER_NOT_IN_RANGE;

import java.util.List;
import lotto.model.Lotto;

public class LottoNumberValidator extends InputValidator {

    public static String validateInputString(String input) {
        validateBlank(input);
        validateDelimiter(input);
        return input;
    }

    private static void validateDelimiter(String input) {
        if (input.startsWith(",") || input.contains(",,") || input.endsWith(",")) {
            throw new IllegalArgumentException(ILLEGAL_DELIMITER_USE.toString());
        }
    }

    public static Integer validateNumberInRange(String numberToken) {
        int number = validateInteger(numberToken);
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(WINNING_NUMBER_NOT_IN_RANGE.toString());
        }
        return number;
    }

    public static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT_NOT_SIX.toString());
        }
    }

    public static void validateDuplicated(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBER.toString());
        }
    }

    public static Integer validateDuplicated(Lotto numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.toString());
        }
        return bonusNumber;
    }
}
