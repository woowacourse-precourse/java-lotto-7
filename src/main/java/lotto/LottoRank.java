package lotto;

public enum LottoRank {
    FIRST("6개 일치 (2,000,000,000원) - %d개", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30000000),
    THIRD("5개 일치 (1,500,000원) - %d개", 1500000),
    FOURTH("4개 일치 (50,000원) - %d개", 50000),
    FIFTH("3개 일치 (5,000원) - %d개", 5000);

    private final String message;
    private final int prize;

    LottoRank(String message, int prize) {
        this.message = message;
        this.prize = prize;
    }

    public String format(int count) {
        return String.format(message, count);
    }

    public int getPrize() {
        return prize;
    }
}
