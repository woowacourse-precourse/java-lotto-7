package lotto.view.output;

import lotto.view.response.*;

import java.util.stream.Collectors;

public class ConsoleOutputView implements OutputView {

    private final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.%n";
    private final String LOTTO_NUMBERS_PREFIX = "[";
    private final String LOTTO_NUMBERS_FORMAT = ", ";
    private final String LOTTO_NUMBERS_SUFFIX = "]";

    private final String MATCH_RESULT_HEADER = "\n당첨 통계\n";
    private final String MATCH_RESULT_DIVIDER = "---\n";
    private final String MATCH_RESULT_FORMAT = "%d개 일치%s (%,d원) - %d개";
    private final String BONUS_MATCH = ", 보너스 볼 일치";
    private final String EMPTY = "";

    private final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    @Override
    public void printPurchasedLottos(PurchaseLottoResponse response) {
        System.out.printf(PURCHASE_MESSAGE, response.getPurchasedAmount());
        response.getLottoNumberResponses().forEach(this::printLotto);
    }

    @Override
    public void printScores(LottoScoreResponses response) {
        System.out.printf(MATCH_RESULT_HEADER);
        System.out.printf(MATCH_RESULT_DIVIDER);
        response.getLottoScoreResponses().forEach(this::printScore);
    }

    @Override
    public void printProfitRate(LottoProfitResponse response) {
        System.out.printf(PROFIT_RATE_MESSAGE, response.getProfitRate());
    }

    private void printScore(LottoScoreResponse lottoScoreResponse, Integer count) {
        int matchCount = lottoScoreResponse.getMatchCount();
        if (matchCount == 0) {
            return;
        }
        boolean isBonusMatch = lottoScoreResponse.containsBonus();
        int prize = lottoScoreResponse.getPrize();

        System.out.println(getResult(matchCount, isBonusMatch, prize, count));
    }

    private String getResult(int matchCount, boolean isBonusMatch, int prize, int count) {
        String bonusMatchMessage = EMPTY;

        if (isBonusMatch) {
            bonusMatchMessage = BONUS_MATCH;
        }

        return String.format(MATCH_RESULT_FORMAT,
                matchCount,
                bonusMatchMessage,
                prize,
                count);
    }

    private void printLotto(LottoNumberResponse response) {
        System.out.println(response.getLottoNumbers().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_NUMBERS_FORMAT, LOTTO_NUMBERS_PREFIX, LOTTO_NUMBERS_SUFFIX)));
    }
}
