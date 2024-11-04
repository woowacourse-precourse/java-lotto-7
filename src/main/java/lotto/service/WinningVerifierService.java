package lotto.service;

import lotto.domain.LotteryDrawMachine;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

public class WinningVerifierService {
    public static WinningResult verifyLotto(Lotto lotto, LotteryDrawMachine drawMachine) {
        int matchCount = (int) lotto.getNumbers().stream().filter(drawMachine.getJackpotNumbers()::contains).count();
        boolean bonusMatch = lotto.getNumbers().contains(drawMachine.getBonusNumber());
        return new WinningResult(matchCount, bonusMatch);
    }
}
