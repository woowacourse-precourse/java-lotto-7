package lotto.model;

import static lotto.common.AppErrorType.NOT_EXIST_MATCHED_WITHOUT_BONUS_RANK_ERROR;
import static lotto.common.AppErrorType.NOT_EXIST_MATCHED_WITH_BONUS_RANK_ERROR;

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

    private static int LOWEST_RANK_MATCH_COUNT = 3;
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
        if (matchCount < LOWEST_RANK_MATCH_COUNT) {
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
            throw new IllegalStateException(NOT_EXIST_MATCHED_WITH_BONUS_RANK_ERROR.getMessage(matchCount));
        }

        throw new IllegalStateException(NOT_EXIST_MATCHED_WITHOUT_BONUS_RANK_ERROR.getMessage(matchCount));
    }
}
