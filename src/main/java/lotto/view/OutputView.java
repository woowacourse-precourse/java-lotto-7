package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoRankSummary;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String SIZE_MESSAGE = "개를 구매했습니다.";
    private static final String NEW_LINE = "\n";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String COMMA = ", ";
    private static final String TOTAL_RATE_OF_RETURN_MESSAGE = "총 수익률은 ";
    private static final String PERCENT_SIGN = "%";
    private static final String ITEMS = "개";
    private static final String FINAL_MESSAGE = "입니다.";

    public static void printResult(List<Lotto> lottos, double rateOfReturn, LottoRankSummary lottoRankSummary) {
        System.out.println(makeStatisticsStartMessageString());
        System.out.println(makePurchaseSizeMessageString(lottos.size()));
        System.out.print(makeShowLottoNumberString(lottos));
        System.out.print(makeStatisticsResultString(lottoRankSummary));
        System.out.println(makeRateOfReturnString(rateOfReturn));
    }

    private static String makeStatisticsStartMessageString() {
        return STATISTICS_MESSAGE + NEW_LINE + DIVIDER;
    }

    private static String makePurchaseSizeMessageString(int size) {
        return size + SIZE_MESSAGE;
    }

    private static String makeShowLottoNumberString(List<Lotto> lottos) {
        StringBuilder str = new StringBuilder();
        for (Lotto lotto : lottos) {
            String numbers = String.join(COMMA, lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.toList()));

            str.append(OPEN_BRACKET).append(numbers).append(CLOSE_BRACKET).append(NEW_LINE);
        }
        return str.toString();
    }

    private static String makeStatisticsResultString(LottoRankSummary lottoRankSummary) {
        StringBuilder str = new StringBuilder();
        for (Map.Entry<LottoRank, Integer> entry : lottoRankSummary.getRankCounts().entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            str.append(rank.getMessage()).append(count).append(ITEMS).append(NEW_LINE);
        }
        return str.toString();
    }

    private static String makeRateOfReturnString(double rateOfReturn) {
        return TOTAL_RATE_OF_RETURN_MESSAGE + rateOfReturn + PERCENT_SIGN + FINAL_MESSAGE;
    }
}
