package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

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

    public int[] getRankCount(List<Rank> rankResult) {
        int[] rankCount = new int[Rank.MAX_RANK];
        rankResult.stream()
                .filter(rank -> rank != null)
                .forEach(rank -> rankCount[rank.getIndex()]++);
        return rankCount;
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
