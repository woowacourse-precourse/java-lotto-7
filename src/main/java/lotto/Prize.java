package lotto;

public enum Prize {
    NONE(0, 0, "---"),
    FIFTH_PLACE(5000, 3, "3개 일치 (5,000원)"),
    FOURTH_PLACE(50000, 4, "4개 일치 (50,000원)"),
    THIRD_PLACE(1500000, 5, "5개 일치 (1,500,000원)"),
    SECOND_PLACE(30000000, 5, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST_PLACE(2000000000, 6, "6개 일치 (2,000,000,000원)");

    private final int amount;
    private final int correct;
    private final String message;

    Prize(int amount, int correct, String message) {
        this.amount = amount;
        this.correct = correct;
        this.message = message;
    }

    public int getAmount() {
        return amount;
    }

    public static Prize getMatchedPrize(int correct, boolean bonusCorrect) {
        if (correct == FIRST_PLACE.correct) return FIRST_PLACE;
        if (correct == SECOND_PLACE.correct && bonusCorrect) return SECOND_PLACE;
        if (correct == THIRD_PLACE.correct) return THIRD_PLACE;
        if (correct == FOURTH_PLACE.correct) return FOURTH_PLACE;
        if (correct == FIFTH_PLACE.correct) return FIFTH_PLACE;
        return NONE;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
