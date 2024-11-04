package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMachine {
    public List<Lotto> generateTickets(int purchaseAmount) {
        int ticketCount = purchaseAmount / 1000;
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateLotto());
        }
        return tickets;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0, 6));
    }

    public LottoResult calculateResults(List<Lotto> tickets, List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();
        for (Lotto ticket : tickets) {
            int matchCount = (int) ticket.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            boolean bonusMatch = ticket.getNumbers().contains(bonusNumber);
            result.updateStatistics(matchCount, bonusMatch);
        }
        return result;
    }
}

