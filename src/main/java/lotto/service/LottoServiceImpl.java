package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Rank;
import lotto.model.RankCount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoServiceImpl implements LottoService {
    @Override
    public int calculateLottoCount(int price) {
        return price / 1000;
    }

    @Override
    public List<Integer> pickLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

    @Override
    public List<RankCount> calculateWinningStatistics(Lottos lottos, Lotto winningNumbers, Integer bonusNumber) {
        List<RankCount> rankCounts = initializeRankCounts();

        for (Lotto lotto : lottos) {
            int matchCount = calculateMatchCount(lotto.getNumbers(), winningNumbers.getNumbers());
            boolean hasBonus = containsBonusNumber(lotto.getNumbers(), bonusNumber);

            updateRankCounts(rankCounts, matchCount, hasBonus);
        }

        return rankCounts;
    }

    private List<RankCount> initializeRankCounts() {
        return Arrays.asList(
                new RankCount(Rank.FIFTH),
                new RankCount(Rank.FOURTH),
                new RankCount(Rank.THIRD),
                new RankCount(Rank.SECOND),
                new RankCount(Rank.FIRST)
        );
    }

    private int calculateMatchCount(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean containsBonusNumber(List<Integer> lottoNumbers, Integer bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private void updateRankCounts(List<RankCount> rankCounts, int matchCount, boolean hasBonus) {
        if (matchCount == 3)
            rankCounts.get(0).incrementCount();

        if (matchCount == 4)
            rankCounts.get(1).incrementCount();

        if (matchCount == 5 && !hasBonus)
            rankCounts.get(2).incrementCount();

        if (matchCount == 5 && hasBonus)
            rankCounts.get(3).incrementCount();

        if (matchCount == 6)
            rankCounts.get(4).incrementCount();
    }

    @Override
    public double calculateProfitability(List<RankCount> winningStatistics, int purchasePrice) {
        long prizeSum = 0;
        for (RankCount rankCount: winningStatistics) {
            prizeSum += calculatePrizeForRankCount(rankCount);
        }
        double profitability = (double) prizeSum / purchasePrice * 100;
        return Math.round(profitability * 10.0) / 10.0;
    }

    private long calculatePrizeForRankCount(RankCount rankCount) {
        if (rankCount.getCount() != 0) {
            return (long) rankCount.getCount() * rankCount.getRank().getPrize();
        }
        return 0;
    }
}
