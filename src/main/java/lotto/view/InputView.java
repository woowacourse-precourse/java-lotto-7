package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.exception.ErrorMessage.INVALID_INPUT_NUMBER;

public class InputView {

    public int readPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumeric(input);
        return Integer.parseInt(input);
    }

    private void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER.getMessage());
        }
    }
}
