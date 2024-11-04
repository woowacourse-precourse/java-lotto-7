package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

public class Input {
    private final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public int getAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);

        String amount = Console.readLine();
        validate(amount);

        return Integer.parseInt(amount);
    }

    private void validate(String amount) {
        if (amount.isEmpty() || amount.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_EXIST);
        }

        if (Integer.parseInt(amount) % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE_NUMBER);
        }

        if (Integer.parseInt(amount) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER);
        }
    }
}
