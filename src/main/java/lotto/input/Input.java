package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;

import java.util.NoSuchElementException;

public class Input {
    public String read() throws IllegalArgumentException {
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }
}
