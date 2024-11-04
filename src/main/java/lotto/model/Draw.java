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
        String[] numbers = winningNumbers.split(DELIMITER);
        List<Integer> numberGroup = Arrays.stream(numbers)
                .map(number -> Integer.parseInt(number))
                .collect(Collectors.toList());
        DrawValidation.validateWinningNumbersCount(numberGroup);

        this.winningNumbers = numberGroup;
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
