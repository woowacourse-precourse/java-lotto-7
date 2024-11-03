package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(int amount) {
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
