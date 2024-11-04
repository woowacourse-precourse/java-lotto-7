package lotto.domain;

import static lotto.constants.ErrorMessage.IS_NOT_DIVISIBLE_BY_THOUSAND_WON;
import static lotto.constants.ErrorMessage.PURCAHSE_PRICE_MUST_BE_NATURAL_NUMBER;
import static lotto.constants.LottoConstant.LOTTO_PER_PRICE;
import static lotto.constants.LottoConstant.NATURAL_STANDARD;

public class PurchasePrice {

    private final int amount;

    public PurchasePrice(String price) {
        validate(price);
        this.amount = Integer.parseInt(price);
    }

    public static void validate(String price) {
        checkNaturalNumber(price);
        checkDivideIntoThousand(price);
    }

    private static void checkNaturalNumber(String price) {
        try {
            int amount = convertToInteger(price);
            if (amount < NATURAL_STANDARD) {
                throw new IllegalArgumentException(PURCAHSE_PRICE_MUST_BE_NATURAL_NUMBER.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PURCAHSE_PRICE_MUST_BE_NATURAL_NUMBER.getMessage());
        }
    }

    private static void checkDivideIntoThousand(String price) {
        int amount = convertToInteger(price);
        if (canDivide(amount)) {
            throw new IllegalArgumentException(IS_NOT_DIVISIBLE_BY_THOUSAND_WON.getMessage());
        }
    }

    private static boolean canDivide(int amount) {
        return amount % LOTTO_PER_PRICE != 0;
    }

    private static int convertToInteger(String price) {
        return Integer.parseInt(price);
    }

    public int getLottoTicketCount() {
        return amount / LOTTO_PER_PRICE;
    }

    public int getAmount() {
        return amount;
    }
}
