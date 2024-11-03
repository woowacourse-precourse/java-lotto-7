package lotto.manager;

import lotto.domain.*;
import java.util.List;


public class GameResultManager {
    private WinningLotto winningLotto;

    public void changeWinningLotto(List<Integer> winningNumbers, int bonusNumber) {

        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    private int countMatchNumberWith(Lotto lotto) {
        int count = 0;

        for (Integer number : lotto.getImmutableNumbers()) {
            if (winningLotto.getImmutableWinningNumbers().contains(number)) {
                count++;
            }
        }

        return count;
    }

    private boolean matchBonusNumberWith(Lotto lotto) {

        return lotto.getImmutableNumbers().contains(winningLotto.getImmutableBonusNumber().getNumber());
    }
}
