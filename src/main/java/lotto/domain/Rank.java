package lotto.domain;

import java.util.Arrays;

public enum Rank {

    NO5(3, 5_000L, false, "3개 일치 (5,000원) - "),
    NO4(4, 50_000L, false, "4개 일치 (50,000원) - "),
    NO3(5, 1_500_000L, false, "5개 일치 (1,500,000원) - "),
    NO2(5, 30_000_000L, true, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    NO1(6, 2_000_000_000L, false, "6개 일치 (2,000,000,000원) - ");

    private final int rank;
    private final long prize;
    private final boolean bonus;
    private final String msg;

    Rank(int rank, long prize, boolean bonus, String msg) {
        this.rank = rank;
        this.prize = prize;
        this.bonus = bonus;
        this.msg = msg;
    }

    public long getPrize() {
        return prize;
    }

    public String getMsg() {
        return msg;
    }

    public boolean matches(int matchCount, boolean bonus) {
        return this.rank == matchCount && bonus == this.bonus;
    }

    public static Rank calculateRank(int matchCount, boolean bonus) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matches(matchCount, bonus))
                .findFirst()
                .orElse(Rank.NO5);
    }

}
