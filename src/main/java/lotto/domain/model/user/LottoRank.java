package lotto.domain.model.user;

import java.util.Arrays;
import java.util.function.BiFunction;

import static lotto.common.constant.PrintFormatConst.*;

public enum LottoRank {

    NONE(0, false, 0, (matchCount, isBonus) -> matchCount <= 2),
    FIFTH(3, false, 5_000, (matchCount, isBonus) -> matchCount == 3),
    FOURTH(4, false, 50_000, (matchCount, isBonus) -> matchCount == 4),
    THIRD(5, false, 1_500_000, (matchCount, isBonus) -> matchCount == 5 && !isBonus),
    SECOND(5, true, 30_000_000, (matchCount, isBonus) -> matchCount == 5 && isBonus),
    FIRST(6, false, 2_000_000_000, (matchCount, isBonus) -> matchCount == 6);

    private final int matchCount;
    private final boolean isBonus;
    private final long prize;
    private final BiFunction<Integer, Boolean, Boolean> exp;

    LottoRank(int matchCount, boolean isBonus, long prize, BiFunction<Integer, Boolean, Boolean> exp) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.prize = prize;
        this.exp = exp;
    }

    public long getPrize() {
        return prize;
    }

    public static LottoRank[] getWinningRanks() {
        return Arrays.stream(values())
                .filter(rank -> rank != NONE)
                .toArray(LottoRank[]::new);
    }

    public String getPrintFormat() {
        if (isBonus) {
            return String.format(LOTTO_RESULT_BONUS_PRINT, matchCount, prize);
        }
        return String.format(LOTTO_RESULT_NORMAL_PRINT, matchCount, prize);
    }

    public boolean win(int count, boolean bonus) {
        return exp.apply(count, bonus);
    }

    public static LottoRank getMatchedLotto(int matchCount, boolean bonusMatched) {
        return Arrays.stream(LottoRank.values())
                .filter(rank -> rank.win(matchCount, bonusMatched))
                .findFirst()
                .orElse(LottoRank.NONE);
    }
}

