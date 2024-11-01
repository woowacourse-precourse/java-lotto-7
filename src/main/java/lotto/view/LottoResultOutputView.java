package lotto.view;

import java.text.DecimalFormat;
import java.util.Map;
import lotto.model.Rank;

public class LottoResultOutputView {
    private static final String LOTTO_RESULT_OUTPUT_GUIDE = "\n당첨 통계\n---";
    private static final String LOTTO_RESULT_MESSAGE_FORMAT = "%d개 일치 (%s원) - %d개\n";
    private static final String LOTTO_RESULT_WITH_BONUS_MESSAGE_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String NUMBER_WITH_COMMA_PATTERN = "#,###";

    private final DecimalFormat decimalFormat = new DecimalFormat(NUMBER_WITH_COMMA_PATTERN);

    public void printLottoResultOutputGuide() {

        System.out.println(LOTTO_RESULT_OUTPUT_GUIDE);
    }

    public void printLottoResult(Map<Rank, Integer> lottoResult) {
        for (Map.Entry<Rank, Integer> entry : lottoResult.entrySet()) {
            printLottoResultByRank(entry.getKey(), entry.getValue());
        }
    }

    private void printLottoResultByRank(Rank rank, int rankCount) {
        if (rank.equals(Rank.NONE)) {
            return;
        }

        String rankReward = decimalFormat.format(rank.reward);

        if (rank.equals(Rank.SECOND)) {
            System.out.printf(LOTTO_RESULT_WITH_BONUS_MESSAGE_FORMAT, rank.duplicatedCount, rankReward, rankCount);
            return;
        }
        System.out.printf(LOTTO_RESULT_MESSAGE_FORMAT, rank.duplicatedCount, rankReward, rankCount);
    }
}
