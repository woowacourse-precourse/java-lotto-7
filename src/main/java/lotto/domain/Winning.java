package lotto.domain;

public enum Winning {
    THREE("3개 일치 (5,000원)", 5_000L, 3),
    FOUR("4개 일치 (50,000원)", 50_000L, 4),
    FIVE("5개 일치 (1,500,000원)", 1_500_000L, 5),
    FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원)", 30_000_000L, 10),
    SIX("6개 일치 (2,000,000,000원)", 2_000_000_000L, 6);


    private String mean;
    private long winningPrice;
    private int count;

    Winning(String mean, long winningPrice, int count) {
        this.mean = mean;
        this.winningPrice = winningPrice;
        this.count = count;
    }

    public String getMean() {
        return mean;
    }

    public long getWinningPrice() {
        return winningPrice;
    }

    public int getCount() {
        return count;
    }
}
