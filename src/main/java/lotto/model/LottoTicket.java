package lotto.model;

import lotto.exception.ErrorMessages;
import lotto.exception.LottoException;

public record LottoTicket(Lotto lotto, Money price) {
    public LottoTicket {
        validate(lotto, price);
    }

    private void validate(Lotto lotto, Money price) {
        if (lotto == null) {
            throw new LottoException(ErrorMessages.LOTTO_TICKETS_NULL);
        }
        if (price == null) {
            throw new LottoException(ErrorMessages.PRICE_NULL);
        }
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
