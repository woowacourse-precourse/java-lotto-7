package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> matchNumber;
    private final LottoShop lottoShop;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public LottoResult(LottoShop lottoShop, Lotto winningLotto, int bonusNumber) {
        this.lottoShop = lottoShop;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        matchNumber = new HashMap<>();
        calculateMatchLotto();
    }

    public Map<Rank, Integer> getMatchNumber() {
        return matchNumber;
    }

    private void calculateMatchLotto() {
        lottoShop.getLottoTickets().getLotteries().stream()
                .filter(lotto -> !getMatchingNumbers(lotto).isEmpty())
                .forEach(this::addMatchingLotto);
    }

    private void addMatchingLotto(Lotto lotto) {
        int matchedCount = getMatchingNumbers(lotto).size();
        Rank rank = getCorrectRank(lotto, matchedCount);

        if (rank != Rank.NOT_MATCH) {
            matchNumber.put(rank, matchNumber.getOrDefault(rank, 0) + 1);
        }
    }

    private List<Integer> getMatchingNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .toList();
    }

    private Rank getCorrectRank(Lotto lotto, int matchedCount) {
        if (matchedCount == 6) {
            return Rank.FIRST_PLACE;
        }
        if (matchedCount == 5) {
            return getSecondOrThirdPlaceRank(lotto);
        }
        if (matchedCount == 4) {
            return Rank.FOURTH_PLACE;
        }
        if (matchedCount == 3) {
            return Rank.FIFTH_PLACE;
        }
        return Rank.NOT_MATCH;
    }

    private Rank getSecondOrThirdPlaceRank(Lotto lotto) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            return Rank.SECOND_PLACE;
        }
        return Rank.THIRD_PLACE;
    }

    public long calculateWinningPrize() {
        return matchNumber.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().prize * entry.getValue())
                .sum();
    }
}
