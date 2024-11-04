package lotto.view;

import java.util.List;
import lotto.constants.PrizeRank;
import lotto.model.LottoGameResult;
import lotto.model.LottoPurchaseResult;

public class ResultFormatter {
    // LottoPurchaseResult 상수
    private static final String AMOUNT_POSTFIX = "개를 구매했습니다.";

    // LottoGameResult 상수
    private static final String LOTTO_GAME_RESULT_TITLE = "당첨 통계\n---\n";
    private static final String PRIZE_COUNT_POSTFIX = "개";
    private static final String PROFIT_PREFIX = "총 수익률은 ";
    private static final String PROFIT_POSTFIX = "%입니다.";

    private static final String NEW_LINE = "\n";

    public String formatLottoPurchaseResult(LottoPurchaseResult lottoPurchaseResult) {
        StringBuilder formattedResult = new StringBuilder();

        formattedResult.append(formatAmount(lottoPurchaseResult.amount()));
        lottoPurchaseResult.lottoTicketsNumbers().forEach(numbers ->
                formattedResult.append(formatNumbers(numbers))
        );

        return formattedResult.toString();
    }

    public String formatLottoGameResult(LottoGameResult lottoGameResult) {
        StringBuilder formattedResult = new StringBuilder();

        formattedResult.append(LOTTO_GAME_RESULT_TITLE);
        lottoGameResult.prizeResultMap().forEach(((prizeRank, count) -> {
            formattedResult.append(formatPrizeRankAndCount(prizeRank, count));
        }));
        formattedResult.append(formatProfitRate(lottoGameResult.profitRate()));

        return formattedResult.toString();
    }

    private String formatAmount(int amount) {
        return amount + AMOUNT_POSTFIX + NEW_LINE;
    }

    private String formatNumbers(List<Integer> numbers) {
        return numbers.toString() + NEW_LINE;
    }

    private String formatPrizeRankAndCount(PrizeRank prizeRank, Integer count) {
        return prizeRank.getMessage() + count + PRIZE_COUNT_POSTFIX + NEW_LINE;
    }

    private String formatProfitRate(double profitRate) {
        return PROFIT_PREFIX + profitRate + PROFIT_POSTFIX;
    }
}
