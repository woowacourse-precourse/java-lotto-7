package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PURCHASE_PROMPT = "구입금액을 입력해 주세요.";

    public String getPurchaseAmount() {
        System.out.println(PURCHASE_PROMPT);
        return Console.readLine().strip();
    }
}
