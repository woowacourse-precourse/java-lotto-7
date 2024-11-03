package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoResult;
import lotto.model.Lottos;

public class OutputView {

    public static final String BUY_AMOUNT_MESSAGE_POSTFIX = "개를 구매했습니다.";
    private static final String FIFTH_PRIZE_FORMAT = "3개 일치 (5,000원) - %d개\n";
    private static final String FOURTH_PRIZE_FORMAT = "4개 일치 (50,000원) - %d개\n";
    private static final String THIRD_PRIZE_FORMAT = "5개 일치 (1,500,000원) - %d개\n";
    private static final String SECOND_PRIZE_FORMAT = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n";
    private static final String FIRST_PRIZE_FORMAT = "6개 일치 (2,000,000,000원) - %d개\n";
    private static final String EARNING_RATE_FORMAT = "총 수익률은 %,.1f%%입니다.\n";

    public void printLottos(Lottos lottos) {
        System.out.println("\n" + lottos.size() + BUY_AMOUNT_MESSAGE_POSTFIX);
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers().toString());
        }
    }

    public void printLottoResult(LottoResult lottoResult) {
        List<LottoRank> lottoRanks = lottoResult.getLottoRanks();
        Map<LottoRank, Long> rankCount = lottoRanks.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        String builtLottoResult = buildLottoResult(rankCount, lottoResult.getEarningRate());
        System.out.println(builtLottoResult);
    }

    private String buildLottoResult(Map<LottoRank, Long> count, double earningRate) {
        return new StringBuilder()
                .append(String.format(FIFTH_PRIZE_FORMAT, count.getOrDefault(LottoRank.FIFTH_PRIZE, 0L)))
                .append(String.format(FOURTH_PRIZE_FORMAT, count.getOrDefault(LottoRank.FOURTH_PRIZE, 0L)))
                .append(String.format(THIRD_PRIZE_FORMAT, count.getOrDefault(LottoRank.THIRD_PRIZE, 0L)))
                .append(String.format(SECOND_PRIZE_FORMAT, count.getOrDefault(LottoRank.SECOND_PRIZE, 0L)))
                .append(String.format(FIRST_PRIZE_FORMAT, count.getOrDefault(LottoRank.FIRST_PRIZE, 0L)))
                .append(String.format(EARNING_RATE_FORMAT, earningRate))
                .toString();
    }
}
