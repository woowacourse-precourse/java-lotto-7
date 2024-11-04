package lotto.infrastructure.format;

import static lotto.infrastructure.constants.AnnounceMessages.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.application.dto.response.EvaluateWinningLottoResponse;
import lotto.application.dto.response.PurchaseLottoResponse;
import lotto.application.dto.response.Response;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.vo.LottoPrize;

public class LottoFormatter {

    private static final String NEW_LINE = "\n";
    private static final String NUMBER_FORMAT = "%,d";
    private static final int ROUNDING_FACTOR = 100;
    private static final double ROUNDING_DIVISOR = 100.0;

    public String format(Response response) {
        if (response instanceof PurchaseLottoResponse) {
            return formatPurchaseLottoResponse((PurchaseLottoResponse) response);
        }
        if (response instanceof EvaluateWinningLottoResponse) {
            return formatEvaluateWinningLottoResponse((EvaluateWinningLottoResponse) response);
        }
        return response.toString();
    }

    private String formatPurchaseLottoResponse(PurchaseLottoResponse response) {
        return String.format(PURCHASE_LOTTO_FORMAT.getMessage(), response.lottoCount())
            + formatLottos(response.lottos())
            + NEW_LINE;
    }

    private String formatLottos(List<Lotto> lottos) {
        return lottos.stream()
            .map(Lotto::toString)
            .collect(Collectors.joining(NEW_LINE));
    }

    private String formatEvaluateWinningLottoResponse(EvaluateWinningLottoResponse response) {
        StringBuilder result = new StringBuilder();
        result.append(HEADER.getMessage());

        appendWinningStatistics(result, response.winningResult());
        result.append(String.format(TOTAL_EARNING_RATE_FORMAT.getMessage(),
            roundEarningRate(response.earningRate())));

        return result.toString();
    }

    private void appendWinningStatistics(
        StringBuilder result,
        Map<LottoPrize, Integer> winningResult
    ) {
        winningResult.entrySet().stream()
            .filter(entry -> entry.getKey() != LottoPrize.LOSE)
            .forEach(entry -> appendPrizeStatistics(result, entry.getKey(), entry.getValue()));
    }

    private void appendPrizeStatistics(
        StringBuilder result,
        LottoPrize prize,
        int count
    ) {
        String formattedPrizeMoney = formatPrizeAmount(prize.getPrizeAmount());
        String message = (prize == LottoPrize.SECOND)
            ? BONUS_STATISTIC_FORMAT.getMessage()
            : STATISTIC_FORMAT.getMessage();
        result.append(
            String.format(message, prize.getMatchingNumberCount(), formattedPrizeMoney, count));
    }

    private String formatPrizeAmount(long prizeAmount) {
        return String.format(NUMBER_FORMAT, prizeAmount);
    }

    private double roundEarningRate(double earningRate) {
        return Math.round(earningRate * ROUNDING_FACTOR) / ROUNDING_DIVISOR;
    }
}
