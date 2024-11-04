package lotto.model;

import lotto.common.constant.ErrorMessage;
import lotto.exception.PriceToBuyLottoException;
import lotto.validation.PriceToBuyLottoValidator;

public record PriceToBuyLotto(Integer price) {
    public static PriceToBuyLotto of(String input) {
        Integer price;
        try {
            price = Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new PriceToBuyLottoException(ErrorMessage.PRICE_SHOULD_BE_INTEGER);
        }

        PriceToBuyLottoValidator.validatePriceToBuyLotto(price);
        return new PriceToBuyLotto(price);
    }
}
