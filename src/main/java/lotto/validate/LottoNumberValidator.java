package lotto.validate;

import static lotto.constants.LottoConstants.DELIMITER;

import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.constants.LottoConstants;

public class LottoNumberValidator extends Validator {

    public static void validateNumbersPattern(String input) throws IllegalArgumentException {
        isEmpty(input);
        validateIntegerAndDelimiter(input);
    }

    public static void validateLottoNumbers(List<Integer> numbers) throws IllegalArgumentException {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    public static void validateBonusNumber(String bonusNumber) throws IllegalArgumentException {
        isEmpty(bonusNumber);
        validateNumberRange(parseToInt(bonusNumber));
    }

    private static void validateIntegerAndDelimiter(String input) {
        if (!input.chars().allMatch(ch -> Character.isDigit(ch) || ch == DELIMITER.charAt(0))) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_PATTERN.getMessage());
        }
    }

    private static void validateCount(List<Integer> numbers) {
        if (numbers.size() != LottoConstants.NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_SIZE.getMessage());
        }
    }

    private static void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_DUPLICATE.getMessage());
        }
    }

    private static void validateRange(List<Integer> numbers) throws IllegalArgumentException {
        numbers.forEach(LottoNumberValidator::validateNumberRange);
    }

    private static void validateNumberRange(int number) {
        if (number < LottoConstants.LOTTO_START_INCLUSIVE
                || number > LottoConstants.LOTTO_END_INCLUSIVE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE.getMessage());
        }
    }
}
