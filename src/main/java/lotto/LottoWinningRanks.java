package lotto;

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
}
