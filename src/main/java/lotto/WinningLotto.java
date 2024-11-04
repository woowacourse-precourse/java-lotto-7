package lotto;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusNumber bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Lotto lotto) {
        int count = 0;
        for (int num : lotto.getNumbers()) {
           if (winningLotto.containNumber(num)) {
               count += 1;
           }
        }

        return count;
    }
}
