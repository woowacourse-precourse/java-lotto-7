package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum LottoPrice {
    FIRST(6, false, 2_000_000_000L),
    SECOND(5, true, 30_000_000L),
    THIRD(5, false, 1_500_000L),
    FOURTH(4, false, 50_000L),
    FIFTH(3, false, 5_000L),
    NONE(0, false, 0L);

    public final int matchCount;
    public final boolean isBonusNumberMatch;
    public final Long money;

    LottoPrice(int matchCount, boolean isBonusNumberMatch, Long money) {
        this.matchCount = matchCount;
        this.isBonusNumberMatch = isBonusNumberMatch;
        this.money = money;
    }

    public static LottoPrice of(int matchCount, boolean isBonusNumberMatch) {
        return Arrays.stream(values())
                .filter(l -> l.isSameLottoPrice(matchCount, isBonusNumberMatch))
                .findFirst()
                .orElse(NONE);
    }

    public void print(int count) {
        if (this == SECOND) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n", matchCount, money, count);
            return;
        }
        System.out.printf("%d개 일치 (%,d원) - %d개\n", matchCount, money, count);
    }

    public static List<LottoPrice> getValues() {
        return List.of(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public Long getProfit(int count) {
        return money * count;
    }

    private boolean isSameLottoPrice(int matchCount, boolean isBonusNumberMatch) {
        System.out.printf("Matching %d with %b to %s: %d with %b%n",
                matchCount, isBonusNumberMatch, this.name(),
                this.matchCount, this.isBonusNumberMatch);
        return this.matchCount == matchCount && this.isBonusNumberMatch == isBonusNumberMatch;
    }
}
