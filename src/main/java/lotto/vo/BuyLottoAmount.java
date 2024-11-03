package lotto.vo;

import static lotto.config.LottoInfo.LOTTO_TICKET_PRICE;

import lotto.exception.LottoException.LowThenMinLottoPriceException;
import lotto.exception.LottoException.PurchaseUnitException;

public record BuyLottoAmount(Integer amount) {

    private static final Integer ZERO = 0;

    public BuyLottoAmount {
        validateAmount(amount);
    }

    private void validateAmount(final Integer amount) {
        if (isLessThenLottoPrice(amount)) {
            throw new LowThenMinLottoPriceException();
        }
        if (isDivisibleByLottoPrice(amount)) {
            throw new PurchaseUnitException();
        }
    }

    private boolean isLessThenLottoPrice(final Integer amount) {
        return amount < LOTTO_TICKET_PRICE.getValue();
    }

    private boolean isDivisibleByLottoPrice(final Integer amount) {
        Integer number = amount % LOTTO_TICKET_PRICE.getValue();
        return !(ZERO.equals(number));
    }
}
