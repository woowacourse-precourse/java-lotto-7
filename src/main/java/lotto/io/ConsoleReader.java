package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleReader implements InputReader {
    private static final ConsoleReader INSTANCE = new ConsoleReader();

    private ConsoleReader() {

    }

    public static ConsoleReader getInstance() {
        return INSTANCE;
    }

    @Override
    public String read() {
        return Console.readLine();
    }
}
