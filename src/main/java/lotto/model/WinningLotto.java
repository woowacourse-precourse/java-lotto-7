package lotto.model;

import java.util.List;

public class WinningLotto extends Lotto{
    private final List<Integer> winningNumbers;

    public WinningLotto(List<Integer> numbers) {
        super(numbers);
        this.winningNumbers = numbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
