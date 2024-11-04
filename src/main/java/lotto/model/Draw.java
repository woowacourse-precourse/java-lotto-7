package lotto.model;

import lotto.validation.DrawValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Draw {
    private static final String DELIMITER = ",";
    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public Draw(String winningNumbers) {
        List<Integer> numberGroup = separateNumbers(winningNumbers);
        validateWinningNumbers(numberGroup);
        this.winningNumbers = numberGroup;
    }

    public void putBonusNumber(String bonusNumber) {
        int number = Integer.parseInt(bonusNumber);
        validateBonusNumber(winningNumbers, number);
        this.bonusNumber = number;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateWinningNumbers(List<Integer> numberGroup) {
        DrawValidation.validateWinningNumbersCount(numberGroup);
        DrawValidation.validateDuplicatedWinningNumbers(numberGroup);
        DrawValidation.validateWinningNumberRange(numberGroup);
    }

    private void validateBonusNumber(List<Integer> numberGroup, int bonusNumber) {
        DrawValidation.validateDuplicatedNumber(numberGroup, bonusNumber);
        DrawValidation.validateBonusNumberRange(bonusNumber);
    }

    private List<Integer> separateNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(DELIMITER);
        return Arrays.stream(numbers)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }
}
