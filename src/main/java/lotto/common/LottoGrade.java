package lotto.common;

import lotto.helper.CurrencyFormatter;

public enum LottoGrade {
    NONE(0, "해당 되는 경우 없음"),
    FIFTH(5_000, "3개 일치"),
    FOURTH(50_000, "4개 일치"),
    THIRD(1_500_000, "5개 일치"),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치"),
    FIRST(2_000_000_000, "6개 일치"),
    ;

    private final int cost;
    private final String reason;

    LottoGrade(int cost, String reason) {
        this.cost = cost;
        this.reason = reason;
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

    public String getMessage() {
        return String.format("%s (%s원)", reason, CurrencyFormatter.format(cost));
    }

    public float calcAmount(int count) {
        return (float) cost * count;
    }
}
