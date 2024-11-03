package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoTickets;
import lotto.model.PurchasePrice;

public class LottoService {
    public LottoTickets generateLottoTickets(final PurchasePrice purchasePrice) {
        List<Lotto> lottoTickets = new ArrayList<>();
        int quantity = purchasePrice.calculateQuantity();
        for (int count = 0; count < quantity; count++) {
            lottoTickets.add(Lotto.generateRandomly());
        }

        return new LottoTickets(lottoTickets);
    }
}
