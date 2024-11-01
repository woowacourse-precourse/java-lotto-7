package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.exception.ExceptionMessage.INPUT_BLANK;

public class InputView {
    private static final String PURCHASE_AMOUNT_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String readPurchaseAmount() {
        return getValidatedInput(PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public String readWinningNumber() {
        return getValidatedInput(WINNING_NUMBER_INPUT_MESSAGE);
    }

    private String getValidatedInput(String message) {
        System.out.println(message);
        String input = Console.readLine().strip();
        validateInput(input);
        return input;
    }

    private void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INPUT_BLANK.getMessage());
        }
    }
}
