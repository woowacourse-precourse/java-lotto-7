package utils;

public enum WinningLotto {
    FIRST_REWARD("6개 일치 (2,000,000,000원) - %d개\n", 2000000000),
    SECOND_REWARD("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", 30000000),
    THIRD_REWARD("5개 일치 (1,500,000원) - %d개\n", 1500000),
    FOURTH_REWARD("4개 일치 (50,000원) - %d개\n", 50000),
    FIFTH_REWARD("3개 일치 (5,000원) - %d개\n", 5000);

    private final String format;
    private final int amount;

    WinningLotto(String format, int amount) {
        this.format = format;
        this.amount = amount;
    }

    public String getFormat() {
        return format;
    }

    public int getAmount() {
        return amount;
    }
}
