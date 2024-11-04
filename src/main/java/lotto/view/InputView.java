package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ParserExceptionMessage;

public class InputView {
    public String input() {
        return Console.readLine();
    }

    public int getInt() {
        try {
            return Integer.parseInt(input());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ParserExceptionMessage.NUMBER_FORMAT_INCORRECT.getMessage());
        }
    }
}
