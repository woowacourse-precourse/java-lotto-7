package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoPrize {
    EMPTY(0, 0, (matchCount, isContainBonusNumber) -> matchCount < 3),
    FIFTH(5_000, 3, (matchCount, isContainBonusNumber) -> matchCount == 3),
    FOURTH(50_000, 4, (matchCount, isContainBonusNumber) -> matchCount == 4),
    THIRD(1_500_000, 5, (matchCount, isContainBonusNumber) -> matchCount == 5 && !isContainBonusNumber),
    SECOND(30_000_000, 5, (matchCount, isContainBonusNumber) -> matchCount == 5 && isContainBonusNumber),
    FIRST(2_000_000_000, 6, (matchCount, isContainBonusNumber) -> matchCount == 6);

    private final int reward;
    private final int matchCount;
    private final BiPredicate<Integer, Boolean> isMatch;

    LottoPrize(final int reward, final int matchCount, final BiPredicate<Integer, Boolean> isMatch) {
        this.reward = reward;
        this.matchCount = matchCount;
        this.isMatch = isMatch;
    }

    public static LottoPrize getLottoPrize(final int matchCount, final boolean isContainBonusNumber) {
        return Arrays.stream(LottoPrize.values())
                .filter(lottoPrize -> lottoPrize.isMatch.test(matchCount, isContainBonusNumber))
                .findAny()
                .orElse(EMPTY);
    }

    public int getReward() {
        return reward;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
