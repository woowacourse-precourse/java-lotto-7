package lotto.view;

import java.text.NumberFormat;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.controller.response.LottoIssuingResponse;
import lotto.controller.response.LottoIssuingResponse.LottoDto;
import lotto.model.Winning;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String LOTTO_PREFIX = "[";
    private static final String LOTTO_POSTFIX = "]";

    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String WINNING_RESULT_MESSAGE = "%d개 일치%s (%s원) - %d개\n";
    private static final String BONUS_NUMBER_MATCHED_CONDITION_MESSAGE = ", 보너스 볼 일치";
    
    private static final String RATE_OF_RETURN_MESSAGE = "총 수익률은 %.1f%%입니다.";

    private static final String LOTTO_DELIMITER = ", ";

    private static final int DEFAULT_COUNT = 0;

    public void printLottoTickets(LottoIssuingResponse response) {
        System.out.println();
        System.out.println(response.quantity() + PURCHASE_MESSAGE);
        response.lottoTickets().forEach(this::printAscLotto);
    }

    private void printAscLotto(LottoDto lotto) {
        System.out.print(LOTTO_PREFIX);

        String lottoResult = lotto.lotto().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_DELIMITER));

        System.out.print(lottoResult);
        System.out.println(LOTTO_POSTFIX);
    }

    public void printWinningResult(Map<Winning, Integer> winningResults) {
        NumberFormat formatter = NumberFormat.getInstance();
        System.out.println();
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDER);
        Winning.sortedByMatchCount().forEach(winning -> {
            if (winning == Winning.NONE) {
                return;
            }
            String bonusNumberMessage = "";
            if (winning.isBonusNumberMatched()) {
                bonusNumberMessage = BONUS_NUMBER_MATCHED_CONDITION_MESSAGE;
            }
            System.out.printf(
                    WINNING_RESULT_MESSAGE,
                    winning.matchCount(),
                    bonusNumberMessage,
                    formatter.format(winning.prizeMoney()),
                    winningResults.getOrDefault(winning, DEFAULT_COUNT)
            );
        });
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN_MESSAGE, rateOfReturn);
    }
}
