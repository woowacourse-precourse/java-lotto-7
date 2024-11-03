package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Revenue;
import lotto.dto.WinningSummary;
import lotto.exception.LottoException;

public class OutputView {
    private final static String NEW_LINE = System.lineSeparator();
    private final static String INFORM_PURCHASE_LOTTO_MESSAGE = "%d개를 구매했습니다.";
    private final static String WINNING_STATISTICS_TITLE = "당첨 통계";
    private final static String SEPARATOR = "---";
    private final static String RETURN_RATE_STAT = "총 수익률은 %.1f%%입니다.";


    public static void printNewLine() {
        System.out.print(NEW_LINE);
    }

    public static void printPurchaseMessage(int lottoQuantity) {
        printNewLine();
        System.out.printf(INFORM_PURCHASE_LOTTO_MESSAGE, lottoQuantity);
        printNewLine();
    }

    public static void printLottoExceptionMessage(LottoException e) {
        System.out.println(e.getMessage() + System.lineSeparator());
    }

    public static void printLottoGroup(List<Lotto> lottoGroup) {
        lottoGroup.forEach(lotto -> {
            System.out.println(lotto.getNumbers());
        });
        printNewLine();
    }

    public static void printWinningStatsTitle() {
        System.out.println(WINNING_STATISTICS_TITLE);
        System.out.println(SEPARATOR);
    }

    public static void printWinningSummary(WinningSummary winningSummary) {
        winningSummary.winningDetails()
                .forEach(System.out::println);
    }

    public static void printReturnRate(Revenue revenue) {
        System.out.printf(RETURN_RATE_STAT, revenue.getReturnRate());
    }
}
