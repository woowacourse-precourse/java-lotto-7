package lotto;

import java.util.List;

public class OutputView {
    private static final String PRINT_BUY_LOTTO = "개를 구매했습니다.";
    private static final String PRINT_RATE_OF_RETURN = "총 수익률은 %s%%입니다.";
    private static final String PRINT_PRIZE_MATCH = "%d개 일치 (%s원) - %d개%n";
    private static final String PRINT_BONUS_MATCH = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";


    public void printLottoNumbers(List<List<Integer>> lottos) {
        System.out.println(lottos.size()+PRINT_BUY_LOTTO);
        for (List<Integer> lotto:lottos) {
            System.out.println(lotto);
        }
    }

    public void printRateOfReturn(String rateOfReturn) {
        System.out.printf(PRINT_RATE_OF_RETURN, rateOfReturn);
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
        System.out.printf(PRINT_PRIZE_MATCH,prize.winningCount,printChangeMoneyBar(prize),prize.totalCount);
    }

    public void printBonusMatch(WinningPrize prize) {
        System.out.printf(
                PRINT_BONUS_MATCH,prize.winningCount,printChangeMoneyBar(prize),prize.totalCount);
    }

    public String printChangeMoneyBar(WinningPrize prize) {
        return String.format("%,d",prize.prizeMoney);
    }
}
