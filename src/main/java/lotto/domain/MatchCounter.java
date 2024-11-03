package lotto.domain;

import lotto.dto.MatchResult;
import lotto.dto.MatchResults;
import lotto.dto.SortedIssuedTickets;

import java.util.ArrayList;
import java.util.List;

public class MatchCounter {

    private final Lotto lotto;
    private final Bonus bonus;

    public MatchCounter(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public MatchResults calculateMatchResults(SortedIssuedTickets tickets) {
        List<MatchResult> results = new ArrayList<>();

        for (List<Integer> ticket : tickets.sortedTickets()) {
            int matchCount = countMatchingNumbers(ticket);
            boolean hasBonus = ticket.contains(bonus.getNumber());
            results.add(new MatchResult(matchCount, hasBonus));
        }

        return new MatchResults(results);
    }

    private int countMatchingNumbers(List<Integer> ticket) {
        return (int) ticket.stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }
}
