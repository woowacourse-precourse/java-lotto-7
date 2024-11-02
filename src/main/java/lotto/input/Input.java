package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;

import java.util.NoSuchElementException;

public class Input {
    public String read() throws IllegalArgumentException {
        try {
            return Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(ExceptionMessage.NO_SUCH_ELEMENT.getMessage());
        }
    }

    public void close() {
        Console.close();
    }
}
