package lotto.global.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.exception.InputException;

public class InputConsole implements AutoCloseable {

    public String read() {
        String input = Console.readLine();

        if (input.isBlank()) {
            throw InputException.empty();
        }

        return input;
    }

    @Override
    public void close() {
        Console.close();
    }
}
