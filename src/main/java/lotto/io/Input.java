package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ErrorMessage;

public class Input {
    private final int LOTTO_PRICE = 1000;
    private final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

    public int getAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);

        String amount = Console.readLine();
        validateAmount(amount);

        return Integer.parseInt(amount);
    }

    public String getWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER);

        String winningNumber = Console.readLine();
        validateWinningNumber(winningNumber);

        return winningNumber;
    }

    private void validateAmount(String amount) {
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

    private void validateWinningNumber(String winningNumber) {
        if (winningNumber.isEmpty() || winningNumber.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_EXIST);
        }

        winningNumber = winningNumber.replace(",", "");

        if (!isDigit(winningNumber)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER);
        }
    }

    private boolean isDigit(String input) {
        for (char c : input.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
