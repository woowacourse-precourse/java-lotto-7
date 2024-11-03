package lotto;

import static lotto.LottoConstants.LOTTO_PRICE;

import java.util.ArrayList;
import java.util.List;

public class LottoShopImpl implements LottoShop {
    private final LottoMachine lottoMachine;

    public LottoShopImpl(LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    @Override
    public LottoTickets publishTickets(int purchaseQuantity) {
        return generateTickets(purchaseQuantity);
    }

    private LottoTickets generateTickets(int purchaseQuantity) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            lottoTickets.add(lottoMachine.generateLotto());
        }
        return new LottoTickets(lottoTickets);
    }
}
