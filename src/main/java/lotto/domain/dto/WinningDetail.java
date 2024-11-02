package lotto.domain.dto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

import lotto.domain.vo.WinningRank;

public class WinningDetail {
    private static final int UPDATE_SCORE = 1;

    private final Map<WinningRank, Integer> winningDetail;

    private WinningDetail(Map<WinningRank, Integer> winningDetail) {
        this.winningDetail = winningDetail;
    }

    public static WinningDetail create() {
        Map<WinningRank, Integer> detail = new EnumMap<>(WinningRank.class);
        for (WinningRank rank : WinningRank.values()) {
            detail.put(rank, 0);
        }
        return new WinningDetail(detail);
    }

    public Map<WinningRank, Integer> getWinningDetail() {
        return winningDetail;
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

}
