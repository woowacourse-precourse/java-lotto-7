package lotto.view;

import static lotto.util.Constants.AMOUNT_UNIT;
import static lotto.util.Constants.ONE_HUNDRED;

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

    public void printLotto(List<List<Integer>> lottoNumbers) {
        lottoNumbers.stream()
                .map(Object::toString)
                .forEach(System.out::println);
    }

    public void showResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printStatistics(int[] results, int moneySpent) {
        int totalPrize = 0;
        showResultMessage();
        for (PrizeType prizeType : PrizeType.values()) {
            int count = results[prizeType.ordinal()];
            int prizeAmount = prizeType.getPrizeMoney();
            totalPrize += count * prizeAmount;
            System.out.printf(PRIZE_FORMAT, prizeType.getMatching(), prizeType.getPrize(), count);
        }
        printResultMessage(totalPrize, moneySpent);
    }

    public void printResultMessage(int totalPrize, int moneySpent) {
        double rateOfReturn = ((double) totalPrize / (moneySpent * AMOUNT_UNIT.getIntValue())) * ONE_HUNDRED.getIntValue();
        System.out.printf(RATE_OF_RETURN_FORMAT, rateOfReturn);
    }

    public void showErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
