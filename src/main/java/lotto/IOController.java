package lotto;

import camp.nextstep.edu.missionutils.Console;

public class IOController {
    private static String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    String inputPurchase() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public void printWinningStatistics(double statistic) {
        System.out.println("총 수익률은 " + statistic + "%입니다.");
    }
}
