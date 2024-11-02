package lotto.model.constant;

import java.util.List;

public enum LottoRank {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    OTHERS(0);

    private final int winningPrize;

    LottoRank(int winningPrize) {
        this.winningPrize = winningPrize;
    }

    public int getWinningPrize() {
        return winningPrize;
    }
}
