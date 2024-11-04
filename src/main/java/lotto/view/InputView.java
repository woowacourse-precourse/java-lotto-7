package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

public class InputView {

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public static void printPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public static int getPurchaseAmount() {
        String input = Console.readLine();
        validateInputIsNull(input);
        return Integer.parseInt(input);
    }

    private static void validateInputIsNull(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }
}
