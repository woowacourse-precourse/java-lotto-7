package lotto.Validation;

public class PriceValidator {

    public static boolean isNotInteger(String paymentPrice) {
        try {
            Integer.parseInt(paymentPrice);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean isOutOfIntegerRange(String paymentPrice) {
        try {
            long value = Long.parseLong(paymentPrice);
            return value < Integer.MIN_VALUE || value > Integer.MAX_VALUE;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    public static boolean isZero(String paymentPrice) {
        return Integer.parseInt(paymentPrice) == 0;
    }

    public static boolean isNegative(String paymentPrice) {
        return Integer.parseInt(paymentPrice) < 0;
    }

    public static boolean isNotThousandUnit(String paymentPrice) {
        return Integer.parseInt(paymentPrice) % 1000 != 0;
    }
}

