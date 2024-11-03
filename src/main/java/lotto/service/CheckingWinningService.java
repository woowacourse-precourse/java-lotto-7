package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class CheckingWinningService {
    public List<Integer> getNumberOfMatches(List<Lotto> LottoTickets, List<Integer> winningNumbers) {
        List<Integer> numberOfMatches = LottoTickets.stream()
                .map(lotto -> (int) lotto.getNumbers().stream()
                        .filter(winningNumbers::contains)
                        .count())
                .collect(Collectors.toList());

        return numberOfMatches;
    }
}
