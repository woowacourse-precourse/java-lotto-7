package lotto.domain;

import static lotto.constants.NumberConstants.LOTTO_TICKET_DIVIDER;

public class LottoTicketCalculator {

    public int getLottoTicketsCount(String money) {
        return Integer.parseInt(money) / LOTTO_TICKET_DIVIDER;
    }
}
