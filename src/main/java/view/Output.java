package view;

import java.util.List;
import utils.WinningLotto;

public class Output {
    private static final String PURCHASE_AMOUNT_FORMAT = "%d개를 구매했습니다.\n";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.\n";
    private static final String WINNING_RESULT_FORMAT = "당첨 통계\n---------\n";

    public void printPurchaseAmount(int purchaseAmount) {
        System.out.printf(PURCHASE_AMOUNT_FORMAT, purchaseAmount);
    }

    public void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
    }

    public void printWinningResult(List<Integer> winningResult) {
        System.out.println(WINNING_RESULT_FORMAT);
        System.out.printf(WinningLotto.FIRST_REWARD.getFormat(), winningResult.get(0));
        System.out.printf(WinningLotto.SECOND_REWARD.getFormat(), winningResult.get(1));
        System.out.printf(WinningLotto.THIRD_REWARD.getFormat(), winningResult.get(2));
        System.out.printf(WinningLotto.FOURTH_REWARD.getFormat(), winningResult.get(3));
        System.out.printf(WinningLotto.FIFTH_REWARD.getFormat(), winningResult.get(4));
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_FORMAT, profitRate);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
