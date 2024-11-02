package lotto;

public enum WinningRank {
    FIRST(6, false,"2,000,000,000"),
    SECOND(5, true,"30,000,000"),
    THIRD(5, false,"1,500,000"),
    FOURTH(4, false,"50,000"),
    FIFTH(3, false, "5,000"),
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

}
