package lotto.domain.number;

import lotto.domain.lotto.Lotto;

import java.util.List;

public class WinningNumbers {

    private final Lotto winningNumbers;

    private WinningNumbers(final Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers from(final Lotto winningNumbers) {
        return new WinningNumbers(winningNumbers);
    }

    public int countMatchedNumbers(final List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(final int number) {
        return winningNumbers.contains(number);
    }
}