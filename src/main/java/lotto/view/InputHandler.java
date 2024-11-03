package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.utils.NumberFormatter;

public class InputHandler {
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();

        InputValidator.validateStringTypeAmount(purchaseAmount);
        int purchaseAmountAsInt = NumberFormatter.parseToInt(purchaseAmount);
        InputValidator.validateIntegerTypeAmount(purchaseAmountAsInt);

        return purchaseAmountAsInt;
    }
}
