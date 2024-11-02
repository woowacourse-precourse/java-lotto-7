package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ErrorMessage;
import lotto.exception.InputException;

public class InputView {
    private static final String ASK_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String askPurchasePrice() {
        System.out.println(ASK_PURCHASE_PRICE);
        return validate(Console.readLine());
    }

    public static String askWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBER);
        return validate(Console.readLine());
    }

    public static String askBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
        return validate(Console.readLine());
    }

    public static String validate(String input) {
        if (input == null) {
            throw InputException.from(ErrorMessage.INPUT_IS_NULL);
        }
        if (input.isEmpty()) {
            throw InputException.from(ErrorMessage.INPUT_IS_EMPTY);
        }
        return input;
    }
}
