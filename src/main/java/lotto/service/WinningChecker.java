package lotto.service;

import lotto.domain.LottoResult;
import lotto.domain.WinningInfo;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class WinningChecker {
    private final Lotto winningNumber;
    private final Integer bonusNumber;
    private final LottoResult result;

    public WinningChecker(Lotto winningNumber, Integer bonusNumber, LottoResult result) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.result = result;
    }

    public void calculate(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            Integer count = lotto.howManyMatches(winningNumber);
            WinningInfo winningInfo = WinningInfo.getWinningInfo(count);
            if (winningInfo.equals(WinningInfo.UNDEFINED)) {
                winningInfo = checkBonusNumber(lotto);
            }
            result.updateResult(winningInfo);
        }
    }

    private WinningInfo checkBonusNumber(Lotto lotto) {
        if (lotto.contains(bonusNumber)) {
            return WinningInfo.SECOND_WINNER;
        }
        if (!lotto.contains(bonusNumber)) {
            return WinningInfo.THIRD_WINNER;
        }
        return WinningInfo.NOT_MATCH;
    }

}
