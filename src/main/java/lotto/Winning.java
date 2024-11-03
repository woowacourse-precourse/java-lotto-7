package lotto;

public enum Winning {
    FIFTH("3개 일치 (5,000원)", 5000),
    FOURTH("4개 일치 (50,000원)", 50000),
    THIRD("5개 일치 (1,500,000원)", 1500000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원)", 30000000),
    FIRST("6개 일치 (2,000,000,000원)", 2000000000);

    private final String description;
    private final int amount;

    Winning(String description, int amount) {
        this.description = description;
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }
}
