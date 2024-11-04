package lotto.view;

import java.util.regex.Pattern;
import lotto.enums.LottoError;

public class LottoInputValidator {
    private static final String INPUT_DIGIT_FORMAT_REGEX = "^\\d+$";
    private static final Pattern INPUT_DIGIT_FORMAT = Pattern.compile(INPUT_DIGIT_FORMAT_REGEX);
    private static final String NUMBERS_FORMAT_REGEX = "^\\d+(,\\d+)*$";
    private static final Pattern NUMBERS_FORMAT = Pattern.compile(NUMBERS_FORMAT_REGEX);

    public void validateLottoPurchasePrice(String purchasePrice) {
        validateDigit(purchasePrice);
    }

    public void validateLottoWinningNumbers(String winningNumbers) {
        validateNumbers(winningNumbers);
    }

    public void validateLottoBonusNumber(String bonusNumber) {
        validateDigit(bonusNumber);
    }

    private void validateDigit(String number) {
        if (!INPUT_DIGIT_FORMAT.matcher(number).matches()) {
            throw new IllegalArgumentException(LottoError.INPUT_NUMBER_INVALID.getMessage());
        }
    }

    private void validateNumbers(String numbers) {
        if (!NUMBERS_FORMAT.matcher(numbers).matches()) {
            throw new IllegalArgumentException(LottoError.INPUT_NUMBERS_INVALID.getMessage());
        }
    }
}
