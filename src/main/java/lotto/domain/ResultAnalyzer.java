package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResultAnalyzer {

    public int calculateRank(List<Integer> numbers, int bonusNumber, Lotto ticket) {
        Set<Integer> ticketNumbers = new HashSet<>(ticket.getNumbers());
        Set<Integer> winningNumbers = new HashSet<>(numbers);

        boolean bonusMatch = ticketNumbers.contains(bonusNumber);

        ticketNumbers.retainAll(winningNumbers);
        int matchCount = ticketNumbers.size();

        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5 && bonusMatch) {
            return 2;
        }
        if (matchCount == 5) {
            return 3;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 3) {
            return 5;
        }
        return 0;
    }

    public List<Integer> calculateRanks(List<Integer> numbers, int bonusNumber, List<Lotto> tickets) {
        List<Integer> ranks = new ArrayList<>();
        for (Lotto ticket : tickets) {
            ranks.add(calculateRank(numbers, bonusNumber, ticket));
        }
        return ranks;
    }
}
