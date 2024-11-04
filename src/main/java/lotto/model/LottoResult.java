package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoResult {
    private final Map<Rank, Integer> ranks;

    public LottoResult(
            List<Lotto> lottoTickets, Set<Integer> winningNumbers, int bonusNumber) {
        ranks = calculate(lottoTickets, winningNumbers, bonusNumber);
    }

    private Map<Rank, Integer> calculate(
            List<Lotto> lottoTickets, Set<Integer> winningNumbers, int bonusNumber
    ) {
        Map<Rank, Integer> result = new HashMap<>();

        return getResult(result, lottoTickets, winningNumbers, bonusNumber);
    }

    private Map<Rank, Integer> getResult(
            Map<Rank, Integer> ranks, List<Lotto> lottoTickets, Set<Integer> winningNumbers, int bonusNumber
    ) {
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0);
        }

        for (Lotto ticket : lottoTickets) {
            int matchCount = checkTickets(ticket, winningNumbers);
            boolean isBonus = ticket.getNumbers().contains(bonusNumber);

            if (isBonus) {
                matchCount++;
            }
            Rank rank = Rank.createLottoRank(matchCount, isBonus);
            ranks.put(rank, ranks.get(rank) + 1);
        }

        return ranks;
    }

    private int checkTickets(Lotto lotto, Set<Integer> winningNumbers) {
        int matchCount = 0;

        for (Integer number : lotto.getNumbers()) {
            if (isContain(winningNumbers, number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private boolean isContain(Set<Integer> winningNumbers, int number) {
        return winningNumbers.contains(number);
    }

    public Map<Rank, Integer> getRanks() {
        return ranks;
    }
}
