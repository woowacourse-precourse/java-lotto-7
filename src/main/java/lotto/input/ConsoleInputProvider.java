package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class ConsoleInputProvider implements InputProvider {

    @Override
    public String readLine() {
        return readLineOrThrow();
    }

    private static String readLineOrThrow() {
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력값 입니다.");
        }
    }
}
