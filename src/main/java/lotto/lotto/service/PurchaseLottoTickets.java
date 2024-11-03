package lotto.lotto.service;

import lotto.lotto.domain.LottoTickets;

public interface PurchaseLottoTickets {
    LottoTickets purchase(int count);
}
