package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private List<Integer> matchNumber;

    public LottoResult(List<Integer> matchNumber) {
        this.matchNumber = matchNumber;
    }

    public static LottoResult calculateResult(LottoShop lottoShop, Lotto winningLotto, int bonusNumber) {
        List<Integer> matchedCounts = new ArrayList<>();

        List<Lotto> matchingLotteries = lottoShop.getLottoTickets().getLotteries().stream()
                .filter(lotto -> !getMatchingNumbers(lotto, winningLotto).isEmpty()).toList();

        matchingLotteries.forEach(lotto -> {
            List<Integer> matchedNumbers = getMatchingNumbers(lotto, winningLotto);
            int matchedCount = matchedNumbers.size();
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);
            matchedCounts.add(matchedCount);
        });
        return new LottoResult(matchedCounts);
    }

    private static List<Integer> getMatchingNumbers(Lotto lotto, Lotto winningLotto) {
        return lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .toList();
    }
}
