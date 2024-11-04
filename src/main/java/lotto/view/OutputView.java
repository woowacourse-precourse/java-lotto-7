package lotto.view;

import java.text.NumberFormat;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.controller.response.LottoIssuingResponse;
import lotto.controller.response.LottoIssuingResponse.LottoDto;
import lotto.model.Winning;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_RESULT_MESSAGE = "%d개 일치%s (%s원) - %d개\n";
    private static final String LOTTO_DELIMITER = ", ";

    public void printLottoTickets(LottoIssuingResponse response) {
        System.out.println();
        System.out.println(response.quantity() + PURCHASE_MESSAGE);
        response.lottoTickets().forEach(this::printAscLotto);
    }

    private void printAscLotto(LottoDto lotto) {
        System.out.print("[");

        String lottoResult = lotto.lotto().stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(LOTTO_DELIMITER));

        System.out.print(lottoResult);
        System.out.println("]");
    }

    public void printWinningResult(Map<Winning, Integer> winningResults) {
        NumberFormat formatter = NumberFormat.getInstance();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        Winning.sortedByMatchCount().forEach(winning -> {
            if (winning == Winning.NONE) {
                return;
            }
            String bonusNumberMessage = "";
            if (winning.isBonusNumberMatched()) {
                bonusNumberMessage = ", 보너스 볼 일치";
            }
            System.out.printf(
                    WINNING_RESULT_MESSAGE,
                    winning.matchCount(),
                    bonusNumberMessage,
                    formatter.format(winning.prizeMoney()),
                    winningResults.getOrDefault(winning, 0)
            );
        });
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }
}
