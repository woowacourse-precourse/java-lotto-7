package lotto.view.console;

import camp.nextstep.edu.missionutils.Console;

public class Reader {

    public static String read() {
        return Validator.validate(Console.readLine());
    }

    private static class Validator {
        private static String validate(String input) {
            if (isBlank(input)) {
                throw new IllegalArgumentException("[ERROR] 빈 문자열 또는 공백은 입력할 수 없습니다.");
            }
            return input;
        }

        private static boolean isBlank(String input) {
            return input.isBlank();
        }
    }
}
