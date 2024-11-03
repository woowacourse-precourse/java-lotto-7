package lotto.model.lottoInfo;

import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumbers;

    public WinningNumber(List<Integer> numbers) {
        this.winningNumbers = numbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
