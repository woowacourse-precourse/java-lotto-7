package lotto.view;

import lotto.domain.AutoLotto;
import lotto.domain.rule.WinningRules;
import lotto.view.messages.OutputMessages;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void lottoCount(long lottoCount) {
        System.out.println();
        System.out.printf(OutputMessages.LOTTO_COUNT_MESSAGE + "%n", lottoCount);
    }

    public void lottos(List<AutoLotto> autoLottoList) {
        autoLottoList.stream()
                .map(AutoLotto::getNumbers)
                .forEach(System.out::println);
    }

    public void error(String error) {
        System.out.printf(OutputMessages.ERROR_MESSAGE + "%n", error);
    }

    public void winningResult(Map<WinningRules, Long> results) {
        DecimalFormat currencyFormat = new DecimalFormat("#,###");
        winningStatisticsStart();
        for (WinningRules rank : WinningRules.values()) {
            if (rank != WinningRules.NO_MATCH) {
                System.out.printf(OutputMessages.MATCH_RESULT_MESSAGE + "%n",
                        rank.getMatchCount(),
                        rank == WinningRules.FIVE_MATCH_WITH_BONUS ? OutputMessages.BONUS_BALL_MATCH : "",
                        currencyFormat.format(rank.getPrize()),
                        results.getOrDefault(rank, 0L));
            }
        }
    }

    public void winningStatisticst(float winningStatistics) {
        System.out.printf(OutputMessages.WINNING_STATISTICS_MESSAGE + "%n", winningStatistics);
    }

    private void winningStatisticsStart() {
        System.out.println();
        System.out.println(OutputMessages.WINNING_STATISTICS_START_MESSAGE);
        System.out.println(OutputMessages.WINNING_STATISTICS_SEPARATOR);
    }
}
