package lotto.Console;

import java.util.List;
import lotto.CheckWinning;
import lotto.Lotto;
import lotto.enums.PrizeComment;
import lotto.enums.WinningType;

public class OutputConsole {

    public static void outputLottoList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void outputWinningStatics(Lotto winningLottoNumbers, List<Lotto> lottoList, int bonusNum) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        CheckWinning.checkDuplicateNum(winningLottoNumbers, lottoList, bonusNum);
        System.out.println(PrizeComment.SAME_THREE.getMessage() + WinningType.FIRST.getCount() + "개");
        System.out.println(PrizeComment.SAME_FOUR.getMessage() + WinningType.SECOND.getCount() + "개");
        System.out.println(PrizeComment.SAME_FIVE.getMessage() + WinningType.THIRD.getCount() + "개");
        System.out.println(PrizeComment.SAME_FIVE_PLUS_BONUS.getMessage() + WinningType.FOURTH_BONUS.getCount() + "개");
        System.out.println(PrizeComment.SAME_SIX.getMessage() + WinningType.FIFTH.getCount() + "개");
    }

    public static void outputProfit(int inputMoney) {
        System.out.println("총 수익률은 " + CheckWinning.calculateProfit(inputMoney) + "%입니다.");
    }

}