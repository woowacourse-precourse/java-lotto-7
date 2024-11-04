package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.LottoManager;

public class WinReward {
    private static final int INITIAL_COUNT = 0;
    private final Map<Rank, Integer> details;
    private final LottoManager lottoManager;

    public WinReward(LottoManager lottoManager) {
        this.details = new EnumMap<>(Rank.class);
        this.lottoManager = lottoManager;
        Arrays.stream(Rank.values()).forEach(rank -> details.put(rank, INITIAL_COUNT));
    }

    public void addRank(Rank rank) {
        details.merge(rank, 1, Integer::sum);
    }

    public int getTotalReward() {
        return (int) details.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getReward() * entry.getValue())
                .sum();
    }

    @Override
    public String toString() {
        return details.entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.MISS)
                .sorted(Map.Entry.<Rank, Integer>comparingByKey().reversed())
                .map(entry -> String.format("%s - %d개%n", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining());
    }

    public Rank match(Lotto lotto) {
        int matchCount = lotto.getMatchCount(lottoManager.getWinningNumbers()); // Assumes getMatchCount() is implemented in Lotto
        boolean hasBonus = lotto.hasBonusNumber(lottoManager.getBonusNumber()); // Assumes hasBonusNumber() is implemented in Lotto

        return Rank.of(matchCount, hasBonus); // Uses Rank.of() to get the matching Rank
    }
}