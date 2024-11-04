package lotto.domain;

import static lotto.constants.LottoConstant.MATCH_COUNT_FIVE;

public class LottoResultDetails {

    public static void count(Lottos lottos, WinningLottoNumber winningLottoNumber) {
        int matchingCount = 0;

        for (Lotto lotto : lottos.getLottos()) {
            boolean checkBonus = false;
            matchingCount = checkMatchingCount(lotto, winningLottoNumber);
            if (matchingCount == MATCH_COUNT_FIVE) {
                checkBonus = checkBonusInWinningLottoNumber(lotto, winningLottoNumber);
            }
            Rank.of(matchingCount, checkBonus);
        }
    }

    private static boolean checkBonusInWinningLottoNumber(Lotto lotto, WinningLottoNumber winningLottoNumber) {
        return lotto.getNumbers().contains(winningLottoNumber.getBonusNumber());
    }

    private static int checkMatchingCount(Lotto lotto, WinningLottoNumber winningLottoNumber) {
        int matchingCount = 0;
        for (Integer winningNumber : winningLottoNumber.getWinningNumber()) {
            if (lotto.getNumbers().contains(winningNumber)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }
}
