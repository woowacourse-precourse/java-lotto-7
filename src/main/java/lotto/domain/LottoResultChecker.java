package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoResultChecker {

    public static final int MATCH_SIX = 6;
    public static final int MATCH_FIVE = 5;
    public static final int MATCH_FOUR = 4;
    public static final int MATCH_THREE = 3;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoResultChecker(final List<Integer> winningNumbers, final int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoRank> checkRank(final List<Lotto> lottos) {

        final List<LottoRank> ranks = new ArrayList<>();

        final Set<Integer> winningNumbers = new HashSet<>(this.winningNumbers);

        lottos.forEach(lotto -> {
            long matchingCount = lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            boolean hasBonus = lotto.getNumbers().contains(bonusNumber);

            final LottoRank rank = validRank(matchingCount, hasBonus);

            ranks.add(rank);
        });

        return ranks;
    }

    private LottoRank validRank(final long matchingCount, final boolean hasBonus) {
        if (matchingCount == MATCH_SIX) {
            return LottoRank.FIRST;
        }

        if (matchingCount == MATCH_FIVE && hasBonus) {
            return LottoRank.SECOND;
        }

        if (matchingCount == MATCH_FIVE) {
            return LottoRank.THIRD;
        }

        if (matchingCount == MATCH_FOUR) {
            return LottoRank.FOURTH;
        }

        if (matchingCount == MATCH_THREE) {
            return LottoRank.FIFTH;
        }

        return LottoRank.NO_MATCH;
    }
}
