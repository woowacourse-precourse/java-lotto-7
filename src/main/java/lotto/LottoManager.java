package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {

    public Lotto issue() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.START_RANGE, Lotto.END_RANGE, Lotto.NUMBER_COUNT);
        return new Lotto(numbers);
    }

    public double getYield(List<Rank> rankResult) {
        double winnings = getWinnings(rankResult);
        double payment = Lotto.PRICE * rankResult.size();
        return (winnings / payment) * 100;
    }

    public int getWinnings(List<Rank> rankResult) {
        return rankResult.stream()
                .filter(rank -> rank != null)
                .mapToInt(Rank::getReward)
                .sum();
    }

    public Rank getRank(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = getMatchCount(lotto, winningNumbers);
        boolean hasBonusNumber = hasBonusNumber(lotto, bonusNumber);

        if (matchCount == Rank.SECOND.getMatchCount() && hasBonusNumber) {
            return Rank.SECOND;
        }

        return Rank.RANK_ASC.stream()
                .filter(rank -> matchCount == rank.getMatchCount())
                .findFirst()
                .orElse(null);
    }

    public Map<Rank, Integer> getRankCountMap(List<Rank> rankResult) {
        Map<Rank, Integer> rankCountMap = new HashMap<>();

        for (Rank rank : rankResult) {
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }

        return rankCountMap;
    }

    public boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public int getMatchCount(Lotto lotto, List<Integer> winningNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
