package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Validator;

public class InputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public static int purchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
        String amount = read();
        int parseAmount = parseAndValidateAmount(amount);
        return parseAmount;
    }

    private static int parseAndValidateAmount(String amount) {
        Validator.isNumber(amount);
        int parseAmount = Integer.parseInt(amount);
        Validator.amountIsMultipleOf1000(parseAmount);
        return parseAmount;
    }

    private static String read() {
        return Console.readLine();
    }
}
