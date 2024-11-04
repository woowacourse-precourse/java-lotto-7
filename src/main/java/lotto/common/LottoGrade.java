package lotto.common;

public enum LottoGrade {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NONE(0);

    private final int cost;

    LottoGrade(int cost) {
        this.cost = cost;
    }

    public static LottoGrade getGrade(int count, boolean bonus) {
        if (count == 3) {
            return FIFTH;
        }
        if (count == 4) {
            return FOURTH;
        }
        if (count == 5 && bonus) {
            return SECOND;
        }
        if (count == 5) {
            return THIRD;
        }
        if (count == 6) {
            return FIRST;
        }
        return NONE;
    }
}
