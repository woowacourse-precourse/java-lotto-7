package lotto.view;

import java.util.List;

public class OutputView {

    public static final String PUBLISHED_LOTTO_MSG = "\n%d개를 구매했습니다.";
    public static final String WINNING_PRIZE_MSG = "\n당첨 통계\n---";
    public static final String PROFIT_RATE_MSG = "총 수익률은 %.1f%%입니다.";

    public static void outputPublishedLotto(int lottoCnt, List<List<Integer>> lottosNumbers) {
        String publishedLottoTitle = String.format(PUBLISHED_LOTTO_MSG, lottoCnt);
        System.out.println(publishedLottoTitle);
        for (List<Integer> lottoNumbers : lottosNumbers) {
            System.out.println(lottoNumbers);
        }
    }

    public static void outputWinningPrize(List<String> ranks) {
        System.out.println(WINNING_PRIZE_MSG);
        for (String rank : ranks) {
            System.out.println(rank);
        }
    }

    public static void outputProfitRate(double profitRate) {
        String winningPrizeProfitRate = String.format(PROFIT_RATE_MSG, profitRate);
        System.out.println(winningPrizeProfitRate);
    }

    public static void outputMessage(String message) {
        System.out.println(message);
    }
}
