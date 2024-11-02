package lotto.custom.validator;

import static lotto.custom.constants.NumberConstants.LOTTO_NUMBERS_PER_TICKET;
import static lotto.custom.constants.NumberConstants.LOTTO_NUMBER_RANGE_END;
import static lotto.custom.constants.NumberConstants.LOTTO_NUMBER_RANGE_START;
import static lotto.custom.constants.NumberConstants.LOTTO_PRICE;
import static lotto.custom.constants.RegexConstants.DIGITS_SPACE_ONLY_REGEX;
import static lotto.custom.constants.RegexConstants.DIGIT_COMMA_SPACE_ONLY_REGEX;
import static lotto.custom.constants.RegexConstants.DIGIT_ONLY_REGEX;
import static lotto.custom.constants.RegexConstants.DIGIT_SPACE_DIGIT_REGEX;

import java.util.List;
import lotto.custom.common.Exceptions;


public class InputValidator {
    private final Exceptions exceptions;

    public InputValidator() {
        exceptions = new Exceptions();
    }

    public void validatePurchaseAmountInput(String input) {
        exceptions.emptyInput(input);
        exceptions.invalidCharacters(input, DIGIT_ONLY_REGEX);
        exceptions.integerOverflow(input);
        validateAmountDivisibilityByLOTTOPRICE(input);
    }

    public void validateAmountDivisibilityByLOTTOPRICE(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(CustomErrorMessages.NOT_DIVISIBLE_BY_THOUSAND);
        }
    }

    public void validateWinningNumbersInput(String input) {
        exceptions.emptyInput(input);
        exceptions.invalidCharacters(input, DIGIT_COMMA_SPACE_ONLY_REGEX);
        if (input.matches(DIGIT_SPACE_DIGIT_REGEX)) {
            throw new IllegalArgumentException(CustomErrorMessages.SPACE_BETWEEN_NUMBERS);
        }
    }

    public void validateLottoNumbers(List<Integer> numbers) {
        validateLottoNumberCount(numbers);
        validateUniqueNumbers(numbers);
        validateNumberRange(numbers);
    }

    public void validateBonusNumberInput(String input) {
        exceptions.emptyInput(input);
        exceptions.invalidCharacters(input, DIGITS_SPACE_ONLY_REGEX);
        if (input.matches(DIGIT_SPACE_DIGIT_REGEX)) {
            throw new IllegalArgumentException(CustomErrorMessages.SPACE_BETWEEN_NUMBERS);
        }
    }

    public void validateBonusNumbers(List<Integer> winningNumbers, int bonusNumber) {
        // 보너스 번호가 당첨 번호와 같을 때
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(CustomErrorMessages.BONUS_NUMBER_DUPLICATE);
        }

        if (bonusNumber < LOTTO_NUMBER_RANGE_START || bonusNumber > LOTTO_NUMBER_RANGE_END) {
            throw new IllegalArgumentException(CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
        }
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
            if (number < LOTTO_NUMBER_RANGE_START || number > LOTTO_NUMBER_RANGE_END) {
                throw new IllegalArgumentException(CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
            }
        }
    }
}