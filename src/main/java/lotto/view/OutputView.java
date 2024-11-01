package lotto.view;

import java.util.List;
import lotto.util.PrizeType;

public class OutputView {
    private static final String AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT_MESSAGE = "\n보너스 번호를 입력해 주세요.";

    private static final String LOTTO_FORMAT = "\n%d개를 구매했습니다.\n";
    private static final String RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String PRIZE_FORMAT = "%s%s - %d개\n";
    private static final String RATE_OF_RETURN_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void showMoneyInputMessage() {
        System.out.println(AMOUNT_INPUT_MESSAGE);
    }

    public void showWinningNumberInputMessage() {
        System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
    }

    public void showBonusBallInputMessage() {
        System.out.println(BONUS_BALL_INPUT_MESSAGE);
    }

    public void showPurchaseAmount(int chance) {
        System.out.printf(LOTTO_FORMAT, chance);
    }

    public void displayLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }

    private void showResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void displayStatistics(int[] results, int moneySpent) {
        int totalPrize = 0;
        showResultMessage();
        for (PrizeType prizeType : PrizeType.values()) {
            int count = results[prizeType.ordinal()];
            int prizeAmount = prizeType.getPrizeMoney();
            totalPrize += count * prizeAmount;
            System.out.printf(PRIZE_FORMAT, prizeType.getMatching(), prizeType.getPrize(), count);
        }
        displayResultMessage(totalPrize, moneySpent);
    }

    public void displayResultMessage(int totalPrize, int moneySpent) {
        double rateOfReturn = ((double) totalPrize / (moneySpent * 1000)) * 100;
        System.out.printf(RATE_OF_RETURN_FORMAT, rateOfReturn);
    }

    public void showErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
