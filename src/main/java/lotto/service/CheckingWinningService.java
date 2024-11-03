package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class CheckingWinningService {

    private List<Integer> getNumberOfMatches(List<Lotto> LottoTickets, List<Integer> winningNumbers) {
        return LottoTickets.stream()
                .map(lotto -> (int) lotto.getNumbers().stream()
                        .filter(winningNumbers::contains)
                        .count())
                .collect(Collectors.toList());
    }

    private void checkBonusWinning(List<Lotto> LottoTickets, List<Integer> numberOfMatches, int bonusNumber) {
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
}
