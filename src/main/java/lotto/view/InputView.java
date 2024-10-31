package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ERROR_NOT_NUMBER = "[ERROR] 숫자만 입력 가능합니다.";

    public int inputPurchaseAmount() {
        System.out.println("구매금액을 입력해 주세요.");
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMBER);
        }
    }
}
