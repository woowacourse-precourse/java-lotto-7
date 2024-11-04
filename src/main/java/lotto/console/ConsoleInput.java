package lotto.console;

import lotto.enums.InputType;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class ConsoleInput {

    public static String getInput(InputType inputType) {
        ConsoleOutput.print(inputType.getMessage());
        return readLine();
    }
}
