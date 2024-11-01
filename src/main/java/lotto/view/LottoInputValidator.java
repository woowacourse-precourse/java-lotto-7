package lotto.view;

import java.util.regex.Pattern;
import lotto.error.LottoError;

public class LottoInputValidator {

    private static final String INPUT_DIGIT_PATTERN_TEXT = "^\\d+$";
    private static final Pattern INPUT_DIGIT_PATTERN = Pattern.compile(INPUT_DIGIT_PATTERN_TEXT);

    public void validateLottoPurchasePrice(String purchasePrice){
        validateDigit(purchasePrice);
    }

    private void validateDigit(String lottoPurchasePrice) {
        if (!INPUT_DIGIT_PATTERN.matcher(lottoPurchasePrice).matches()) {
            throw new IllegalArgumentException(LottoError.LOTTO_PURCHASE_PRICE_NOT_DIGIT.getMessage());
        }
    }
}
