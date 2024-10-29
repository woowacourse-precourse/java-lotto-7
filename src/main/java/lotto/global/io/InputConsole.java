package lotto.global.io;

import camp.nextstep.edu.missionutils.Console;

public class InputConsole implements AutoCloseable {

    public String read() {
        String input = Console.readLine();

        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }

        return input;
    }

    @Override
    public void close() {
        Console.close();
    }
}
