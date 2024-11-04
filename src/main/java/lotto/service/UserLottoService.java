package lotto.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.enums.ErrorMessage;

public class UserLottoService {

    private static Set<String> numbers;
    private final int LOTTO_START_NUMBER = 1;
    private final int LOTTO_END_NUMBER = 45;
    private final int SIZE_OF_DEFAULT_NUMBERS = 6;

    public void validateDefaultNumber(List<String> numbersToValidate) {
        validateSize(numbersToValidate);
        validateEmpty(numbersToValidate);
        validateFormat(numbersToValidate);
        validateRange(numbersToValidate);
        validateDuplicate(numbersToValidate);
    }

    public void validateBonusNumber(String bonusNumber) {
        validateEmptyBonus(bonusNumber);
        validateFormatBonus(bonusNumber);
        validateRangeBonus(bonusNumber);
        validateDuplicateBonus(bonusNumber);
    }

    private void validateDuplicate(List<String> numbersToValidate) {
        numbers = new HashSet<>(numbersToValidate);
        if (numbers.size() != numbersToValidate.size()) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateSize(List<String> numbersToValidate) {
        if (numbersToValidate.size() != SIZE_OF_DEFAULT_NUMBERS) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.INVALID_SIZE.getMessage());
        }
    }

    private void validateEmpty(List<String> numbersToValidate) {
        if (numbersToValidate == null || numbersToValidate.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    private void validateRange(List<String> numbersToValidate) {
        numbersToValidate.stream()
            .map(Integer::parseInt)
            .filter(i -> i < LOTTO_START_NUMBER || i > LOTTO_END_NUMBER)
            .findAny()
            .ifPresent(invalid -> {
                throw new IllegalArgumentException("[ERROR] " + ErrorMessage.INVALID_RANGE.getMessage());
            });
    }

    private void validateFormat(List<String> numbersToValidate) {
        try {
            numbersToValidate.forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.INVALID_FORMAT_OF_NUMBER.getMessage());
        }
    }

    private void validateDuplicateBonus(String bonusNumber) {
        numbers.add(bonusNumber);
        if (numbers.size() != SIZE_OF_DEFAULT_NUMBERS + 1) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateEmptyBonus(String bonusNumber) {
        if (bonusNumber == null || bonusNumber.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateRangeBonus(String bonusNumber) {
        int parsedBonus = Integer.parseInt(bonusNumber);
        if (parsedBonus < LOTTO_START_NUMBER || parsedBonus > LOTTO_END_NUMBER) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.INVALID_RANGE.getMessage());
        }
    }

    private void validateFormatBonus(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] " + ErrorMessage.INVALID_FORMAT_OF_NUMBER.getMessage());
        }
    }
}
