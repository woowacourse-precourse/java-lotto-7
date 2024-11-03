package lotto.properties;

import java.util.Arrays;

public enum LottoMatch {
    로또1등(6, 0, 2000000000),
    로또2등(5, 1, 30000000),
    로또3등(5, 0, 1500000),
    로또4등(4, 0, 50000),
    로또5등(3, 0, 5000);

    private final int matchCount;
    private final int matchBonus;
    private final int prize;

    LottoMatch(int matchCount, int matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize;
    }

    public static LottoMatch getLottoMatch(int matchCount, int matchBonus) {
        return Arrays.stream(values()).filter(lottoMatch -> lottoMatch.matchCount==matchCount && lottoMatch.matchBonus==matchBonus).findFirst().orElse(null);
    }


}
