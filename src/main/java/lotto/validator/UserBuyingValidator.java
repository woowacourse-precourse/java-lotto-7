package lotto.validator;

import static lotto.constants.Constants.ERROR_MESSAGE;

public class UserBuyingValidator {
    private final static int LOTTO_PRICE = 1000;

    public void validateBuyingValidation(String buyingPrice) {
        validIsNumber(buyingPrice);
        validPrice(buyingPrice);
    }

    public void validPrice(String pay) {
        int buyingPrice = Integer.parseInt(pay);
        if (buyingPrice % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "구매는 1,000원 단위로 가능합니다.");
        }
    }

    public static void validIsNumber(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new NumberFormatException(ERROR_MESSAGE + "입력은 숫자만 가능합니다.");
            }
        }
    }
}
