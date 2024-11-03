package lotto.view;

import static lotto.common.config.InstructionMessages.NUMBER_OF_PURCHASE;

import java.util.List;
import lotto.domain.Lotto;

public class Output {
    private static final String DIVIDER = "\n---";
    private static final String AMOUNT_OF_MATCH = "개 일치";
    private static final String MATCH_BONUS = "보너스 볼 일치";
    private static final String UNIT = "개";
    private static final String CURRENCY = "원";
    private static final String NEW_LINE = "\n";

    public void printLottoNumbers(List<Lotto> lottoNumbers) {
        printMessage(NEW_LINE + lottoNumbers.size() + NUMBER_OF_PURCHASE.getMessage());
        for (Lotto lottoNumber : lottoNumbers) {
            printMessage(String.valueOf(lottoNumber));
        }
    }

//    public void printWinningStatistics(List<> ) {
//        printMessage(WINNING_STATISTICS.getMessage() + DIVIDER);
//    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
