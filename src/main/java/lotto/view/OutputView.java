package lotto.view;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Prize;
import lotto.domain.PublishLotto;

public class OutputView {

    private static final String WINNING_STAT_MESSAGE = "\n당첨 통계\n---\n";
    private static final String DECIMAL_FORMAT_PATTER = "#,##0.0";

    public void printPublishCountMessage(final int publishCount) {
        System.out.printf("\n%d개를 구매했습니다.\n", publishCount);
    }

    public void printPublishLottos(final List<PublishLotto> publishLottoList) {
        for (PublishLotto publishLotto : publishLottoList) {
            List<Integer> publishLottoNumbers = publishLotto.getPublishLottoNumbers();
            System.out.println("[" + numberFormat(publishLottoNumbers) + "]");
        }
    }

    public void printWinningStatMessage(final Map<Prize, Integer> winningCounts) {
        System.out.printf(WINNING_STAT_MESSAGE);
        for (Prize prize : Prize.values()) {
            System.out.printf("%s (%,d원) - %d개\n", prize.getMessage(), prize.getPrizeAmount(),
                winningCounts.getOrDefault(prize, 0));
        }
    }

    public void printProfit(final BigDecimal profit) {
        String formattedProfit = Profitformat(profit);

        System.out.println("총 수익률은 " + formattedProfit + "%입니다.");
    }

    public static void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    private String numberFormat(final List<Integer> publishLottoNumbers) {
        String numbersString = publishLottoNumbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", "));
        return numbersString;
    }

    private String Profitformat(final BigDecimal profit) {
        DecimalFormat df = new DecimalFormat(DECIMAL_FORMAT_PATTER);
        return df.format(profit);
    }
}
