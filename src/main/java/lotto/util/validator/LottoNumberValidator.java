package lotto.util.validator;

import static lotto.util.constants.LottoConstants.CONSECUTIVE_DELIMITER;
import static lotto.util.constants.LottoConstants.INPUT_DELIMITER;
import static lotto.util.constants.LottoConstants.LOTTO_NUMBER_END;
import static lotto.util.constants.LottoConstants.LOTTO_NUMBER_START;
import static lotto.util.constants.LottoConstants.NEEDED_LOTTO_NUMBER_COUNT;
import static lotto.util.message.ExceptionMessage.DUPLICATED_BONUS_NUMBER;
import static lotto.util.message.ExceptionMessage.DUPLICATED_LOTTO_NUMBER;
import static lotto.util.message.ExceptionMessage.ILLEGAL_DELIMITER_USE;
import static lotto.util.message.ExceptionMessage.LOTTO_NUMBER_COUNT_NOT_SIX;
import static lotto.util.message.ExceptionMessage.WINNING_NUMBER_NOT_IN_RANGE;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;

public class LottoNumberValidator extends InputValidator {

    public static List<String> validateInputString(String input) {
        validateBlank(input);
        validateDelimiter(input);
        return Arrays.stream(input.split(INPUT_DELIMITER)).toList();
    }

    private static void validateDelimiter(String input) {
        if (input.startsWith(INPUT_DELIMITER)
                || input.contains(CONSECUTIVE_DELIMITER)
                || input.endsWith(INPUT_DELIMITER)) {
            throw new IllegalArgumentException(ILLEGAL_DELIMITER_USE.toString());
        }
    }

    public static Long validateNumberInRange(String numberToken) {
        Long number = validateLongInt(numberToken);
        if (number < LOTTO_NUMBER_START || number > LOTTO_NUMBER_END) {
            throw new IllegalArgumentException(WINNING_NUMBER_NOT_IN_RANGE.toString());
        }
        return number;
    }

    public static void validateNumberCount(List<Integer> numbers) {
        if (numbers.size() != NEEDED_LOTTO_NUMBER_COUNT) {
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
