package lotto.view;

import lotto.MatchType;

public class OutputView {
    private final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.";
    private final String STATISTIC_START = "당첨 통계\n---";
    private final String STATISTIC_MATCH_TYPE_MESSAGE = "%d개 일치 (%,d원) - %d개";
    private final String STATISTIC_BONUS_MATCH_TYPE_MESSAGE = "5개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private final String STATISTIC_TOTAL_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printPurchase(int purchase) {
        System.out.println(String.format(PURCHASE_MESSAGE, purchase));
    }

    public void printStatisticStart() {
        System.out.println(STATISTIC_START);
    }

    public void printStatisticMatchType(MatchType matchType, int total) {
        if (matchType == MatchType.FIVE_BONUS) {
            System.out.println(String.format(STATISTIC_BONUS_MATCH_TYPE_MESSAGE, matchType.getPrise(), total));
        }
        if (matchType == MatchType.SIX_MATCHES || matchType == MatchType.FIVE_MATCHES ||
                matchType == MatchType.FOUR_MATCHES || matchType == MatchType.THREE_MATCHES) {
            System.out.println(
                    String.format(STATISTIC_MATCH_TYPE_MESSAGE, matchType.getMatchCount(), matchType.getPrise(),
                            total));
        }
    }

    public void printLottoNumbers(String numbers) {
        System.out.println(numbers);
    }

    public void printTotalRatio(double ratio) {
        System.out.println(String.format(STATISTIC_TOTAL_MESSAGE, ratio));
    }
}
