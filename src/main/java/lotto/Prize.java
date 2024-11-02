package lotto;

public enum Prize {
    FIRST(2_000_000_000,6,false),
    SECOND(30_000_000,5,true),
    THIRD(1_500_000,5,false),
    FOURTH(50_000,4,false),
    FIFTH(5_000,3,false),
    ;

    private final int money;
    private final int normalNumber;
    private final boolean bonusNumber;

    Prize(int money, int normalNumber, boolean bonusNumber) {
        this.money = money;
        this.normalNumber = normalNumber;
        this.bonusNumber = bonusNumber;
    }

    public int getMoney() {
        return money;
    }
    public int getNormalNumber() {
        return normalNumber;
    }
    public boolean getBonusNumber() {
        return bonusNumber;
    }
}
