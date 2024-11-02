package lotto.view.console;

import camp.nextstep.edu.missionutils.Console;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;

public class Reader {

    public static String read() {
        return Validator.validate(Console.readLine());
    }

    private static class Validator {
        private static String validate(String input) {
            if (isBlank(input)) {
                throw new LottoException(ErrorMessage.INVALID_BLANK_INPUT);
            }
            return input;
        }

        private static boolean isBlank(String input) {
            return input.isBlank();
        }
    }
}
