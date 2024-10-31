package lotto.domain;

import lotto.util.Convertor;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;

    private WinningNumber(List<Integer> winningNumbers) {
        this.numbers = winningNumbers;
    }

    public static WinningNumber from(String input) {
        return new WinningNumber(Convertor.convertToIntegerList(input));
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }
}
