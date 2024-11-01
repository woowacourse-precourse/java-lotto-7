package lotto.validator;

import static lotto.exception.WinningNumbersExceptionMessage.BONUS_NUMBER_DUPLICATE;
import static lotto.exception.WinningNumbersExceptionMessage.BONUS_NUMBER_OUT_OF_RANGE;
import static lotto.exception.WinningNumbersExceptionMessage.NULL_OR_EMPTY_NUMBERS;

import java.util.List;
import java.util.Objects;
import lotto.configuration.LottoConfiguration;
import lotto.exception.LottoValidationException;

public class WinningNumbersValidator {
    public static void validate(List<Integer> mainNumbers, int bonusNumber) {
        mainNumbers(mainNumbers);
        bonusNumber(mainNumbers, bonusNumber);
    }

    public static void bonusNumber(List<Integer> mainNumbers, int bonusNumber) {
        if (!(LottoConfiguration.LOTTO_MIN_NUMBER.getValue() <= bonusNumber
              && bonusNumber <= LottoConfiguration.LOTTO_MAX_NUMBER.getValue())) {
            throw new LottoValidationException(BONUS_NUMBER_OUT_OF_RANGE);
        }
        if (mainNumbers.stream().anyMatch(number -> number == bonusNumber)) {
            throw new LottoValidationException(BONUS_NUMBER_DUPLICATE);
        }
    }

    public static void mainNumbers(List<Integer> mainNumbers) {
        if (mainNumbers == null || mainNumbers.isEmpty() || mainNumbers.stream().anyMatch(Objects::isNull)) {
            throw new LottoValidationException(NULL_OR_EMPTY_NUMBERS);
        }
    }
}
