package lotto.model;

import lotto.validation.DrawValidation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Draw {
    private static final String DELIMITER = ",";
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Draw(String winningNumbers, String bonusNumber) {
        List<Integer> numberGroup = separateNumbers(winningNumbers);
        int number = Integer.parseInt(bonusNumber);

        validateDrawNumbers(numberGroup, number);

        this.winningNumbers = numberGroup;
        this.bonusNumber = number;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateDrawNumbers(List<Integer> numberGroup, int bonusNumber) {
        DrawValidation.validateWinningNumbersCount(numberGroup);
        DrawValidation.validateDuplicatedNumber(numberGroup, bonusNumber);
        DrawValidation.validateWinningNumberRange(numberGroup);
        DrawValidation.validateBonusNumberRange(bonusNumber);
    }

    private List<Integer> separateNumbers(String winningNumbers) {
        String[] numbers = winningNumbers.split(DELIMITER);
        return Arrays.stream(numbers)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
    }
}
