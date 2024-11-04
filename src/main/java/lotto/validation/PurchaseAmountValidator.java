package lotto.validation;

import static lotto.util.Constants.LOTTO_PRICE_UNIT;

import java.math.BigInteger;
import lotto.util.Constants;

public class PurchaseAmountValidator {
    private static final long MAX_LOTTO_PURCHASE_AMOUNT = (long) Integer.MAX_VALUE * LOTTO_PRICE_UNIT;
    private static final String ERROR_IS_VACANT_MSG = "로또 구매 금액을 입력하셔야 합니다.";
    private static final String ERROR_CONTAIN_LETTER_MSG = "로또 구매 금액은 숫자로 입력하셔야 합니다.";
    private static final String ERROR_IS_NOT_POSITIVE_NATURAL_NUMBER_MSG = "로또 구매 금액은 양의 정수로 입력하셔야 합니다.";
    private static final String ERROR_EXCEED_LIMIT_MSG = "로또 구매 금액은 %d를 초과할 수 없습니다.".formatted(
            MAX_LOTTO_PURCHASE_AMOUNT);
    private static final String ERROR_IS_NOT_UNIT_OF_LOTTO_PRICE = "로또 구매 금액은 %d원 단위로 입력하셔야 합니다.".formatted(
            LOTTO_PRICE_UNIT);

    public static void isValid(String input) {
        isVacant(input);

        containLetter(input);

        exceedLimit(input);

        isUnitOfLottoPrice(input);
    }

    private static void isVacant(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(Constants.ERROR_INIT + ERROR_IS_VACANT_MSG);
        }
    }

    private static void containLetter(String input) {
        try {
            BigInteger price = new BigInteger(input);

            isPositiveNaturalNumber(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERROR_INIT + ERROR_CONTAIN_LETTER_MSG);
        }
    }

    private static void isPositiveNaturalNumber(BigInteger price) {
        if (price.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException(Constants.ERROR_INIT + ERROR_IS_NOT_POSITIVE_NATURAL_NUMBER_MSG);
        }
    }

    private static void exceedLimit(String input) {
        BigInteger price = new BigInteger(input);

        if (price.compareTo(BigInteger.valueOf(MAX_LOTTO_PURCHASE_AMOUNT)) > 0) {
            throw new IllegalArgumentException(Constants.ERROR_INIT + ERROR_EXCEED_LIMIT_MSG);
        }
    }

    private static void isUnitOfLottoPrice(String input) {
        long price = Long.parseLong(input);

        if (price % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(Constants.ERROR_INIT + ERROR_IS_NOT_UNIT_OF_LOTTO_PRICE);
        }
    }
}
