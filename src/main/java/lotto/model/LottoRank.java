package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum LottoRank {
    RANK_1(2_000_000_000, 6, false),
    RANK_2(30_000_000, 5, true),
    RANK_3(1_500_000, 5, false),
    RANK_4(50_000, 4, false),
    RANK_5(5_000, 3, false),
    LOSE(0, 0, false);

    public final int prizeMoney;
    public final int matchCount;
    public final boolean matchBonus;

    LottoRank(int prizeMoney, int matchCount, boolean matchBonus) {
        this.prizeMoney = prizeMoney;
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
    }

    public static List<LottoRank> rankListWithBonus() {
        return Arrays.stream(LottoRank.values()).filter(lotto -> lotto.matchBonus).toList();
    }

    public static LottoRank by(int matchCount, boolean matchBonus) {
        if (matchCount < 3) {
            return LOSE;
        }

        Optional<LottoRank> rank = Arrays.stream(LottoRank.values())
                .filter(lottoRank -> lottoRank.matchCount == matchCount && lottoRank.matchBonus == matchBonus)
                .findFirst();

        if (rank.isEmpty()) {
            throwNotExistRankException(matchCount, matchBonus);
        }

        return rank.get();
    }

    private static void throwNotExistRankException(int matchCount, boolean matchBonus) {
        if (matchBonus) {
            throw new IllegalStateException(matchCount + "개와 보너스번호가 일치하는 등수는 존재하지 않습니다.");
        }

        throw new IllegalStateException(matchCount + "개가 일치하고 보너스 번호가 일치하지 않는 등수는 존재하지 않습니다.");
    }
}
