package lotto.io.input;

import static lotto.error.ThrowException.throwIllegalArgumentException;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;
import lotto.error.Error;

public class ConsoleInputReader implements InputReader {

    @Override
    public String readLine() {
        String inputString = "";
        try {
            inputString = Console.readLine();
        } catch (NoSuchElementException ignored) {
            throwIllegalArgumentException(Error.EMPTY_INPUT_ERROR.getMessage());
        }
        validateEmptyString(inputString);
        return inputString;
    }

    private void validateEmptyString(String input) {
        boolean validateEmpty = input == null || input.trim().isEmpty();
        String errorFormat = Error.EMPTY_STRING_ERROR.getMessage();
        throwIllegalArgumentException(validateEmpty, errorFormat);
    }
}
