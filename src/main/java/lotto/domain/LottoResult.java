package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> matchNumber;
    private final LottoShop lottoShop;
    private final Lotto winningLotto;

    public LottoResult(LottoShop lottoShop, Lotto winningLotto) {
        this.lottoShop = lottoShop;
        this.winningLotto = winningLotto;
        matchNumber = new HashMap<>();
        calculateMatchLotto();
    }

    public Map<Integer, Integer> getMatchNumber() {
        return matchNumber;
    }

    private void calculateMatchLotto() {
        lottoShop.getLottoTickets().getLotteries().stream()
                .filter(lotto -> !getMatchingNumbers(lotto).isEmpty())
                .forEach(this::addMatchingLotto);
    }

    private void addMatchingLotto(Lotto lotto) {
        int matchedCount = getMatchingNumbers(lotto).size();
        if (matchedCount >= 3) {
            matchNumber.put(matchedCount, matchNumber.getOrDefault(matchedCount, 0) + 1);
        }
    }

    private List<Integer> getMatchingNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .toList();
    }
}
