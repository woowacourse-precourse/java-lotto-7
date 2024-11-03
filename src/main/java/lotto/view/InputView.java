package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return Integer.parseInt(readUserInput());
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return readUserInput();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Integer.parseInt(readUserInput());
    }
    private static String readUserInput() {
       return readLine();
    }
}
