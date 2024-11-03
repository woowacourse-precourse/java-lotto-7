package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public String input(String message) {
        System.out.println(message);
        String input = Console.readLine();
        System.out.println();
        return input;
    }
}
