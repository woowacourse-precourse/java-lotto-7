package lotto.valuate;

import static lotto.constant.LottoErrorConstant.ERROR_EXCEED_PRICE;
import static lotto.constant.LottoErrorConstant.ERROR_PRICE_MULTIPLE_OF_PRICE;
import static lotto.constant.LottoErrorConstant.ERROR_PRICE_NUMBER_FORMAT;
import static lotto.constant.LottoValueConstant.LOTTO_PRICE;
import static lotto.constant.LottoValueConstant.MAX_PRICE;

public class PriceValidate {
    public static void isValidNumber(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_PRICE_NUMBER_FORMAT);
        }
    }

    public static void isValidPrice(int price) {
        isExceedMax(price);
        isNonUnit(price);
    }

    public static void isExceedMax(int price){
        if(price > MAX_PRICE){
            throw new IllegalArgumentException(ERROR_EXCEED_PRICE);
        }
    }

    public static void isNonUnit(int price){
        if (price / LOTTO_PRICE < 1 || price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_PRICE_MULTIPLE_OF_PRICE);
        }
    }
}
