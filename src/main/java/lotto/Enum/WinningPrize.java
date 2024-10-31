package lotto.Enum;

public enum WinningPrize {
    FIRST(0, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(1, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(1, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(2, "4개 일치 (50,000원) - %d개"),
    FIFTH(3, "3개 일치 (5,000원) - %d개");

    public final int difference;
    private final String message;

    WinningPrize(int difference, String message) {
        this.difference = difference;
        this.message = message;
    }

    public int getDifference() {
        return difference;
    }

    public String getMessage() {
        return message;
    }
}
