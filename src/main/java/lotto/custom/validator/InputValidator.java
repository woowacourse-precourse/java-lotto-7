package lotto.custom.validator;

import static lotto.custom.constants.NumberConstants.LOTTO_NUMBERS_PER_TICKET;
import static lotto.custom.constants.NumberConstants.LOTTO_NUMBER_RANGE_END;
import static lotto.custom.constants.NumberConstants.LOTTO_NUMBER_RANGE_START;
import static lotto.custom.constants.NumberConstants.LOTTO_PRICE;
import static lotto.custom.constants.RegexConstants.DIGITS_SPACE_ONLY_REGEX;
import static lotto.custom.constants.RegexConstants.DIGIT_COMMA_SPACE_ONLY_REGEX;
import static lotto.custom.constants.RegexConstants.DIGIT_ONLY_REGEX;

import java.util.List;
import lotto.custom.common.Exceptions;

public class InputValidator {
    private final Exceptions exceptions;

    public InputValidator() {
        exceptions = new Exceptions();
    }

    // 구입 금액 입력 유효성 검증

    public void validatePurchaseAmountInput(String input) {
        exceptions.checkEmptyInput(input);
        exceptions.checkInvalidCharacters(input, DIGIT_ONLY_REGEX);
        exceptions.checkIntegerOverflow(input);
        validateAmountDivisibilityByLOTTOPRICE(input);
    }

    public void validateAmountDivisibilityByLOTTOPRICE(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(CustomErrorMessages.NOT_DIVISIBLE_BY_THOUSAND);
        }
    }

    // 당첨 번호 입력 유효성 검증

    public void validateWinningNumbersInput(String input) {
        exceptions.checkEmptyInput(input);
        exceptions.checkInvalidCharacters(input, DIGIT_COMMA_SPACE_ONLY_REGEX);
        exceptions.checkSpacesBetweenNumbers(input);
    }

    public void validateWinningNumbers(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateUniqueNumbers(numbers);
        validateNumberRange(numbers);
    }

    public void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_PER_TICKET) {
            throw new IllegalArgumentException(CustomErrorMessages.LOTTO_NUMBER_COUNT);
        }
    }

    public void validateUniqueNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBERS_PER_TICKET) {
            throw new IllegalArgumentException(CustomErrorMessages.LOTTO_NUMBERS_MUST_BE_UNIQUE);
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            exceptions.checkOutOfRange(number, LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END,
                    CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    // 보너스 번호 입력 유효성 검증

    public void validateBonusNumberInput(String input) {
        exceptions.checkEmptyInput(input);
        exceptions.checkInvalidCharacters(input, DIGITS_SPACE_ONLY_REGEX);
        exceptions.checkSpacesBetweenNumbers(input);
    }

    public void validateBonusNumbers(List<Integer> winningNumbers, int bonusNumber) {
        validateBonusNumberIsNotDuplicate(winningNumbers, bonusNumber);

        exceptions.checkOutOfRange(bonusNumber, LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END,
                CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
    }

    public void validateBonusNumberIsNotDuplicate(List<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(CustomErrorMessages.BONUS_NUMBER_DUPLICATE);
        }
    }
}