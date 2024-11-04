package lotto.validator;

import lotto.enums.ErrorMessages;

public class PriceValidator {

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




}
