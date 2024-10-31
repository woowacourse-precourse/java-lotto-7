package lotto;

import java.util.EnumMap;

public enum Rank {
    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FOURTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    NONE(0,0,0);

    private final int matchCount;
    private final int bonusCount;
    private final int prize;

    Rank(int matchCount, int bonusCount, int prize) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount, int bonusCount) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && bonusCount == 1) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }

    public static Long calculateWinningAmount(EnumMap<Rank, Integer> enumMap) {
        Long sum = 0L;
        Integer firstCount = enumMap.getOrDefault(Rank.FIRST, 0);
        sum += firstCount * Rank.FIRST.prize;
        Integer secondCount = enumMap.getOrDefault(Rank.SECOND, 0);
        sum += secondCount * Rank.SECOND.prize;
        Integer thirdCount = enumMap.getOrDefault(Rank.THIRD, 0);
        sum += thirdCount * Rank.THIRD.prize;
        Integer fourthCount = enumMap.getOrDefault(Rank.FOURTH, 0);
        sum += fourthCount * Rank.FOURTH.prize;
        Integer fifthCount = enumMap.getOrDefault(Rank.FIFTH, 0);
        sum += fifthCount * Rank.FIFTH.prize;

        return sum;
    }

    public long getMoney() {
        return this.prize;
    }

    public int getMatchCount() {
        return this.matchCount;
    }
}
