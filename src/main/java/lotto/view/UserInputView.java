package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInputView {

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String purchaseAmount = Console.readLine();
        System.out.println();
        return purchaseAmount;
    }

    public static String inputWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        String winningNumbers = Console.readLine();
        System.out.println();
        return winningNumbers;
    }

    public static String inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        System.out.println();
        return bonusNumber;
    }
}
