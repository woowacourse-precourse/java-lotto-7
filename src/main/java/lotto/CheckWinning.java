package lotto;

import java.util.List;
import lotto.enums.WinningType;

public class CheckWinning {

    public static void checkDuplicateNum(Lotto winningNumber, List<Lotto> lottoList, int bonusNum) {
        int matchNum = 0;

        for (Lotto lotto : lottoList) {
            matchNum = lotto.findDuplicateNum(winningNumber.getNumbers());

            if (matchNum == 3) {
                WinningType.FIRST.countUp();
            }
            if (matchNum == 4) {
                WinningType.SECOND.countUp();
            }
            if (matchNum == 5) {
                if (lotto.checkDuplicateWithBonusNumber(bonusNum)) {
                    WinningType.FOURTH_BONUS.countUp();
                    continue;
                }
                WinningType.THIRD.countUp();
            }
            if (matchNum == 6) {
                WinningType.FIFTH.countUp();
            }
        }
    }

    public static double calculateProfit(int inputPrice) {

        long allProfit = WinningType.getAllProfit();

        double profit = ((double) allProfit / (double) inputPrice) * 100;
        profit = Math.round(profit * 100.0) / 100.0;

        return profit;
    }

}