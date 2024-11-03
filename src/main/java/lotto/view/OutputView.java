package lotto.view;

import lotto.view.response.*;

import java.util.stream.Collectors;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.%n";
    private static final String LOTTO_NUMBERS_PREFIX = "[";
    private static final String LOTTO_NUMBERS_FORMAT = ", ";
    private static final String LOTTO_NUMBERS_SUFFIX = "]";

    private static final String MATCH_RESULT_HEADER = "\n당첨 통계\n";
    private static final String MATCH_RESULT_DIVIDER = "---\n";
    private static final String MATCH_RESULT_FORMAT = "%d개 일치%s (%,d원) - %d개";
    private static final String BONUS_MATCH = ", 보너스 볼 일치";
    private static final String EMPTY = "";

    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public void printPurchasedLottos(PurchaseLottoResponse response) {
        System.out.printf(PURCHASE_MESSAGE, response.getPurchasedAmount());
        response.getLottoNumberResponses().forEach(this::printLotto);
    }

    public void printScores(LottoScoreResponses response) {
        System.out.printf(MATCH_RESULT_HEADER);
        System.out.printf(MATCH_RESULT_DIVIDER);
        response.getLottoScoreResponses().forEach(this::printScore);
    }

    private void printScore(LottoScoreResponse lottoScoreResponse, Integer count) {
        int matchCount = lottoScoreResponse.getMatchCount();
        if (matchCount == 0) {
            return;
        }
        boolean isBonusMatch = lottoScoreResponse.containsBonus();
        int prize = lottoScoreResponse.getPrize();

        String result = String.format(MATCH_RESULT_FORMAT,
                matchCount,
                isBonusMatch ? BONUS_MATCH : EMPTY,
                prize,
                count);
        System.out.println(result);
    }

    public void printProfitRate(LottoProfitResponse response) {
        System.out.printf(PROFIT_RATE_MESSAGE, response.getProfitRate());
    }

    private void printLotto(LottoNumberResponse response) {
        System.out.println(response.getLottoNumbers().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBERS_FORMAT, LOTTO_NUMBERS_PREFIX, LOTTO_NUMBERS_SUFFIX)));
    }
}

