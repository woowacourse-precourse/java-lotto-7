package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.validator.InputValidator;

public class InputView {

    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public int readPurchaseAmount() {
        System.out.println(ASK_PURCHASE_AMOUNT);
        String purchaseAmount = Console.readLine();
        InputValidator.validate(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public String readWinningNumbers() {
        System.out.println(ASK_WINNING_NUMBERS);
        return Console.readLine();
    }

    public int readBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        InputValidator.validate(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
