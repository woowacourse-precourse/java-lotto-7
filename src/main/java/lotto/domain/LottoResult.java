package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoResult {
    NONE(0, false, 0, (matchedCount, isBonusMatched) -> matchedCount < 3),
    FIFTH(3, false, 5000, (matchedCount, isBonusMatched) -> matchedCount == 3),
    FOURTH(4, false, 50000, (matchedCount, isBonusMatched) -> matchedCount == 4),
    THIRD(5, false, 1500000, (matchedCount, isBonusMatched) -> (matchedCount == 5 && !isBonusMatched)),
    SECOND(5, true, 30000000, (matchedCount, isBonusMatched) -> (matchedCount == 5 && isBonusMatched)),
    FIRST(6, false, 2000000000, (matchedCount, isBonusMatched) -> matchedCount == 6);

    private int matchedCount;
    private boolean isBonusMatched;
    private int rewardAmount;
    private BiPredicate<Integer, Boolean> check;

    LottoResult(int matchedCount, boolean isBonusMatched, int rewardAmount, BiPredicate<Integer, Boolean> check) {
        this.matchedCount = matchedCount;
        this.isBonusMatched = isBonusMatched;
        this.rewardAmount = rewardAmount;
        this.check = check;
    }

    public static LottoResult findLottoResult(int matchedCount, boolean isBonusMatched) {
        return Arrays.stream(LottoResult.values())
                .filter(result -> result.check.test(matchedCount, isBonusMatched))
                .findFirst()
                .orElse(NONE);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    public int getRewardAmount() {
        return rewardAmount;
    }
}
