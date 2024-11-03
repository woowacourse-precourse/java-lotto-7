package lotto.constant;

import java.util.Arrays;
import java.util.function.Predicate;
import lotto.model.CorrectCount;

public enum WinningType {

    NONE(0, c -> c.getCount() < 3 && !c.hasBonus(), "3개 미만 일치", 0L),
    FIFTH(3, c -> c.getCount() == 3 && !c.hasBonus(), "3개 일치", 5_000L),
    FOURTH(4, c -> c.getCount() == 4 && !c.hasBonus(), "4개 일치", 50_000L),
    THIRD(5, c -> c.getCount() == 5 && !c.hasBonus(), "5개 일치", 1_500_000L),
    BONUS(5, c -> c.getCount() == 5 && c.hasBonus(), "5개 일치, 보너스 볼 일치", 30_000_000L),
    FIRST(6, c -> c.getCount() == 6 && !c.hasBonus(), "6개 일치", 2_000_000_000L);

    private Integer correctCount;
    private Predicate<CorrectCount> expression;
    private String detail;
    private Long price;

    WinningType(final Integer correctCount, final Predicate<CorrectCount> expression, final String detail,
                final Long price) {
        this.correctCount = correctCount;
        this.expression = expression;
        this.detail = detail;
        this.price = price;
    }

    public static WinningType getType(CorrectCount correctCount) {
        return Arrays.stream(WinningType.values())
                .filter(type -> type.expression.test(correctCount))
                .findFirst()
                .orElse(NONE);
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public String getDetail() {
        return detail;
    }

    public Long getPrice() {
        return price;
    }
}
