package lotto.domain;

import static lotto.constans.ErrorMessages.ERROR_MAXIMUM_PURCHASE_AMOUNT;
import static lotto.constans.ErrorMessages.ERROR_MINIMUM_PURCHASE_AMOUNT;

import java.util.List;
import lotto.constans.ErrorMessages;

public class LottoShop {
    public static final int MAX_PURCHASE_AMOUNT = 100_000;
    public static final int LOTTO_UNIT_PRICE = 1_000;
    public static final int NO_REMAINDER = 0;

    private final LottoTicketFactory lottoTicketFactory;

    public LottoShop(LottoTicketFactory lottoTicketFactory) {
        this.lottoTicketFactory = lottoTicketFactory;
    }

    public List<Lotto> purchaseLottoTickets(int money) {
        validatePurchaseAmount(money);
        validateThousandUnitAmount(money);
        return lottoTicketFactory.generateLottoTickets(calculateTicketCount(money));
    }

    private int calculateTicketCount(int money) {
        return money / LOTTO_UNIT_PRICE;
    }

    private void validateThousandUnitAmount(int money) {
        if (money % LOTTO_UNIT_PRICE != NO_REMAINDER) {
            throw new IllegalArgumentException(ErrorMessages.ERROR_INVALID_UNIT_AMOUNT);
        }
    }

    private void validatePurchaseAmount(int money) {
        if (money < LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException(ERROR_MINIMUM_PURCHASE_AMOUNT);
        }

        if (money > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ERROR_MAXIMUM_PURCHASE_AMOUNT);
        }
    }
}
