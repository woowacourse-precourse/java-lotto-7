package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoRank;

public class OutputView {

    private static final String OUTPUT_PURCHASED_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String OUTPUT_LOTTO_RESULT_MESSAGE = "당첨 통계\n---";
    private static final String OUTPUT_PURCHASE_AMOUNT_FORMATTER = "#,###";
    private static final String OUTPUT_MATCH_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개\n";
    private static final String OUTPUT_SECOND_MATCH_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String OUTPUT_STATISTICS_RESULT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printPurchasedLotto(int purchaseCount, List<Lotto> purchasedLottoList) {
        System.out.println(purchaseCount + OUTPUT_PURCHASED_COUNT_MESSAGE);
        for (Lotto lotto : purchasedLottoList) {
            System.out.print(lotto);
        }
        System.out.println();
    }

    public void printLottoResult(Map<LottoRank, Integer> lottoResult, double lottoResultStatistics) {
        DecimalFormat formatter = new DecimalFormat(OUTPUT_PURCHASE_AMOUNT_FORMATTER);
        System.out.println(OUTPUT_LOTTO_RESULT_MESSAGE);
        LottoRank[] lottoRanks = LottoRank.values();

        for (int i = lottoRanks.length - 1; i >= 0; i--) {
            LottoRank lottoRank = lottoRanks[i];
            Integer matchCount = lottoResult.get(lottoRank);
            if (matchCount == null) {
                matchCount = 0;
            }
            printMatchResult(lottoRank, matchCount, formatter);
        }

        System.out.printf(OUTPUT_STATISTICS_RESULT_MESSAGE, lottoResultStatistics);
    }

    private void printMatchResult(LottoRank lottoRank, Integer matchCounts, DecimalFormat formatter) {
        if (lottoRank == LottoRank.SECOND) {
            System.out.printf(OUTPUT_SECOND_MATCH_RESULT_MESSAGE, lottoRank.getMatchNumbers(),
                    formatter.format(lottoRank.getPrizeAmount()), matchCounts);
        }
        if (!(lottoRank == LottoRank.SECOND)) {
            System.out.printf(OUTPUT_MATCH_RESULT_MESSAGE, lottoRank.getMatchNumbers(),
                    formatter.format(lottoRank.getPrizeAmount()), matchCounts);
        }
    }
}
