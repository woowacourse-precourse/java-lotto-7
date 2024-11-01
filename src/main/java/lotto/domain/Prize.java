package lotto.domain;

public enum Prize {
    FIRST("6개 일치", "2,000,000,000원"),
    SECOND("5개 일치, 보너스 볼 일치", "30,000,000원"),
    THIRD("5개 일치", "1,500,000원"),
    FOURTH("4개 일치", "50,000원"),
    FIFTH("3개 일치", "5,000원");

    private final String condition;
    private final String prizeMoney;

    Prize(String condition, String prizeMoney) {
        this.condition = condition;
        this.prizeMoney = prizeMoney;
    }
}
