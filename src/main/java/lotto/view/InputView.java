package lotto.view;

import java.util.Arrays;
import lotto.domain.Payment;
import lotto.domain.WinningNumbers;
import lotto.domain.lotto.Lotto;
import lotto.view.console.Reader;
import lotto.view.console.Writer;

public class InputView {

    private static final String QUESTION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String QUESTION_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String SEPARATOR = ",";

    public Payment readPrice() {
        Writer.println(QUESTION_PURCHASE_AMOUNT);
        return Payment.of(Validator.validatePrice(Reader.read()));
    }

    public WinningNumbers readWinningNumbers() {
        Writer.println(QUESTION_WINNING_NUMBERS);
        String winningNumbers = Validator.validateSeparator(Reader.read());
        return WinningNumbers.of(convert(winningNumbers));
    }

    private Lotto convert(String input) {
        return Lotto.of(
                Arrays.stream(input.split(SEPARATOR))
                        .map(Validator::validateNumber)
                        .toList()
        );
    }

    private static class Validator {
        private static int validatePrice(String input) {
            validateZero(input);
            return validateNumber(input);
        }

        private static String validateSeparator(String input) {
            if (hasContinuousSeparator(input) || hasEdgeSeparator(input)) {
                throw new IllegalArgumentException("[ERROR] 잘못된 입력 형식입니다.");
            }
            return input;
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

        private static boolean hasEdgeSeparator(String input) {
            return input.startsWith(SEPARATOR) || input.endsWith(SEPARATOR);
        }

        private static boolean hasContinuousSeparator(String input) {
            return input.matches(SEPARATOR.repeat(2));
        }
    }
}
