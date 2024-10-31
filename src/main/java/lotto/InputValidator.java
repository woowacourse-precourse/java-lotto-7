package lotto;

import static lotto.ErrorCode.CONTIGIOUS_COMMA;
import static lotto.ErrorCode.INVALID_PURCHASE_AMOUNT;


public class InputValidator {

    private static final int TICKET_PRICE = 1000;
    private static final String COMMAS = ",,";

    //구매 금액 검증 (컨트롤러)
    public static void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    //당첨 번호 검증 (컨트롤러)
    public static void validateInputWinnigNumber(final String inputWinnigNumber) {
        if (inputWinnigNumber.contains(COMMAS)) {
            throw new IllegalArgumentException(CONTIGIOUS_COMMA.getMessage());
        }
    }

}