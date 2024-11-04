package lotto.model;

import lotto.util.Constants;
import lotto.util.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserLotto {
    private List<Integer> numbers;
    private int bonusNumber;

    public void setNumbers(String inputNumbers) {
        validateInputNotEmpty(inputNumbers);
        this.numbers = convertToList(inputNumbers);
        new Lotto(numbers);
    }

    public void setBonusNumber(String inputBonusNumber) {
        validateInputNotEmpty(inputBonusNumber);
        this.bonusNumber = convertToInt(inputBonusNumber);
        validateBonusNumber(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateInputNotEmpty(String inputNumbers) {
        if (inputNumbers == null || inputNumbers.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NULL);
        }
    }

    private List<Integer> convertToList(String inputNumbers) {
        try {
            return Arrays.stream(inputNumbers.split(Constants.DELIMITER_COMMA))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_NUMBER);
        }
    }

    private int convertToInt(String inputBonusNumber) {
        try {
            return Integer.parseInt(inputBonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NOT_NUMBER);
        }
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber > Constants.MAX_LOTTO_NUMBER || bonusNumber < Constants.MIN_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_LANGE);
        }

        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NOT_UNIQUE);
        }
    }
}

