package lotto.view;

import lotto.dto.CreateLottoInfo;
import lotto.dto.WinningStatistics;

public class OutputView {
    private static final String PURCHASE_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨통계\n---";
    private static final String RETURN_RATE_MESSAGE = "총 수익률은 %s입니다.";

    public void printCreateLottoInfo(CreateLottoInfo createLottoInfo) {
        System.out.println();
        System.out.println(getPurchaseMessageFormat(createLottoInfo.lottoCount()));
        System.out.println(createLottoInfo.lottos());
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
}
