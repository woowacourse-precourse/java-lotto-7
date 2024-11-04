package lotto.model;

import java.util.List;

public class WinningNumbers {
    private final Lotto winningNumbers;

    private WinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers from(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        return new WinningNumbers(lotto);
    }

    public boolean contains(int number) {
        return winningNumbers.contains(number);
    }

}
