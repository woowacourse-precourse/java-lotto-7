package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottoTickets;

    public LottoTickets(int money) {
        int amount = money / LOTTO_PRICE;
        List<Lotto> lottoTickets = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottoTickets.add(generateLottoTicket());
        }

        this.lottoTickets = List.copyOf(lottoTickets);
    }

    private Lotto generateLottoTicket() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
