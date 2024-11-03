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

        this.lottoTickets = lottoTickets;
    }

    private Lotto generateLottoTicket() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public List<List<Integer>> getLottoTicketsNumbers() {
        List<List<Integer>> lottoTicketsNumbers = new ArrayList<>();

        for (Lotto lotto : lottoTickets) {
            lottoTicketsNumbers.add(lotto.getNumbers());
        }

        return lottoTicketsNumbers;
    }
}
