package lotto.ui.dto;

import lotto.domain.winning.LottoRank;

public class WinningCountByPrize {

    private final int rank;
    private final int matchCount;
    private final int prizeMoney;
    private final int winningCount;

    private WinningCountByPrize(int rank, int matchCount, int prizeMoney, int winningCount) {
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.winningCount = winningCount;
    }

    public static WinningCountByPrize of(LottoRank lottoRank, int winningCount) {
        return new WinningCountByPrize(
                lottoRank.getRank(),
                lottoRank.getMatchCount(),
                lottoRank.getPrizeMoney(),
                winningCount
        );
    }

    public int getRank() {
        return rank;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public int getWinningCount() {
        return winningCount;
    }
}
