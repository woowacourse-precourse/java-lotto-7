package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

public class Input {
    private final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public int getAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);

        int amount = Integer.parseInt(Console.readLine());
        validate(amount);

        return amount;
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE_NUMBER);
        }
    }
}
