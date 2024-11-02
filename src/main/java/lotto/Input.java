package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String SYSTEM_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";

    public void getPriceInput() {
        System.out.println(SYSTEM_PRICE_INPUT_MESSAGE);
        String priceInput = Console.readLine();
    }
}
