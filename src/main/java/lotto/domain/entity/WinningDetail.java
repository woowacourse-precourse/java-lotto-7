package lotto.domain.entity;

import java.util.Arrays;
import java.util.Map;

import lotto.domain.vo.WinningRank;

public class WinningDetail {
    private static final int UPDATE_SCORE = 1;

    private final Map<WinningRank, Integer> winningDetail;

    public WinningDetail(Map<WinningRank, Integer> winningDetail) {
        this.winningDetail = winningDetail;
    }

    public void updateScore(WinningRank rank) {
        winningDetail.replace(rank, winningDetail.getOrDefault(rank, 0) + UPDATE_SCORE);
    }

    public String generateWinningStatistics() {
        StringBuilder statistics = new StringBuilder();

        Arrays.stream(WinningRank.values())
            .filter(rank -> rank != WinningRank.NONE)
            .forEach(rank ->
                statistics.append(rank.getWinningMessage(winningDetail.get(rank)))
            );

        return statistics.toString();
    }

    public long calculateTotalPrizeMoney() {
        return winningDetail.entrySet().stream()
            .mapToLong(entry ->
                (long)entry.getKey().getPrizeMoney() * entry.getValue())
            .sum();
    }

}
