package lotto.prize;

import lotto.Lotto;
import lotto.WinningLotto;

public class KoreaPrizeChecker implements WinningStrategy {

    @Override
    public WinningStatus checkPrize(Lotto lotto, WinningLotto winningLotto) {
        return WinningStatus.second;
    }
}
