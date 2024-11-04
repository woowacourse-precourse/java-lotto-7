package lotto;

import java.util.Arrays;
import java.util.function.Supplier;

public enum LottoWinningRanks {
    FIRST(6, false, () -> "2,000,000,000"),
    SECOND(5, true, () -> "30,000,000"),
    THIRD(5, false, () -> "1,500,000"),
    FOURTH(4, false, () -> "50,000"),
    FIFTH(3, false, () -> "5,000"),
    NO_WIN(0, false, () -> "0"); //sameCount = 0, 1, 2

    private final int sameCount;
    private final boolean isBonusMatched;
    private final Supplier<String> getMoney;

    LottoWinningRanks(int sameCount, boolean isBonusMatched, Supplier<String> getMoney) {
        this.sameCount = sameCount;
        this.isBonusMatched = isBonusMatched;
        this.getMoney = getMoney;
    }

    public long getMoney() {
        return Long.parseLong(getMoney.get().replace(",", ""));
    }

    public String getMoneyString() {
        return getMoney.get();
    }

    // `sameCount`와 `isBonusMatched`를 사용해 알맞은 LottoWinningRanks 찾기
    public static LottoWinningRanks getRank(int sameCount, boolean isBonusMatched) {
        if (sameCount == 5 && isBonusMatched) {
            return Arrays.stream(values())
                    .filter(rank -> rank.sameCount == sameCount && rank.isBonusMatched == isBonusMatched)
                    .findFirst()
                    .orElse(NO_WIN);
        }
        return Arrays.stream(values())
                .filter(rank -> rank.sameCount == sameCount)
                .findFirst()
                .orElse(NO_WIN);
    }
}
