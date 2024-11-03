package lotto;

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

    public static LottoGrade findBy(int target, long bonus) {
        return Arrays.stream(LottoGrade.values())
                .filter(lottoGrade -> lottoGrade.target >= target)
                .filter(lottoGrade -> lottoGrade.bonus >= bonus)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당하는 등급 등록되지 않음"));
    }
}
