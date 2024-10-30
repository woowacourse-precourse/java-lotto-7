package lotto.Utils;

import lotto.Enum.ExceptionCode;

public class Validator {

    public void validatePrice1000(int priceInput) {
        if (priceInput % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_PRICE.getMessage());
        }
    }

    public int validateInteger(String number) {
        try {
            return Integer.parseInt(number);
        } catch(Exception e) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_TYPE.getMessage());
        }
    }

}
