package lotto.model;

import java.util.List;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new Lotto(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public int countMatchingNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                          .filter(number -> winningNumbers.getNumbers().contains(number))
                          .count();
    }

    public boolean isBonusNumberMatched(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
