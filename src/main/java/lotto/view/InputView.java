package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Number;
import lotto.domain.Payment;
import lotto.domain.WinningNumbers;
import lotto.global.contents.LottoDetail;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;
import lotto.view.console.Reader;
import lotto.view.console.Writer;

public class InputView {

    private static final String QUESTION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String QUESTION_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String QUESTION_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String SEPARATOR = ",";

    public Payment readPrice() {
        Writer.println(QUESTION_PURCHASE_AMOUNT);
        return Payment.of(
                Validator.validatePrice(Reader.read()),
                LottoDetail.PRICE
        );
    }

    public WinningNumbers readWinningNumbers() {
        Writer.println(QUESTION_WINNING_NUMBERS);
        String winningNumbers = Validator.validateSeparator(Reader.read());
        return WinningNumbers.of(convert(winningNumbers));
    }

    public BonusNumber readBonusNumber(WinningNumbers winningNumbers) {
        Writer.println(QUESTION_BONUS_NUMBER);
        int bonusNumber = Validator.validateNumber(Reader.read());
        return BonusNumber.valueOf(winningNumbers, Number.of(bonusNumber));
    }

    private List<Integer> convert(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(Validator::validateNumber)
                .toList();
    }

    private static class Validator {
        private static int validatePrice(String input) {
            validateZero(input);
            return validateNumber(input);
        }

        private static String validateSeparator(String input) {
            if (hasContinuousSeparator(input) || hasEdgeSeparator(input)) {
                throw new LottoException(ErrorMessage.INVALID_INPUT_FORMAT);
            }
            return input;
        }

        private static void validateZero(String input) {
            if (isZero(input)) {
                throw new LottoException(ErrorMessage.INVALID_NUMBER_FORMAT);
            }
        }

        private static boolean isZero(String input) {
            return input.matches("0");
        }

        private static int validateNumber(String input) {
            if (isNotNumeric(input)) {
                throw new LottoException(ErrorMessage.INVALID_INPUT_FORMAT);
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
