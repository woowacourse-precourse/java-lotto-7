package lotto.model.domain;

public enum LottoPrize {
    FIRST(2000000000, "6개 일치 (2,000,000,000원) - %d개"),
    SECOND(30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    THIRD(1500000, "5개 일치 (1,500,000원) - %d개"),
    FOURTH(50000, "4개 일치 (50,000원) - %d개"),
    FIFTH(5000, "3개 일치 (5,000원) - %d개"),
    NO_RANK(0, "NO_RANK");

    private final int prize;
    private final String message;

    LottoPrize(int prize, String message) {
        this.prize = prize;
        this.message = message;
    }
}
