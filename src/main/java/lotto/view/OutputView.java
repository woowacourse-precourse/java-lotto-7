package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_PURCHASED_MESSAGE = "\n%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계";
    private static final String WINNING_STATISTICS_DIVIDER = "---";
    private static final String TOTAL_RETURN_RATE_MESSAGE = "총 수익률은 ";
    private static final String PERCENTAGE_MESSAGE = "%입니다.";
    private static final String MATCH_THREE_MESSAGE = "3개 일치 (5,000원) - %d개";
    private static final String MATCH_FOUR_MESSAGE = "4개 일치 (50,000원) - %d개";
    private static final String MATCH_FIVE_MESSAGE = "5개 일치 (1,500,000원) - %d개";
    private static final String MATCH_FIVE_WITH_BONUS_MESSAGE = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String MATCH_SIX_MESSAGE = "6개 일치 (2,000,000,000원) - %d개";

    public static void printNumberOfLottoPurchased(int numberOfLottosPurchased) {
        System.out.printf(NUMBER_OF_LOTTOS_PURCHASED_MESSAGE, numberOfLottosPurchased);
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printStatics(List<Integer> finalMatchNumbers, double rateOfReturn) {
        System.out.println(WINNING_STATISTICS_HEADER);
        System.out.println(WINNING_STATISTICS_DIVIDER);
        System.out.printf((MATCH_THREE_MESSAGE) + "\n", finalMatchNumbers.get(4));
        System.out.printf((MATCH_FOUR_MESSAGE) + "\n", finalMatchNumbers.get(3));
        System.out.printf((MATCH_FIVE_MESSAGE) + "\n", finalMatchNumbers.get(2));
        System.out.printf((MATCH_FIVE_WITH_BONUS_MESSAGE) + "\n", finalMatchNumbers.get(1));
        System.out.printf((MATCH_SIX_MESSAGE) + "\n", finalMatchNumbers.get(0));
        System.out.println(TOTAL_RETURN_RATE_MESSAGE + rateOfReturn + PERCENTAGE_MESSAGE);
    }
}