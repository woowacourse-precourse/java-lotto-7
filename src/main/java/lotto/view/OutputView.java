package lotto.view;

import lotto.domain.LottoMatchType;
import lotto.domain.Lotto;

import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String LOTTO_NUMBERS_DELIMITER = ", ";
    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTTO_NUMBERS_SUFFIX = "]\n";
    private static final String MATCH_STATISTICS_MESSAGE = "\n당첨 통계\n---";
    private static final String MATCH_STATISTICS_FORMAT = "%d개 일치 (%,d원) - %d개\n";
    private static final String MATCH_STATISTICS_BONUS_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.\n";

    public void printPurchaseMessage(int lottoCount) {
        System.out.printf(PURCHASE_MESSAGE, lottoCount);
    }

    public void printLottos(List<Lotto> lottos) {
        lottos.forEach(this::printLotto);
        System.out.println();
    }

    private void printLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        StringJoiner result = new StringJoiner(LOTTO_NUMBERS_DELIMITER, LOTTO_NUMBERS_PREFIX, LOTTO_NUMBERS_SUFFIX);
        numbers.forEach(number -> result.add(String.valueOf(number)));
        System.out.print(result);
    }

    public void printMatchStatistics(Map<LottoMatchType, Integer> matchResult) {
        System.out.println(MATCH_STATISTICS_MESSAGE);
        matchResult.forEach(this::printMatchType);
    }

    private void printMatchType(LottoMatchType matchType, int count) {
        if (matchType != LottoMatchType.NONE) {
            System.out.printf(findMessageFormatByBonus(matchType),
                    matchType.getMatchCount(), matchType.getWinningPrice(), count);
        }
    }

    private String findMessageFormatByBonus(LottoMatchType matchType) {
        if (matchType.hasBonus()) {
            return MATCH_STATISTICS_BONUS_FORMAT;
        }
        return MATCH_STATISTICS_FORMAT;
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_FORMAT, profitRate);
    }
}
