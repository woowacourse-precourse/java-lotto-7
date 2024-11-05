package lotto.domain;

public enum Rank {
    NOT_MATCH(0, "", 0),
    FIFTH_PLACE(3, "3개 일치 (5,000원) - %d개", 5_000),
    FOURTH_PLACE(4, "4개 일치 (50,000원) - %d개", 50_000),
    THIRD_PLACE(5, "5개 일치 (1,500,000원) - %d개", 1_500_000),
    SECOND_PLACE(5, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", 30_000_000),
    FIRST_PLACE(6, "6개 일치 (2,000,000,000원) - %d개", 2_000_000_000);

    final int matchNumber;
    final String message;
    final int prize;

    Rank(int matchNumber, String message, int prize) {

        this.matchNumber = matchNumber;
        this.message = message;
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }


    public String getMessage() {
        return message;
    }
}
