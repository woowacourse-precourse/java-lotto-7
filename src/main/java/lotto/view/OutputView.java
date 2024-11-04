package lotto.view;

import java.text.DecimalFormat;
import java.util.Map.Entry;
import java.util.Set;
import lotto.model.draw.DrawResult;
import lotto.model.draw.Prize;
import lotto.model.lotto.LottoTicket;

public class OutputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "%s개를 구매했습니다.";
    private static final String DRAW_STATISTICS_HEADER = "당첨 통계\n---";
    private static final String DRAW_RESULT_DELIMITER = " - ";
    private static final String DRAW_RESULT_UNIT = "개";
    private static final String PROFIT_PERCENTAGE_MESSAGE = "총 수익률은 %s%%입니다.%n";
    private static final String PERCENTAGE_FORMAT_PATTERN = "###,###.#";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottoTicket(LottoTicket lottoTicket, int lottoAmount) {
        println();
        String lottoAmountHeader = String.format(PURCHASE_AMOUNT_MESSAGE, lottoAmount);
        System.out.println(lottoAmountHeader);
        System.out.println(lottoTicket);
    }

    public void printDrawResult(DrawResult drawResult) {
        println();
        System.out.println(DRAW_STATISTICS_HEADER);
        Set<Entry<Prize, Integer>> entries = drawResult.getDrawResult().entrySet();
        for (Entry<Prize, Integer> entry : entries) {
            Prize prize = entry.getKey();
            int count = entry.getValue();
            if(prize.equals(Prize.BLANK)) {
                continue;
            }
            System.out.println(prize.getMessage() + DRAW_RESULT_DELIMITER + count + DRAW_RESULT_UNIT);
        }
    }

    public void printProfitPercentage(double percentage) {
        DecimalFormat decimalFormat = new DecimalFormat(PERCENTAGE_FORMAT_PATTERN);
        String formattedPercentage = decimalFormat.format(percentage);
        System.out.printf(PROFIT_PERCENTAGE_MESSAGE,formattedPercentage);
    }

    public void println() {
        System.out.println();
    }

}
