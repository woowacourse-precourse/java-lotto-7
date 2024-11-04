package lotto.common;

public enum LottoGrade {
    FIRST,
    SECOND,
    THIRD,
    FOURTH,
    FIFTH,
    NONE;

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
