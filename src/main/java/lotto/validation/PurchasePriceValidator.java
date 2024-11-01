package lotto.validation;

public class PurchasePriceValidator {
    //구매금액 유효성 검증
    public static void validator(String price) {
        checkNaturalNumber(price);
        checkDivideIntoThousand(price);
    }

    private static void checkNaturalNumber(String price) {
        try {
            int amount = convertToInteger(price);
            if (amount < 1) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDivideIntoThousand(String price) {
        int amount = convertToInteger(price);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("1000원으로 나누어떨어지지 않습니다.");
        }
    }

    private static int convertToInteger(String price) {
        return Integer.parseInt(price);
    }
}
