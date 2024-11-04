package lotto.global.enums;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public enum WinningLottoRank {
    FIFTH_PLACE(3, 0, 5000),
    FOURTH_PLACE(4, 0, 50000),
    THIRD_PLACE(5, 0, 1500000),
    SECOND_PLACE(5, 1, 30000000),
    FIRST_PLACE(6, 0, 2000000000);

    private final Integer drawnNumberCount;
    private final Integer bonusCount;
    private final Integer prizeMoney;

    WinningLottoRank(Integer drawnNumberCount, Integer bonusCount, Integer prizeMoney) {
        this.drawnNumberCount = drawnNumberCount;
        this.bonusCount = bonusCount;
        this.prizeMoney = prizeMoney;
    }

    public Integer getDrawnNumberCount() {
        return drawnNumberCount;
    }

    public Integer getPrizeMoney() {
        return prizeMoney;
    }

    // 모든 값을 비교하여 일치된 추첨 번호 수와 보너스 번호 수를 통해 WinningLottoRank 반환
    public static Optional<WinningLottoRank> getRankMatchedBy(Integer drawnNumberMatchCount,
                                                              Integer bonusNumberMatchCount) {
        List<WinningLottoRank> winningLottoRanks = Arrays.stream(WinningLottoRank.values())
                .sorted(Comparator.comparing(WinningLottoRank::getPrizeMoney).reversed()).toList();

        return winningLottoRanks.stream()
                .filter(lottoDrawRank -> lottoDrawRank.isRankMatchedBy(drawnNumberMatchCount, bonusNumberMatchCount))
                .findFirst();
    }

    private Boolean isRankMatchedBy(Integer drawnNumberMatchCount, Integer bonusNumberMatchCount) {
        if (this == SECOND_PLACE) {
            return Objects.equals(drawnNumberCount, drawnNumberMatchCount) && Objects.equals(bonusCount,
                    bonusNumberMatchCount);
        }
        return Objects.equals(drawnNumberCount, drawnNumberMatchCount);
    }
}
