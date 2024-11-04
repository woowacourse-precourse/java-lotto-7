package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_INPUT_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_GUIDE = "보너스 번호를 입력해 주세요.";

    public static String askPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_GUIDE);
        return readLine();
    }

    public static String askWinningNumbers() {
        System.out.println("\n" + WINNING_NUMBERS_INPUT_GUIDE);
        return readLine();
    }

    public static String askBonusNumber() {
        System.out.println("\n" + BONUS_NUMBER_INPUT_GUIDE);
        return readLine();
    }
}
