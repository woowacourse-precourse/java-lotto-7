package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BuyTicket {
    private final List<Lotto> tickets = new ArrayList<>();

    public BuyTicket(int purchaseAmount) {
        int ticketCount = purchaseAmount / 1000;
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateLotto());
        }
    }

    private Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
