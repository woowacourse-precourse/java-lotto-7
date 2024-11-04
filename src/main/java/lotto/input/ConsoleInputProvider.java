package lotto.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class ConsoleInputProvider implements InputProvider {

    @Override
    public String readLine() {
        return readLineOrThrow();
    }

    private static String readLineOrThrow() {
        try {
            String input = Console.readLine();
            validateInput(input);
            return input;
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("[ERROR] null을 입력할 수 없습니다.");
        }
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank() || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 잘못된 입력값 입니다.");
        }
    }
}
