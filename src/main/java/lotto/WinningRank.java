package lotto;

public enum WinningRank {
    FIFTH(3, false, "5,000"),
    FOURTH(4, false,"50,000"),
    THIRD(5, false,"1,500,000"),
    SECOND(5, true,"30,000,000"),
    FIRST(6, false,"2,000,000,000"),
    ;

    private final Integer correct;
    private final Boolean isBonus;
    private final String price;

    WinningRank(int correct, boolean isBonus, String price) {
        this.correct = correct;
        this.isBonus = isBonus;
        this.price = price;
    }

    public int getCorrectCount() {
        return correct;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public String getPrice() {
        return price;
    }

    public static WinningRank findByMatch(int correct, boolean isBonusMatched) {
        for (WinningRank rank : values()) {
            if (rank.getCorrectCount() == correct && rank.isBonus() == isBonusMatched) {
                return rank;
            }
        }
        return null;
    }

    public String getResultMessage(int count) {
        StringBuilder message = new StringBuilder();
        message.append(correct).append("개 일치");

        if (Boolean.TRUE.equals(isBonus)) {
            message.append(", 보너스 볼 일치");
        }

        message.append(" (").append(price).append("원) - ").append(count).append("개");
        return message.toString();
    }

}
