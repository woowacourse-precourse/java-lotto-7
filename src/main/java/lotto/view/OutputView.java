package lotto.view;

import lotto.model.LottoResult;

public class OutputView {

    private static final String RESULT_TITLE = "당첨 통계";
    private static final String SEPARATOR = "---";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printResult(LottoResult lottoResults, double profitRate) {
        System.out.println();
        System.out.println(RESULT_TITLE);
        System.out.println(SEPARATOR);
        printLottoPlace(lottoResults);
        printProfitRate(profitRate);
    }

    private void printLottoPlace(LottoResult lottoResults) {
        lottoResults.getLottoRankingSet().reversed().stream().filter(ranking -> !ranking.getMessage().isEmpty()).forEach(ranking -> System.out.println(ranking.getMessage() + " - " + ranking.getWinCount() + "개"));
    }

    private void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_MESSAGE + "%n", profitRate);
    }
}