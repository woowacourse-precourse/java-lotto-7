package lotto.model;

import java.util.List;

public class WinningStandard {
    private Integer rank;
    private String condition;
    private Integer price;

    public static final List<WinningStandard> WINNING_STANDARDS = List.of(
            new WinningStandard(1, "6개 일치", 2000000000),
            new WinningStandard(2, "5개 일치, 보너스 볼 일치", 30000000),
            new WinningStandard(3, "5개 일치", 1500000),
            new WinningStandard(4, "4개 일치", 50000),
            new WinningStandard(5, "3개 일치", 5000),
            new WinningStandard(6, "꽝", 0)
            );

    private WinningStandard(Integer rank, String condition, Integer price) {
        this.rank = rank;
        this.condition = condition;
        this.price = price;
    }

    public Integer getRank() {
        return rank;
    }

    public String getCondition() {
        return condition;
    }

    public Integer getPrice() {
        return price;
    }
}
