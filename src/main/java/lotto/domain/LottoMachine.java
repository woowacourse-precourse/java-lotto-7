package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int TICKET_PRICE = 1000;

    public List<Lotto> generateTickets(int amount) {
        validatePurchaseAmount(amount);
        int ticketCount = amount / TICKET_PRICE;
        return createTickets(ticketCount);
    }

    public void validatePurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        }
        if (amount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private List<Lotto> createTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return tickets;
    }

    public LottoResult calculateResult(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();
        tickets.forEach(ticket -> result.addResult(ticket.match(winningNumbers, bonusNumber)));
        return result;
    }
}
