package lotto.domain;

public enum Rank {
    FIFTH(3, 0, 5000),
    FOURTH(4, 0, 50000),
    THIRD(5, 0, 1500000),
    SECOND(5, 1, 30000000),
    FIRST(6,0, 2000000000);

    private int equals;
    private int bonus;
    private int price;

    Rank(int equals, int bonus, int price) {
        this.equals = equals;
        this.bonus = bonus;
        this.price = price;
    }

    public int getEquals() {
        return equals;
    }

    public int getBonus() {
        return bonus;
    }

    public int getPrice() {
        return price;
    }

    public String isHaveBonusBall(){
        if (getBonus() == 0) {
            return "";
        }
        return ", 보너스 볼 일치";
    }

    @Override
    public String toString() {
        return getEquals() + "개 일치" + isHaveBonusBall() + " (" +  String.format("%,d", getPrice()) + "원)";
    }
}
