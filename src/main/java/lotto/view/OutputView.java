package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.MatchingRecord;

public class OutputView {
    private static final String NUMBER_OF_PURCHASED_LOTTOES_OUTPUT_GUIDE = "개를 구매했습니다.";
    private static final String WINNING_STATISTICS = "당첨 통계\n" + "---";

    public static void printPurchasedLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + NUMBER_OF_PURCHASED_LOTTOES_OUTPUT_GUIDE);
        lottos.stream().forEach(lotto -> System.out.println(lotto.toString()));
    }

    public static void printWinningStatistics(List<MatchingRecord> matchingRecords) {
        System.out.println("\n" + WINNING_STATISTICS);
        for (MatchingRecord matchingRecord : matchingRecords) {
            StringBuilder sb = new StringBuilder();
            sb.append(matchingRecord.getRank().getMatchCount() + "개 일치");
            if (matchingRecord.getRank().getPrizeMoney() == 30_000_000) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (" + NumberFormat.getInstance().format(matchingRecord.getRank().getPrizeMoney()) + "원" + ") - "
                    + matchingRecord.getLottoQuantity() + "개");
            System.out.println(sb);
        }
    }

    public static void printEarningsRate(double earningRates) {
        System.out.println("총 수익률은 " + String.format("%.1f", earningRates) + "%입니다.");
    }
}
