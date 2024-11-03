package lotto.prize;

import lotto.Lotto;
import lotto.WinningLotto;

public interface WinningStrategy {

    public WinningStatus checkPrize(Lotto lotto, WinningLotto winningLotto);

}
