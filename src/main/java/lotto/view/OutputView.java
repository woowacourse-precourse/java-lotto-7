package lotto.view;

import lotto.dto.GeneratedUserLotto;
import lotto.dto.WinningStatistics;

public class OutputView {
    private static final String PURCHASE_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨통계\n---";
    private static final String RETURN_RATE_MESSAGE = "총 수익률은 %s입니다.";

    public void printCreateLottoInfo(GeneratedUserLotto generatedUserLotto) {
        System.out.println();
        System.out.println(getPurchaseMessageFormat(generatedUserLotto.totalGeneratedLottos()));
        System.out.println(generatedUserLotto.generatedLottoNumbers());
    }

    private String getPurchaseMessageFormat(long quantity) {
        return String.format(PURCHASE_MESSAGE_FORMAT, quantity);
    }

    public void printWinningStatics(WinningStatistics winningStatistics) {
        System.out.println();
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.print(winningStatistics.matchComment());
        System.out.print(String.format(RETURN_RATE_MESSAGE, winningStatistics.returnRate()));
    }

    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }
}
