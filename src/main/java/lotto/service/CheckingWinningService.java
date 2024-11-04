package lotto.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class CheckingWinningService {

    public List<Integer> getNumberOfMatches(List<Lotto> LottoTickets, List<Integer> winningNumbers) {
        return LottoTickets.stream()
                .map(lotto -> (int) lotto.getNumbers().stream()
                        .filter(winningNumbers::contains)
                        .count())
                .collect(Collectors.toList());
    }

    public void checkBonusWinning(List<Lotto> LottoTickets, List<Integer> numberOfMatches, int bonusNumber) {
        for (int i = 0; i < numberOfMatches.size(); i++) {
            if(numberOfMatches.get(i) == 5) {
                numberOfMatches.set(i, matchBonusNumber(LottoTickets.get(i), bonusNumber));
            }
        }
    }

    private int matchBonusNumber(Lotto LottoTicketOf5matches, int bonusNumber) {
        boolean isMatchedWithBonus = LottoTicketOf5matches.getNumbers().stream().anyMatch(number -> number == bonusNumber);
        if(isMatchedWithBonus) {
            return 10;
        }
        return 5;
    }

    public Map<Integer, Integer> calculateRanks(List<Integer> numberOfMatches) {
        int firstRank = Collections.frequency(numberOfMatches, 6);
        int secondRank = Collections.frequency(numberOfMatches, 10);
        int thirdRank = Collections.frequency(numberOfMatches, 5);
        int fourthRank = Collections.frequency(numberOfMatches, 4);
        int fifthRank = Collections.frequency(numberOfMatches, 3);

        Map<Integer, Integer> ranks = new HashMap<>(5);
        ranks.put(firstRank, 2_000_000_000);
        ranks.put(secondRank, 3_000_000);
        ranks.put(thirdRank, 1_500_000);
        ranks.put(fourthRank, 50_000);
        ranks.put(fifthRank, 5_000);

        return ranks;
    }

    public double calculateRateOfReturn(Map<Integer, Integer> ranks, int payment) {
        double sum = 0;
        for (int numberOfWinning : ranks.keySet()) {
            sum += numberOfWinning * ranks.get(numberOfWinning);
        }

        sum /= payment;
        sum *= 100;

        return Math.round(sum * 100) / 100.0;
    }
}
