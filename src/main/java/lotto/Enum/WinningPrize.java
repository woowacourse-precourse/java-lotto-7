package lotto.Enum;

public enum WinningPrize {
    FIFTH("3개 일치 (5,000원) - %d개",5000L),
    FOURTH("4개 일치 (50,000원) - %d개",50000L),
    THIRD("5개 일치 (1,500,000원) - %d개",1500000L),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개",30000000L),
    FIRST("6개 일치 (2,000,000,000원) - %d개",2000000000L);

    private final String message;
    private final long prizeMoney;

    WinningPrize(String message, long prizeMoney) {
        this.message = message;
        this.prizeMoney = prizeMoney;
    }

    public String getMessage() {
        return message;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
