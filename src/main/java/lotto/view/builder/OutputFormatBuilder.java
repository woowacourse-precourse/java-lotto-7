package lotto.view.builder;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.model.lotto.Lotto;
import lotto.model.lotto.Lottos;
import lotto.model.lottoresult.LottoRank;
import lotto.model.lottoresult.LottoResult;

public class OutputFormatBuilder {
    private static final String BUY_AMOUNT_FORMAT = "\n%,d개를 구매했습니다.\n";
    private static final String LOTTO_RESULT_PREFIX = "\n당첨 통계\n---\n";
    private static final String FIFTH_PRIZE_FORMAT = "3개 일치 (5,000원) - %,d개\n";
    private static final String FOURTH_PRIZE_FORMAT = "4개 일치 (50,000원) - %,d개\n";
    private static final String THIRD_PRIZE_FORMAT = "5개 일치 (1,500,000원) - %,d개\n";
    private static final String SECOND_PRIZE_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %,d개\n";
    private static final String FIRST_PRIZE_FORMAT = "6개 일치 (2,000,000,000원) - %,d개\n";
    private static final String EARNING_RATE_FORMAT = "총 수익률은 %,.1f%%입니다.";

    private OutputFormatBuilder() {
    }


    public static String buildMyLottos(Lottos lottos) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(BUY_AMOUNT_FORMAT, lottos.size()));
        for (Lotto lotto : lottos.getLottos()) {
            stringBuilder.append(lotto.getNumbers().toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public static String buildLottoResult(LottoResult lottoResult) {
        Map<LottoRank, Long> count = lottoResult.getLottoRanks().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return new StringBuilder()
                .append(LOTTO_RESULT_PREFIX)
                .append(String.format(FIFTH_PRIZE_FORMAT, count.getOrDefault(LottoRank.FIFTH_PRIZE, 0L)))
                .append(String.format(FOURTH_PRIZE_FORMAT, count.getOrDefault(LottoRank.FOURTH_PRIZE, 0L)))
                .append(String.format(THIRD_PRIZE_FORMAT, count.getOrDefault(LottoRank.THIRD_PRIZE, 0L)))
                .append(String.format(SECOND_PRIZE_FORMAT, count.getOrDefault(LottoRank.SECOND_PRIZE, 0L)))
                .append(String.format(FIRST_PRIZE_FORMAT, count.getOrDefault(LottoRank.FIRST_PRIZE, 0L)))
                .append(String.format(EARNING_RATE_FORMAT, lottoResult.getEarningRate()))
                .toString();
    }
}
