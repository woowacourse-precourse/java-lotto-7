package lotto.validation;

public class PurchasePriceValidator {

    public static void validator(String price) {
        checkNaturalNumber(price);
        checkDivideIntoThousand(price);
    }

    private static void checkNaturalNumber(String price) {
        try {
            int amount = convertToInteger(price);
            if (amount < 1) {
                throw new IllegalArgumentException("[ERROR] 구입 금액이 자연수가 아닙니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액이 자연수가 아닙니다.");
        }
    }

    private static void checkDivideIntoThousand(String price) {
        int amount = convertToInteger(price);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어떨어지지 않습니다.");
        }
    }

    private static int convertToInteger(String price) {
        return Integer.parseInt(price);
    }
}
