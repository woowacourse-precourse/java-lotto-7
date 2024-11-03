package lotto.model;

import lotto.common.constant.ErrorMessage;
import lotto.exception.PriceToBuyLottoException;
import lotto.validation.PriceToBuyLottoValidation;

public record PriceToBuyLotto (Integer price){
    public static PriceToBuyLotto of (String input) {
        Integer price;

        try{
            price = Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new PriceToBuyLottoException(ErrorMessage.PRICE_SHOULD_BE_INTEGER);
        }

        PriceToBuyLottoValidation.validatePriceToBuyLotto(price);

        return new PriceToBuyLotto(price);
    }
}
