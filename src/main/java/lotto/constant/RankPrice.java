package lotto.constant;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum RankPrice {
    FIRST(6, null, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, null, 50_000),
    FIFTH(3, null, 5_000),
    NONE(0, null, 0),
    ;

    private int matchCount;
    private Boolean matchBonus;
    private long price;

    RankPrice(int matchCount, Boolean matchBonus, long price) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.price = price;
    }

    public static RankPrice of(int matchCount, boolean matchBonus) {
        List<RankPrice> rankPrices = Arrays.stream(values())
            .filter(rankPrice -> rankPrice.matchCount == matchCount)
            .toList();
        if (rankPrices.size() > 1) {
            return rankPrices.stream()
                .filter(rankPrice -> rankPrice.matchBonus == matchBonus)
                .findAny()
                .orElseThrow(() -> new IllegalStateException("[ERROR] 존재하지 않는 등수입니다."));
        }
        if (rankPrices.size() == 1) {
            return rankPrices.getFirst();
        }
        return NONE;
    }

    public static List<RankPrice> values(Comparator<RankPrice> comparator) {
        List<RankPrice> rankPrices = Arrays.asList(values());
        if (comparator != null) {
            rankPrices.sort(comparator);
        }
        return rankPrices;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrice() {
        return price;
    }

    public int getRank() {
        return this.ordinal() + 1;
    }
}
