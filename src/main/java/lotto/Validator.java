package lotto;

import lotto.enums.ErrorMessages;

public class Validator {

    public int validatePrice(String priceInput) {
        try {
            int price = Integer.parseInt(priceInput);
            if (price <= 0) {
                throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_PRICE_UNDER_ZERO));
            }
            if (price % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_PRICE_NOT_IN_UNITS_OF_1000));
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_PRICE_IS_NOT_STRING));
        }
    }

    public String validateInput(String lottoNumber) {
        // 숫자와 쉼표만 허용하는 정규식 검증
        if (!lottoNumber.matches("^[0-9,]+$")) {
            throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_DELIMETER_ONLY_HAS_COMMA));
        }
        return lottoNumber;
    }

    public int validateNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ErrorMessages.printError(ErrorMessages.ERROR_NUMBER_UNDER_ZERO_OVER_FORTY_FIVE));
        }
        return bonusNumber;
    }
}
