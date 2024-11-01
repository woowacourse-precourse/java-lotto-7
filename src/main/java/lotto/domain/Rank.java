package lotto.domain;

import java.util.Arrays;

public enum Rank {

    MISS(0, 0, false),
    NO5(3, 5_000L, false),
    NO4(4, 50_000L, false),
    NO3(5, 1_500_000L, false),
    NO2(5, 30_000_000L, true),
    NO1(6, 2_000_000_000L, false);

    private final int rank;
    private final long prize;
    private final boolean bonus;

    Rank(int rank, long prize, boolean bonus) {
        this.rank = rank;
        this.prize = prize;
        this.bonus = bonus;
    }

    public long getPrize() {
        return prize;
    }

    public boolean matches(long matchCount, boolean bonus) {
        if (this == NO2 || this == NO3) {
            return this.rank == matchCount && this.bonus == bonus;
        }
        return this.rank == matchCount;
    }

    public static Rank calculateRank(long matchCount, boolean bonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matches(matchCount, bonus))
                .findFirst()
                .orElse(Rank.MISS);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("%d개 일치", rank));
        if (bonus) {
            output.append(", 보너스 볼 일치");
        }
        return output.append(String.format(" (%,d원)", prize)).toString();
    }
}
