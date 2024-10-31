package lotto.mvc.validation;

import java.math.BigInteger;

public class PurchaseAmountValidator {
    public static void isValid(String input) {
        isVacant(input);

        containLetters(input);

        exceedLimit(input);

        isUnitOfLottoPrice(input);
    }

    private static void isVacant(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액을 입력하셔야 합니다.");
        }
    }

    private static void containLetters(String input) {
        try {
            BigInteger price = new BigInteger(input);

            isPositiveNaturalNumber(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 숫자로 입력하셔야 합니다.");
        }
    }

    private static void isPositiveNaturalNumber(BigInteger price) {
        if (price.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 양의 정수로 입력하셔야 합니다.");
        }
    }

    private static void exceedLimit(String input) {
        BigInteger price = new BigInteger(input);

        if (price.compareTo(BigInteger.valueOf((long) Integer.MAX_VALUE * 1000)) > 0) {
            throw new IllegalArgumentException(
                    "[ERROR] 로또 구매 금액은 " + (long) Integer.MAX_VALUE * 1000 + "를 초과할 수 없습니다.");
        }
    }

    private static void isUnitOfLottoPrice(String input) {
        long price = Long.parseLong(input);

        if (price % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 " + 1000 + "원 단위로 입력하셔야 합니다.");
        }
    }
}
