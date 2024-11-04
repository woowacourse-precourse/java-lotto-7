package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

public class Input {
    private final int LOTTO_PRICE = 1000;
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

        if (!isDigit(amount)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }

        if (Integer.parseInt(amount) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INDIVISIBLE_NUMBER);
        }

        if (Integer.parseInt(amount) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER);
        }
    }

    private boolean isDigit(String amount) {
        for (char c : amount.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
