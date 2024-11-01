package lotto.domain;

public enum Prize {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    LOSE(0);

    private int standard;
    private boolean bonusNumMatch;
    private int amount;

    Prize(int amount) {
        this.amount = amount;
    }

    Prize(int standard, boolean bonusNumMatch, int amount) {
        this.standard = standard;
        this.bonusNumMatch = bonusNumMatch;
        this.amount = amount;
    }
}
