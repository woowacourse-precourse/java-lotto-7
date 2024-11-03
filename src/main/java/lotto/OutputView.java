package lotto;

import java.util.List;

public class OutputView {


    public void printLottoNumbers(List<List<Integer>> lottos) {
        System.out.println(lottos.size()+"개를 구매했습니다.");
        for (List<Integer> lotto:lottos) {
            System.out.println(lotto);
        }
    }

    public void printReturnOfRate(String rateOfReturn) {
        System.out.printf("총 수익률은 %s%%입니다.", rateOfReturn);
        System.out.println();
    }

    public void printPrizeResults() {
        for (int i = WinningPrize.values().length - 1; i >= 0; i--) {
            WinningPrize prize = WinningPrize.values()[i];
            if (prize.bonusCount == 0) {
                printPrizeMatch(prize);
            }
            if (prize.bonusCount == 1) {
                printBonusMatch(prize);
            }
        }
    }

    public void printPrizeMatch(WinningPrize prize) {
        System.out.printf("%d개 일치 (%s원) - %d개%n",prize.winningCount,printChangeMoneyBar(prize),prize.totalCount);


    }

    public void printBonusMatch(WinningPrize prize) {
        System.out.printf(
                "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",prize.winningCount,printChangeMoneyBar(prize),prize.totalCount);
    }


    public String printChangeMoneyBar(WinningPrize prize) {
        return String.format("%,d",prize.prizeMoney);
    }
}
