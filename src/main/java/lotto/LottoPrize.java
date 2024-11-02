package lotto;

import lotto.constant.LottoConfig.BonusCheck;
import lotto.constant.LottoConfig.Rank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.constant.LottoConfig.Rank.*;

public class LottoPrize {
    private final Lotto lotto;
    private final Bonus bonus;

    public LottoPrize(Lotto lotto, Bonus bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Map<Rank, Integer> determineLottoPrizes(Lottos lottos) {
        Map<Rank, Integer> rankCount = new HashMap<>();

        for(Lotto ticket : lottos.getTickets()) {
            Rank rank = determineRank(lotto.getNumbers(), ticket.getNumbers());
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

    private Rank determineRank(List<Integer> prizeNumbers, List<Integer> userNumbers) {
        int matchedCount = getMatchedCount(prizeNumbers, userNumbers);
        BonusCheck bonusCheck = checkBonusMatch(userNumbers);
        return checkRank(matchedCount, bonusCheck);
    }

    private int getMatchedCount(List<Integer> prizeNumbers, List<Integer> userNumbers) {
        return (int) prizeNumbers.stream()
                .filter(userNumbers::contains)
                .count();
    }

    private BonusCheck checkBonusMatch(List<Integer> userNumbers) {
        if(userNumbers.contains(bonus.getNumber())) {
            return BonusCheck.TRUE;
        }
        return BonusCheck.FALSE;
    }

    private Rank checkRank(int matchedCount, BonusCheck bonusCheck) {
        return Arrays.stream(Rank.values())
                .filter(rank -> findMatchedRank(matchedCount, bonusCheck, rank))
                .findFirst()
                .orElse(NOTHING);
    }

    private boolean findMatchedRank(int matchedCount, BonusCheck bonusCheck, Rank rank) {
        return rank.getMatchedCount() == matchedCount &&
                (rank.isBonusMatched() == BonusCheck.ALL ||
                        rank.isBonusMatched() == bonusCheck);
    }
}
