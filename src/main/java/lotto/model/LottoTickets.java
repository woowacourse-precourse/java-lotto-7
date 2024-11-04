package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<Lotto> tickets;

    public LottoTickets(int ticketCount) {
        tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            tickets.add(lotto);
        }
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
