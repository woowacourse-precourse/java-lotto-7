package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class LottoResult {
    private final EnumMap<Rank, Long> ranks;

    public LottoResult(
            List<Lotto> lottoTickets, Set<Integer> winningNumbers, int bonusNumber) {
        ranks = calculate(lottoTickets, winningNumbers, bonusNumber);
    }

    private EnumMap<Rank, Long> calculate(
            List<Lotto> lottoTickets, Set<Integer> winningNumbers, int bonusNumber
    ) {
        EnumMap<Rank, Long> result = new EnumMap<>(Rank.class);

        return getResult(result, lottoTickets, winningNumbers, bonusNumber);
    }

    private EnumMap<Rank, Long> getResult(
            EnumMap<Rank, Long> ranks, List<Lotto> lottoTickets, Set<Integer> winningNumbers, int bonusNumber
    ) {
        for (Rank rank : Rank.values()) {
            ranks.put(rank, 0L);
        }

        for (Lotto ticket : lottoTickets) {
            int matchCount = checkTickets(ticket, winningNumbers);
            boolean isBonus = isContain(winningNumbers, bonusNumber);

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

    public EnumMap<Rank, Long> getRanks() {
        return ranks;
    }
}
