package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;
import java.util.regex.Pattern;

public class InputView {

    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_REGEX = "^-?\\d+$";

    public static void printPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public static int getPurchaseAmount() {
        String input = Console.readLine();
        validateInputIsNull(input);
        validateIsNumber(input);
        return Integer.parseInt(input);
    }

    private static void validateInputIsNull(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    private static void validateIsNumber(String input) {
        if (!Pattern.matches(NUMBER_REGEX, input)) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해야 합니다.");
        }
    }
}
