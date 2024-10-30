package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    public static int inputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        return inputNumberValue();
    }

    private static String inputValue() {
        return Console.readLine();
    }

    private static int inputNumberValue() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자값만 입력가능합니다.");
        }
    }
}
