package lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new Lotto(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int calculatePrize(Lotto lotto) {
        int matchCount = lotto.matchCount(winningLotto);
        boolean bonusMatch = lotto.contains(bonusNumber);

        if (matchCount == 6) {
            return 1; // 1등
        } else if (matchCount == 5 && bonusMatch) {
            return 2; // 2등
        } else if (matchCount == 5) {
            return 3; // 3등
        } else if (matchCount == 4) {
            return 4; // 4등
        } else if (matchCount == 3) {
            return 5; // 5등
        }
        return 0; // 낙첨
    }
}
