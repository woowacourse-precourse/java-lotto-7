package lotto.view;

import static lotto.view.InstructionMessages.NUMBER_OF_PURCHASE;
import static lotto.view.InstructionMessages.WINNING_STATISTICS;

import java.util.List;
import java.util.Set;

public class Output {
    private static final String DIVIDER = "---";
    private static final String AMOUNT_OF_MATCH = "개 일치";
    private static final String MATCH_BONUS = "보너스 볼 일치";
    private static final String UNIT = "개";
    private static final String CURRENCY = "원";

    public static void printLottoNumbers(List<Set<Integer>> lottoNumbers, int amount) {
        printMessage(amount + NUMBER_OF_PURCHASE.getMessage());
        for (Set<Integer> lottoNumber : lottoNumbers) {
//            printMessage(String.valueOf(lottoNumber));
            printMessage(lottoNumber.toString());
        }
    }

    public static void printWinningStatistics(List<Integer> amountOfMatches) { // TODO 컬렉션 종류
        printMessage(WINNING_STATISTICS.getMessage());
        for (Integer amountOfMatch : amountOfMatches) {

        }

    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
