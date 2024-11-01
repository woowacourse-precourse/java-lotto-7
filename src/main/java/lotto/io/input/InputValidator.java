package lotto.io.input;

public class InputValidator {

    private static final int ONE_THOUSAND = 1000;

    public static void validatePriceIsInThousandUnit(int price) {
        if (price % ONE_THOUSAND != 0) {
            throw new IllegalArgumentException("Price must be in thousand units");
        }
    }

}