package lotto.domain;

public enum Winning {
    THREE(3, 5000, "3개 일치 (5,000원) - %d개\n"),
    FOUR(4, 50000, "4개 일치 (50,000원) - %d개\n"),
    FIVE(5, 1500000, "5개 일치 (1,500,000원) - %d개\n"),
    FIVE_BONUS(5, 2000000000, "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    SIX(6, 30000000, "6개 일치 (2,000,000,000원) - %d개\n"),
    FAIL(0, 0, "");

    private final int count;
    private final int prize;
    private final String prompt;

    Winning(int count, int prize, String prompt) {
        this.count = count;
        this.prize = prize;
        this.prompt = prompt;
    }

    public static Winning of(int count, boolean matchedBonus) {
        if (count == 5 && matchedBonus) {
            return FIVE_BONUS;
        }

        for (Winning winning : Winning.values()) {
            if (count == winning.count) {
                return winning;
            }
        }

        return FAIL;
    }

    public int getPrize() {
        return prize;
    }

    public String getPrompt() {
        return prompt;
    }
}
