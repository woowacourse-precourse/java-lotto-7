package lotto.domain;

import java.util.List;
import lotto.Lotto;

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
            throw new IllegalArgumentException("로또 구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    private void validatePurchaseAmount(int money) {
        if (money < LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException("최소 구입 금액은 1,000원 입니다.");
        }

        if (money > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("최대 구입 금액은 100,000원 입니다.");
        }
    }
}
