package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoTickets;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class LottoShopImpl implements LottoShop {
    private final LottoMachine lottoMachine;

    public LottoShopImpl(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    @Override
    public LottoTickets publishTickets(PurchaseAmount purchaseAmount) {
        int purchasableQuantity = purchaseAmount.getPurchasableQuantity();
        return generateTickets(purchasableQuantity);
    }

    private LottoTickets generateTickets(int purchaseQuantity) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            lottoTickets.add(lottoMachine.generateLotto());
        }
        return new LottoTickets(lottoTickets);
    }
}
