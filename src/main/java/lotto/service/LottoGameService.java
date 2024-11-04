package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoIssuer;
import lotto.model.LottoPurchase;

public class LottoGameService {
    private final LottoIssuer lottoIssuer = new LottoIssuer();

    public LottoPurchase createLottoPurchase(int purchaseAmount) {
        return new LottoPurchase(purchaseAmount);
    }

    public List<Lotto> generateLottoTickets(LottoPurchase lottoPurchase) {
        int count = lottoPurchase.getAmount() / 1000;
        List<Lotto> tickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Lotto lotto = lottoIssuer.issue();
            tickets.add(lotto);
        }
        return tickets;
    }
}
