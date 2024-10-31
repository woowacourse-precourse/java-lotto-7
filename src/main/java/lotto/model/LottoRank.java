package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum LottoRank {
    RANK_1(2_000_000_000, 6, false),
    RANK_2(30_000_000, 5, true),
    RANK_3(1_500_000, 5, false),
    RANK_4(50_000, 4, false),
    RANK_5(5_000, 3, false),
    LOSE(0, 0, false);

    final int prizeMoney;
    final int matchCount;
    final boolean matchBonus;

    LottoRank(int prizeMoney, int matchCount, boolean matchBonus) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public LottoRank by(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return LOSE;
        }

        Optional<LottoRank> rank = Arrays.stream(LottoRank.values())
                .filter((lottoRank) -> lottoRank.matchCount == matchCount && lottoRank.matchBonus == matchBonus)
                .findFirst();

        if (rank.isEmpty()) {
            throw new IllegalStateException(matchCount + "개가 일치하는 등수는 존재하지 않습니다.");
        }

        return rank.get();
    }
}
