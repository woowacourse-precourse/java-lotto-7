package lotto.infrastructure.format;


import static lotto.infrastructure.constants.AnnounceMessages.*;

import java.util.List;
import java.util.Map;
import lotto.application.dto.response.EvaluateWinningLottoResponse;
import lotto.application.dto.response.PurchaseLottoResponse;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.vo.LottoPrize;
import lotto.infrastructure.constants.AnnounceMessages;

public class LottoFormatter {

    private static final String NEW_LINE = "\n";
    private static final String NUMBER_FORMAT = "%,d";
    private static final int NONE = 0;

    public String format(PurchaseLottoResponse response) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(PURCHASE_LOTTO_FORMAT.getMessage(), response.lottoCount()));

        List<Lotto> lottos = response.lottos();
        for (Lotto lotto : lottos) {
            sb.append(formatLotto(lotto)).append(NEW_LINE);
        }

        return sb.toString();
    }

    private String formatLotto(Lotto lotto) {
        return lotto.getNumbers().toString();
    }

    public String format(EvaluateWinningLottoResponse response) {
        StringBuilder result = new StringBuilder();
        result.append(AnnounceMessages.HEADER);

        appendWinningStatistics(result, response.winningResult());

        result.append(String.format(TOTAL_EARNING_RATE_FORMAT.getMessage(), roundEarningRate(response.earningRate())));

        return result.toString();
    }

    private void appendWinningStatistics(StringBuilder result,
        Map<LottoPrize, Integer> winningResult) {
        for (LottoPrize prize : LottoPrize.values()) {
            appendPrizeStatistics(result, prize, winningResult.getOrDefault(prize, NONE));
        }
    }

    private void appendPrizeStatistics(StringBuilder result, LottoPrize prize, int count) {
        String formattedPrizeMoney = formatPrizeMoney(prize.getPrizeAmount());

        if (prize == LottoPrize.LOSE) {
            return;
        }

        if (prize == LottoPrize.SECOND) {
            result.append(
	String.format(BONUS_STATISTIC_FORMAT.getMessage(), prize.getMatchingNumberCount(), formattedPrizeMoney, count));
            return;
        }

        result.append(
            String.format(STATISTIC_FORMAT.getMessage(), prize.getMatchingNumberCount(), formattedPrizeMoney, count)
        );
    }

    private String formatPrizeMoney(long prizeMoney) {
        return String.format(NUMBER_FORMAT, prizeMoney);
    }

    private double roundEarningRate(double earningRate) {
        return Math.round(earningRate * 100) / 100.0;
    }
}
