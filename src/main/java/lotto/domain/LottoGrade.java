package lotto.domain;

import java.util.Arrays;

public enum LottoGrade {

    FIRST(6, 0, 2_000_000_000),
    SECOND(5, 1, 30_000_000),
    THIRD(5, 0, 1_500_000),
    FORTH(4, 0, 50_000),
    FIFTH(3, 0, 5_000),
    FAIL(0, 0, 0),
    ;

    private final int target;
    private final int bonus;
    private final long price;

    LottoGrade(int target, int bonus, long price) {
        this.target = target;
        this.bonus = bonus;
        this.price = price;
    }

    protected static LottoGrade match(int target, int bonus) {
        validate(target, bonus);

        return Arrays.stream(LottoGrade.values())
                .filter(lottoGrade -> target >= lottoGrade.target)
                .filter(lottoGrade -> bonus >= lottoGrade.bonus)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 등급 등록되지 않음"));
    }

    private static void validate(int target, int bonus) {
        if (target < 0 || target > 6 || bonus < 0 || bonus > 1) {
            throw new IllegalArgumentException("해당하는 등급 등록되지 않음");
        }
    }

    public long getPrice() {
        return price;
    }

    public int getTarget() {
        return target;
    }
}
