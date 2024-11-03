package lotto.domain;

import lotto.util.Convertor;
import lotto.validation.WinningNumberValidator;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    private WinningNumber(List<Integer> winningNumbers) {
        WinningNumberValidator.validateRange(winningNumbers);
        WinningNumberValidator.validateWinningNumbersSize(winningNumbers);
        this.numbers = winningNumbers;
    }

    public static WinningNumber from(String input) {
        List<Integer> winningNumbers = Convertor.convertToIntegerList(input);
        return new WinningNumber(winningNumbers);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
