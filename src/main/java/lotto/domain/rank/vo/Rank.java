package lotto.domain.rank.vo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public enum Rank {
    FIRST(1, 6, 0, 2_000_000_000),
    SECOND(2, 5, 1, 30_000_000),
    THIRD(3, 5, 0, 1_500_000),
    FOURTH(4, 4, 0, 50_000),
    FIFTH(5, 3, 0, 5_000);

    private final int rank;
    private final int match;
    private final int bonus;
    private final int prize;

    private Rank(int rank, int match, int bonus, int prize) {
        this.rank = rank;
        this.match = match;
        this.bonus = bonus;
        this.prize = prize;
    }

    public static Rank of(int match, int bonus) {
        return Arrays.stream(values())
                .filter(rank -> rank.match == match && rank.bonus == bonus)
                .findFirst()
                .orElse(null);
    }

    public int getPrize() {
        return prize;
    }

    public static List<Rank> getSortedRanks() {
        return Arrays.stream(values())
                .sorted(Comparator.comparingInt(value -> value.rank))
                .toList()
                .reversed();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%d개 일치", match));
        if (bonus > 0) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(String.format(" (%,d원)", prize));
        return stringBuilder.toString();
    }
}
