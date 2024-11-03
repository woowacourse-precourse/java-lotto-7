package lotto.service;

import lotto.ErrorCode;
import lotto.domain.*;


public class WinningChecker {

    private final WinningNumber winningNumber;
    private final BonusNumber bonusNumber;
    private final LottoResult result;

    public WinningChecker(WinningNumber winningNumber, BonusNumber bonusNumber, LottoResult result) {
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
        if (lotto.contains(bonusNumber.getBonusNumber())) {
            return WinningInfo.SECOND_WINNER;
        }
        if (!lotto.contains(bonusNumber.getBonusNumber())) {
            return WinningInfo.THIRD_WINNER;
        }
        return WinningInfo.NOT_MATCH;
    }
}
