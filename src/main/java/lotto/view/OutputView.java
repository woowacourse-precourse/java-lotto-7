package lotto.view;

import java.util.Map;
import lotto.model.LottoRank;
import lotto.model.Lottos;

public class OutputView {

    private static final String NEXT_LINE = System.lineSeparator();
    private static final String WINNING_RESULT_INFORMATION_MESSAGE = NEXT_LINE + "당첨 통계" + NEXT_LINE + "---";
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = NEXT_LINE + "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = NEXT_LINE + "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = NEXT_LINE + "보너스 번호를 입력해 주세요.";

    public void printPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printQuantity(int quantity) {
        String formatingQuantity = OutputFormatter.formatingQuantity(quantity);
        System.out.println(formatingQuantity);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public void printWinningNumbersMessage() {
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void printLottoWinningResult(Map<LottoRank, Integer> winningResult) {
        printWinningResultMessage();
        String formatWinningResult = OutputFormatter.formatingWinningResult(winningResult);
        System.out.println(formatWinningResult);
    }

    public void printRateOfReturn(double rateOfReturn) {
        String formatRateOfReturn = OutputFormatter.formatingRateOfReturn(rateOfReturn);
        System.out.println(formatRateOfReturn);
    }

    public void printErrorMessage(String exceptionMessage) {
        System.out.println(exceptionMessage);
    }

    private void printWinningResultMessage() {
        System.out.println(WINNING_RESULT_INFORMATION_MESSAGE);
    }
}
