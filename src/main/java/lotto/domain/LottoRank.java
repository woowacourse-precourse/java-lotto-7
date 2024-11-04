package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum LottoRank {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    LottoRank(int matchCount, boolean matchBonus, int prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean getMatchBonus() {
        return matchBonus;
    }

    public int getPrize() {
        return prize;
    }

    // 내림차순 정렬된 리스트 반환
    public static List<LottoRank> getRanksInAscendingOrder() {
        return Arrays.stream(values())
                .sorted(Comparator.comparingInt(LottoRank::getMatchCount)
                        .thenComparing(LottoRank::getMatchBonus))
                .toList();
    }

    public static LottoRank valueOf(int matchCount, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount && rank.matchBonus == hasBonus)
                .findFirst()
                .orElse(NONE);
    }
}