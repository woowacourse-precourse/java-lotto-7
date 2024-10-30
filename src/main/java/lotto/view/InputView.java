package lotto.view;

import lotto.view.console.Reader;
import lotto.view.console.Writer;

public class InputView {

    private static final String QUESTION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public int readPrice() {
        Writer.println(QUESTION_PURCHASE_AMOUNT);
        return Validator.validatePrice(Reader.read());
    }

    private static class Validator {
        private static int validatePrice(String input) {
            validateZero(input);
            return validateNumber(input);
        }

        private static void validateZero(String input) {
            if (isZero(input)) {
                throw new IllegalArgumentException("[ERROR] 0원은 구매할 수 없습니다.");
            }
        }

        private static boolean isZero(String input) {
            return input.matches("0");
        }

        private static int validateNumber(String input) {
            if (isNotNumeric(input)) {
                throw new IllegalArgumentException("[ERROR] 양의 정수만 입력이 가능합니다.");
            }
            return Integer.parseInt(input);
        }

        private static boolean isNotNumeric(String input) {
            return !input.matches("\\d+");
        }
    }
}
