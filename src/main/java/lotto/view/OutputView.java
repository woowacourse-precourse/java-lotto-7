package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    private static final String PURCHASED_LOTTO = "%d개를 구매했습니다.%n";
    private static final String WIN_STATISTICS = "당첨 통계" + System.lineSeparator() + "---";
    private static final String WIN_STATISTICS_DETAIL = "%s - %d개%n";
    private static final String PROFIT_RATE = "총 수익률은 %.1f%%입니다.";


    public static void printPurchasedLottoAmount(int lottoNumber) {
        System.out.printf(PURCHASED_LOTTO, lottoNumber);
    }

    public static void printPurchasedLottoNumbers(List<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            System.out.println(lotto.toString());
        }
    }
    public static void printWinStatistics() {
        System.out.println(WIN_STATISTICS);
    }

    public static void printWinStatisticsDetail(String message, int winCount) {
        System.out.printf(WIN_STATISTICS_DETAIL, message, winCount);
    }

    public static void printProfitRate(float profitRate) {
        System.out.printf(PROFIT_RATE, profitRate);
    }

}
