package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Payment;
import lotto.domain.winning.BonusNumber;
import lotto.domain.winning.WinningLotto;
import lotto.global.contents.LottoDetail;
import lotto.global.contents.ViewMessage;
import lotto.global.exception.ErrorMessage;
import lotto.global.exception.LottoException;
import lotto.view.console.Reader;
import lotto.view.console.Writer;

public class InputView {

    private static final String INTEGER_PATTERN = "\\d+";
    private static final String SEPARATOR = ",";
    private static final int CONTINUOUS_THRESHOLD = 2;

    public Payment readPrice() {
        Writer.println(ViewMessage.QUESTION_PURCHASE_AMOUNT);
        return Payment.of(
                Validator.validateNumber(Reader.read()),
                LottoDetail.PRICE
        );
    }

    public WinningLotto readWinningNumbers() {
        Writer.println(ViewMessage.QUESTION_WINNING_NUMBERS);
        String winningNumbers = Validator.validateSeparator(Reader.read());
        return WinningLotto.of(convert(winningNumbers));
    }

    public BonusNumber readBonusNumber(WinningLotto winningLotto) {
        Writer.println(ViewMessage.QUESTION_BONUS_NUMBER);
        int bonusNumber = Validator.validateNumber(Reader.read());
        return BonusNumber.valueOf(winningLotto, bonusNumber);
    }

    private List<Integer> convert(String input) {
        return Arrays.stream(input.split(SEPARATOR))
                .map(Validator::validateNumber)
                .toList();
    }

    private static class Validator {
        private static String validateSeparator(String input) {
            if (hasContinuousSeparator(input) || hasEdgeSeparator(input)) {
                throw new LottoException(ErrorMessage.INVALID_INPUT_FORMAT);
            }
            return input;
        }

        private static int validateNumber(String input) {
            if (isNotNumeric(input)) {
                throw new LottoException(ErrorMessage.INVALID_INPUT_FORMAT);
            }
            return Integer.parseInt(input);
        }

        private static boolean isNotNumeric(String input) {
            return !input.matches(INTEGER_PATTERN);
        }

        private static boolean hasEdgeSeparator(String input) {
            return input.startsWith(SEPARATOR) || input.endsWith(SEPARATOR);
        }

        private static boolean hasContinuousSeparator(String input) {
            return input.matches(SEPARATOR.repeat(CONTINUOUS_THRESHOLD));
        }
    }
}
