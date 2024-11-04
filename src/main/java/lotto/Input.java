package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Input {
    private static final String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    private static final String INVALID_PURCHASE_AMOUNT_MESSAGE = "구입금액은 숫자로 입력해주세요";

    public int askPurchaseAmount() {
        try {
            System.out.println(PURCHASE_AMOUNT_PROMPT);
            return Integer.parseInt(readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT_MESSAGE);
        }
    }
}
