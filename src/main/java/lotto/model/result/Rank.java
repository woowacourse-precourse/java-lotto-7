package lotto.model.result;

public enum Rank {
    FIFTH( 5000, "3개 일치 (5,000원) - "),
    FOURTH( 50000, "4개 일치 (50,000원) - "),
    THIRD( 1500000, "5개 일치 (1,500,000원) - "),
    SECOND( 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST( 2000000000, "6개 일치 (2,000,000,000원) - ");

    private final int prize;
    private final String printFormat;

    Rank(int prize, String printFormat) {
        this.prize = prize;
        this.printFormat = printFormat;
    }

    public String getPrintFormat() {
        return this.printFormat;
    }

    public long calculatePrize(int count) {
        return (long) this.prize * count;
    }
}
