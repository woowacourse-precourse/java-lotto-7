package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public abstract class InputView {

    public String read(String command) {
        System.out.println(command);
        String input = Console.readLine();
        validate(input);
        System.out.println();
        return input;
    }

    public abstract void validate(String input);
}
