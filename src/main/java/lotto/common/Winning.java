package lotto.common;

public enum Winning {
    THREE(5000, "3개 일치 (5,000원) - %d개\n"),
    FOUR(50000, "4개 일치 (50,000원) - %d개\n"),
    FIVE(1500000, "5개 일치 (1,500,000원) - %d개\n"),
    SIX(30000000, "6개 일치 (2,000,000,000원) - %d개\n"),
    FIVE_BONUS(2000000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    FAIL(0, "");

    private static final Winning[] WINNING_ARR = Winning.values();
    private final int prize;
    private final String prompt;

    Winning(int prize, String prompt) {
        this.prize = prize;
        this.prompt = prompt;
    }

    public static Winning of(int count) {
        if (count < 3) {
            return FAIL;
        }

        return WINNING_ARR[count - 3];
    }

    public int getPrize() {
        return prize;
    }

    public String getPrompt() {
        return prompt;
    }
}
