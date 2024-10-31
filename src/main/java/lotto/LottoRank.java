package lotto;

public enum LottoRank {
    FIRST("1등",2000000000),
    SECOND("2등",30000000),
    THIRD("3등",1500000),
    FOURTH("4등",50000),
    FIFTH("5등",5000),
    MISS("꽝",0);

    private final String name;
    private final int price;

    LottoRank(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
