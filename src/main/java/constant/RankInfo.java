package constant;

public enum RankInfo {
    RANK_1(1),
    RANK_2(2),
    RANK_3(3),
    RANK_4(4),
    RANK_5(5),
    UNRANKED(-1),
    RANK_1_THRESHOLD(6),
    RANK_3_THRESHOLD(5),
    RANK_4_THRESHOLD(4),
    RANK_5_THRESHOLD(3),
    PRIZE_RANK_5(5000),
    PRIZE_RANK_4(50000),
    PRIZE_RANK_3(1500000),
    PRIZE_RANK_2(30000000),
    PRIZE_RANK_1(2000000000);

    private final int value;

    RankInfo(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
