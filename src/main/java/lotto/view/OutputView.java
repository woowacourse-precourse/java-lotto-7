package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.message.OutputMessage;

public class OutputView {
    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printLottoAmountInput() {
        System.out.println(OutputMessage.REQUEST_INPUT_AMOUNT.getMessage());
    }

    public static void printLottoNumberOutput(int lottoAmount, List<Lotto> lottos) {
        System.out.println(lottoAmount + OutputMessage.PRINT_LOTTO_NUMBER.getMessage());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningNumberInput() {
        System.out.println(OutputMessage.REQUEST_INPUT_WINNING_NUMBER.getMessage());
    }

    public static void printBonusNumberInput() {
        System.out.println(OutputMessage.REQUEST_INPUT_BONUS_NUMBER.getMessage());
    }

    public static void printLottoStatistics(int[] lottoResult, double profitRate) {
        System.out.println(OutputMessage.MATCH_THREE.getMessage() + lottoResult[0] + "개");
        System.out.println(OutputMessage.MATCH_FOUR.getMessage() + lottoResult[1] + "개");
        System.out.println(OutputMessage.MATCH_FIVE.getMessage() + lottoResult[2] + "개");
        System.out.println(OutputMessage.MATCH_FIVE_BONUS.getMessage() + lottoResult[3] + "개");
        System.out.println(OutputMessage.MATCH_SIX.getMessage() + lottoResult[4] + "개");
        System.out.println(
                OutputMessage.TOTAL_PROFIT_RATE.getMessage() + profitRate + "%입니다.");
    }
}
