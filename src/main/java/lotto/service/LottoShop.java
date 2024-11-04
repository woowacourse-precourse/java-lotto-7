package lotto.service;

import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;

public interface LottoShop {
    LottoTickets publishTickets(PurchaseAmount purchaseAmount);
}
