package lotto.model;

import java.util.HashSet;
import java.util.Set;

import static lotto.constants.Constants.*;

// 당첨 번호와 보너스 번호를 관리하며, 당첨 기준에 따라 등수를 판별
public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumbers(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }
    public int calculateRank(Lotto lotto) {
        Set<Integer> lottoNumbers = new HashSet<>(lotto.getNumbers());
        lottoNumbers.retainAll(winningLotto.getNumbers());

        int matchCount = lottoNumbers.size();
        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

        return getRank(matchCount, bonusMatch);
    }

    private int getRank(int matchCount, boolean bonusMatch) {
        if (matchCount == FIRST_PLACE.getValue()) {
            return 1;
        } else if (matchCount == SECOND_PLACE.getValue() && bonusMatch) {
            return 2;
        } else if (matchCount == THIRD_PLACE.getValue()) {
            return 3;
        } else if (matchCount == FOURTH_PLACE.getValue()) {
            return 4;
        } else if (matchCount == FIFTH_PLACE.getValue()) {
            return 5;
        }
        return 0;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
