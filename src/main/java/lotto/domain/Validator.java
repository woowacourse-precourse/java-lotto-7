package lotto.domain;

import lotto.global.ErrorMessage;

public class Validator {

    public Validator() {}

    public int validateLottoPrice(String input) {
        try {
            int price = Integer.parseInt(input);
            if(price < 0) {
                throw new IllegalArgumentException(ErrorMessage.PRICE_ERROR);
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PRICE_ERROR);
        }
    }

    public int validateLottoNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            if(number < 0 || number > 45) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_ERROR);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_ERROR);
        }
    }
}
