package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.util.LottoNumberGenerator;

public class LottoTickets {
    private final List<Lotto> lottoTickets;

    public LottoTickets(LottoPurchaseMoney purchaseMoney) {
        this.lottoTickets = generateLottoTickets(purchaseMoney);
    }

    private List<Lotto> generateLottoTickets(LottoPurchaseMoney purchaseMoney) {
        int lottoCount = purchaseMoney.calculateLottoCount();
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            tickets.add(new Lotto(LottoNumberGenerator.generate()));
        }
        return tickets;
    }

    public List<Lotto> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public int size() {
        return lottoTickets.size();
    }
}
