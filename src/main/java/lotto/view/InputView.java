package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    public String inputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }
}
