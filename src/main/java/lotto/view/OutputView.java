package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.WinningPrize;

public class OutputView {
    private static final String PRINT_BUY_LOTTO = "개를 구매했습니다.";
    private static final String PRINT_RATE_OF_RETURN = "총 수익률은 %s%%입니다.";
    private static final String PRINT_PRIZE_MATCH = "%d개 일치 (%s원) - %d개%n";
    private static final String PRINT_BONUS_MATCH = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";

    private int totalMoney = 0;

    public void printLottoNumbers(List<List<Integer>> lottos) {
        System.out.println(lottos.size() + PRINT_BUY_LOTTO);
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printRateOfReturn(String rateOfReturn) {
        System.out.printf(PRINT_RATE_OF_RETURN, rateOfReturn);
        System.out.println();
    }

    public void printPrizeResults(Map<WinningPrize, Integer> rank) {
        for (int i = WinningPrize.values().length - 1; i >= 0; i--) {
            WinningPrize prize = WinningPrize.values()[i];
            if (prize.bonusCount == 0) {
                printPrizeMatch(prize, rank);
            }
            if (prize.bonusCount == 1) {
                printBonusMatch(prize, rank);
            }
        }
    }

    private void printPrizeMatch(WinningPrize prize, Map<WinningPrize, Integer> rank) {
        if (rank.get(prize) != null) {
            totalMoney += prize.getMoney() * rank.get(prize);
            System.out.printf(PRINT_PRIZE_MATCH, prize.winningCount, printChangeMoneyBar(prize), rank.get(prize));
        }
        if (rank.get(prize) == null) {
            System.out.printf(PRINT_PRIZE_MATCH, prize.winningCount, printChangeMoneyBar(prize), 0);
        }
    }

    private void printBonusMatch(WinningPrize prize, Map<WinningPrize, Integer> rank) {
        if (rank.get(prize) != null) {
            totalMoney += prize.getMoney() * rank.get(prize);
            System.out.printf(PRINT_BONUS_MATCH, prize.winningCount, printChangeMoneyBar(prize), rank.get(prize));
        }
        if (rank.get(prize) == null) {
            System.out.printf(PRINT_BONUS_MATCH, prize.winningCount, printChangeMoneyBar(prize), 0);
        }
    }

    public int totalMoney() {
        return totalMoney;
    }

    private String printChangeMoneyBar(WinningPrize prize) {
        return String.format("%,d", prize.prizeMoney);
    }
}
