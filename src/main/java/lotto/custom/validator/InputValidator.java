package lotto.custom.validator;

import static lotto.custom.constants.NumberConstants.LOTTO_PRICE;

import java.util.List;
import lotto.custom.common.Exceptions;

public class InputValidator {
    private final Exceptions exceptions;

    public InputValidator() {
        exceptions = new Exceptions();
    }

    public void validatePurchaseAmountInput(String input) {
        exceptions.emptyInput(input);
        exceptions.invalidCharacters(input, "[0-9]+");
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
        exceptions.invalidCharacters(input, "^[0-9,\\s]*$");
        if (input.matches(".*\\d+\\s+\\d+.*")) {
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
        exceptions.invalidCharacters(input, "^[0-9\\s]*$");
        if (input.matches(".*\\d+\\s+\\d+.*")) {
            throw new IllegalArgumentException(CustomErrorMessages.SPACE_BETWEEN_NUMBERS);
        }
    }

    public void validateBonusNumbers(List<Integer> winningNumbers, int bonusNumber) {
        // 보너스 번호가 당첨 번호와 같을 때
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(CustomErrorMessages.BONUS_NUMBER_DUPLICATE);
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
        }
    }

    public void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(CustomErrorMessages.LOTTO_NUMBER_COUNT);
        }
    }

    public void validateUniqueNumbers(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(CustomErrorMessages.LOTTO_NUMBERS_MUST_BE_UNIQUE);
        }
    }

    public void validateNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(CustomErrorMessages.LOTTO_NUMBER_OUT_OF_RANGE);
            }
        }
    }
}