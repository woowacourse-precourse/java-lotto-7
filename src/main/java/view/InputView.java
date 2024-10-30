package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public InputView() {

    }

    public String purchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine().strip();
    }

}
