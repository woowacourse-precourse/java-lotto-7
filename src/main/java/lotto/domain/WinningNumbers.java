package lotto.domain;

import lotto.service.Validator;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final Validator validator = new Validator();
    private final List<Integer> numbers = new ArrayList<>();
    public WinningNumbers(String input) {
        String[] separatedNumbers = input.split(",");
        drawWinningNumbers(separatedNumbers);
        validateNumbersSize();
    }

    private void drawWinningNumbers(String[] separatedNumbers) {
        for(String separated : separatedNumbers) {
            validator.validateEmptyInputInNumbers(separated);
            int winningNumber = validator.validateFormatInput(separated);
            validator.validateNumberInRange(winningNumber);
            validator.validateWinningNumberDuplicate(winningNumber, numbers);
            numbers.add(winningNumber);
        }
    }

    private void validateNumbersSize() {
        validator.validateNumberCount(numbers.size());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
