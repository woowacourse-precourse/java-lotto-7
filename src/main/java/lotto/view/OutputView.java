package lotto.view;

import lotto.model.dto.LottoNumbers;
import lotto.model.dto.ResultStatistics;

public class OutputView {
    private static final String ERROR_MESSAGE = "[ERROR] ";
    private static final String PURCHASE_MESSAGE = "개를 구매했습니다.";
    private static final String RESULT_MESSAGE = "당첨 통계";
    private static final String DIVIDER = "---";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printLottoCount(final int count) {
        System.out.println(System.lineSeparator() + count + PURCHASE_MESSAGE);
    }

    public void printLottoNumbers(final LottoNumbers lottoNumbers) {
        System.out.println(lottoNumbers.getLottoNumbers());
    }

    public void printErrorMessage(final String message) {
        System.out.println(ERROR_MESSAGE + message);
    }

    public void printLottoResult(final ResultStatistics resultStatistics) {
        System.out.println(System.lineSeparator() + RESULT_MESSAGE + System.lineSeparator() + DIVIDER);
        resultStatistics.getStatistics().forEach((rank, count) -> {
            System.out.printf("%s - %d개%s", rank.getMessage(), count, System.lineSeparator());
        });
    }

    public void printProfit(final double profit) {
        System.out.printf(PROFIT_MESSAGE, profit);
    }
}
