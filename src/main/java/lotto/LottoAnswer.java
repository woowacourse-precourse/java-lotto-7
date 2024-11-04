package lotto;

import java.util.List;

public class LottoAnswer {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoAnswer(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isNumberMatch(int number) {
        return winningNumbers
                .stream()
                .anyMatch(winningNumber -> winningNumber == number);
    }

    public boolean isBonusMatch(int number) {
        return bonusNumber == number;
    }
}
