package lotto;

import lotto.dto.WinningResult;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public WinningResult checkResult(Lotto playerLotto) {
        int matchCount = checkMatchCount(playerLotto);
        int bonusMatchCount = checkBonusMatchCount(playerLotto);

        return new WinningResult(matchCount, bonusMatchCount);
    }

    private int checkMatchCount(Lotto playerLotto) {
        int matchCount = 0;
        for (int number : playerLotto.getNumbers()) {
            if (lotto.has(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private int checkBonusMatchCount(Lotto playerLotto) {
        for (int number : playerLotto.getNumbers()) {
            if (number == this.bonusNumber) {
                return 1;
            }
        }

        return 0;
    }
}
