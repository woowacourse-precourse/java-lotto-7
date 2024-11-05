package lotto.domain;

import static lotto.util.LottoConstants.DEFAULT;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int MATCHED_COUNT_FOR_FIRST_PLACE = 6;
    private static final int MATCHED_COUNT_FOR_SECOND_OR_THIRD_PLACE = 5;
    private static final int MATCHED_COUNT_FOR_FOURTH_PLACE = 4;
    private static final int MATCHED_COUNT_FOR_FIFTH_PLACE = 3;
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
            matchNumber.put(rank, matchNumber.getOrDefault(rank, DEFAULT.getValue()) + 1);
        }
    }

    private List<Integer> getMatchingNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .toList();
    }

    private Rank getCorrectRank(Lotto lotto, int matchedCount) {
        if (matchedCount == MATCHED_COUNT_FOR_FIRST_PLACE) {
            return Rank.FIRST_PLACE;
        }
        if (matchedCount == MATCHED_COUNT_FOR_SECOND_OR_THIRD_PLACE) {
            return getSecondOrThirdPlaceRank(lotto);
        }
        if (matchedCount == MATCHED_COUNT_FOR_FOURTH_PLACE) {
            return Rank.FOURTH_PLACE;
        }
        if (matchedCount == MATCHED_COUNT_FOR_FIFTH_PLACE) {
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
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
