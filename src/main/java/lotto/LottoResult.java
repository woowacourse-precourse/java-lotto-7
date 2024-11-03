package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
	private final Map<WinningRank, Integer> rankCounts;

    public LottoResult(List<Lotto> lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        this.rankCounts = new EnumMap<>(WinningRank.class);
        initializeRankCounts();
        calculateResults(lottos, winningNumber, bonusNumber);
    }

    private void initializeRankCounts() {
        Arrays.stream(WinningRank.values())
                .forEach(rank -> rankCounts.put(rank, 0));
    }

    private void calculateResults(List<Lotto> lottos, WinningNumber winningNumber, BonusNumber bonusNumber) {
        lottos.forEach(lotto -> {
            WinningRank rank = calculateRank(lotto, winningNumber, bonusNumber);
            rankCounts.merge(rank, 1, Integer::sum);
        });
    }

    private WinningRank calculateRank(Lotto lotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        int matchCount = countMatches(lotto, winningNumber);
        boolean matchBonus = matchCount == 5 && 
                lotto.getNumbers().contains(bonusNumber.getNumber());
        return WinningRank.calculate(matchCount, matchBonus);
    }

    private int countMatches(Lotto lotto, WinningNumber winningNumber) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningNumber.getLotto().getNumbers().contains(number))
                .count();
    }

    public Map<WinningRank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCounts);
    }

}
