package lotto.view;

import static lotto.exception.LottoErrorMessage.EMPTY_INPUT;
import static lotto.exception.LottoErrorMessage.NOT_A_NUMBER_INPUT;

import camp.nextstep.edu.missionutils.Console;

public class LottoInputView {
    public int readInt() {
        String input = readString();
        return parseToInt(input);
    }

    public String readString() {
        String input = Console.readLine().trim();
        validateString(input);
        return input;
    }

    private int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER_INPUT.message);
        }
    }

    private void validateString(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(EMPTY_INPUT.message);
        }
    }
}
