package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public String requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
        return readUserInput();
    }

    private String readUserInput() {
        String input = Console.readLine();
        return input.trim();
    }
}
