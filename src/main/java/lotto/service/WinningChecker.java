package lotto.service;

import lotto.ErrorCode;
import lotto.domain.*;


public class WinningChecker {

    private final LottoResult result;

    public WinningChecker(LottoResult result) {
        this.result = result;
    }

    public void calculate(Lottos lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        for (Lotto lotto : lottos.getLottos()) {
            Integer count = lotto.howManyMatches(winningNumber);
            WinningInfo winningInfo = WinningInfo.getWinningInfo(count);
            if (winningInfo.equals(WinningInfo.UNDEFINED)) {
                winningInfo = checkBonusNumber(lotto, bonusNumber);
            }
            result.updateResult(winningInfo);
        }
    }

    private WinningInfo checkBonusNumber(Lotto lotto, BonusNumber bonusNumber) {
        if (lotto.contains(bonusNumber.getBonusNumber())) {
            return WinningInfo.SECOND_WINNER;
        }
        if (!lotto.contains(bonusNumber.getBonusNumber())) {
            return WinningInfo.THIRD_WINNER;
        }
        return WinningInfo.NOT_MATCH;
    }
}
