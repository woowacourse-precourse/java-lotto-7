package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import lotto.model.Lotto;
import lotto.model.Rank;

public class RankCalculator {

    public static Rank calculateRank(Lotto lottoTicket, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = lottoTicket.countMatchingNumbersWithWinningNumbers(winningNumbers);
        boolean bonusMatched = lottoTicket.isBonusNumberMatched(bonusNumber);
        return getRankBasedOnMatchCount(matchCount, bonusMatched).orElse(Rank.NONE);
    }

    private static Optional<Rank> getRankBasedOnMatchCount(int matchCount, boolean bonusMatched) {
        return Arrays.stream(Rank.values())
                .filter(rank -> matchesRankCriteria(rank, matchCount, bonusMatched))
                .findFirst();
    }

    private static boolean matchesRankCriteria(Rank rank, int matchCount, boolean bonusMatched) {
        // 번호 개수가 일치하지 않으면 바로 false
        if (rank.getMatchCount() != matchCount) {
            return false;
        }
        // 해당 랭크가 보너스 번호 당첨 필수이면 보너스 번호 추가 검사
        return !rank.requiresBonus() || bonusMatched;
    }

}
