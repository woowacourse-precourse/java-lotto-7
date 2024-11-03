package lotto.Console;

import java.util.List;
import lotto.CheckWinning;
import lotto.Lotto;
import lotto.enums.WinningType;

public class OutputConsole {

    public static void outputLottoList(List<Lotto> lottoList){
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void outputWinningStatics(Lotto winningLottoNumbers, List<Lotto> lottoList, int bonusNum){
        System.out.println("\n당첨 통계");
        System.out.println("---");

        CheckWinning.checkDuplicateNum(winningLottoNumbers, lottoList, bonusNum);
        System.out.println("3개 일치 (5,000원) - " + WinningType.FIRST.getCount() + "개");
        System.out.println("4개 일치 (50,000원) - " + WinningType.SECOND.getCount() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + WinningType.THIRD.getCount() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + WinningType.FOURTH_BONUS.getCount() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + WinningType.FIFTH.getCount() + "개");
    }

    public static void outputProfit(int inputMoney){
        System.out.println("총 수익률은 " + CheckWinning.calculateProfit(inputMoney) + "%입니다.");
    }

}