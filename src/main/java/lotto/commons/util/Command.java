package lotto.commons.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.commons.lang.ProgramExitException;

public class Command {

    private Command() {}

    private static final String EXIT = "exit";

    public static String read() {
        String read = Console.readLine();
        handleCommands(read);
        return read;
    }

    private static void handleCommands(String read) {
        if (EXIT.equals(read)) {
            Command.close();
            throw new ProgramExitException();
        }
    }

    public static void close() {
        Console.close();
    }

}
