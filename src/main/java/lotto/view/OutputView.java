package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

public class OutputView {
    private static final String ISSUED_LOTTO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_TITLE = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String THREE_MATCHES_RESULT = "3개 일치 (5,000원) - %d개\n";
    private static final String FOUR_MATCHES_RESULT = "4개 일치 (50,000원) - %d개\n";
    private static final String FIVE_MATCHES_RESULT = "5개 일치 (1,500,000원) - %d개\n";
    private static final String FIVE_MATCHES_BONUS_MATCH_RESULT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String SIX_MATCHES_RESULT = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String PROFIT_RATE_RESULT = "총 수익률은 %,.1f%%입니다.";

    public void displayIssuedLottos(Lottos lottos) {
        System.out.println(System.lineSeparator() + lottos.getLottos().size() + ISSUED_LOTTO_COUNT_MESSAGE);
        lottos.getLottos().stream()
                .map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public void displayStatistics(Map<Rank, Integer> prizeCount, double profitRate) {
        String result = System.lineSeparator()
                + RESULT_TITLE + System.lineSeparator()
                + DIVIDER + System.lineSeparator()
                + getRankResult(prizeCount)
                + getProfitRateResult(profitRate);
        System.out.println(result);
        Console.close();
    }

    private String getRankResult(Map<Rank, Integer> prizeCount) {
        return String.format(THREE_MATCHES_RESULT, prizeCount.get(Rank.MATCHES_3))
                + String.format(FOUR_MATCHES_RESULT, prizeCount.get(Rank.MATCHES_4))
                + String.format(FIVE_MATCHES_RESULT, prizeCount.get(Rank.MATCHES_5))
                + String.format(FIVE_MATCHES_BONUS_MATCH_RESULT, prizeCount.get(Rank.MATCHES_5_BONUS_MATCH))
                + String.format(SIX_MATCHES_RESULT, prizeCount.get(Rank.MATCHES_6));
    }

    private String getProfitRateResult(double profitRate) {
        return String.format(PROFIT_RATE_RESULT, profitRate);
    }
}
