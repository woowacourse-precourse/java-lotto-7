package lotto.lotto;

import static lotto.lotto.Rank.initializeRankCounts;

import java.util.EnumMap;

public class WinningResult {

    private final WinningNumbers winningNumbers;
    private final Number bonusNumber;
    private final EnumMap<Rank, Integer> rankCounts;

    public WinningResult(WinningNumbers winningNumbers, Number bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.rankCounts = initializeRankCounts();
    }
}
