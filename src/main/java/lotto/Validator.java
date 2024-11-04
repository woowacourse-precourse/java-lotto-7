package lotto;

import camp.nextstep.edu.missionutils.Console;

@FunctionalInterface
public interface Validator<T> {
    T validate(String input) throws IllegalArgumentException;

    static <T> T promptWithValidation(String message, Validator<T> validator) {
        while (true) {
            try {
                System.out.println(message);
                String input = Console.readLine();
                return validator.validate(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
