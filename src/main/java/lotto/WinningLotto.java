package lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLottoNumbers;
    private final Bonus bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber) {
        this.winningLottoNumbers = new Lotto(winningLotto);
        this.bonusNumber = new Bonus(bonusNumber, this.winningLottoNumbers);
    }

    public int getMatchCount(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLottoNumbers.getNumbers()::contains)
                .count();
    }

    public boolean containsBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getBonusNumber());
    }
}
