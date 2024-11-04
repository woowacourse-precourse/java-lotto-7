package lotto;

public enum LottoRank {

    FIRST("1등", 5),
    SECOND("2등", 4),
    THIRD("3등", 3),
    FOURTH("4등", 2),
    FIFTH("5등", 1),
    NONE("꽝",null);

    private final String name;
    private final Integer printOrder;

    LottoRank(String name, Integer printOrder) {
        this.name = name;
        this.printOrder = printOrder;
    }

    public String getName() {
        return name;
    }

    public Integer getPrintOrder() {
        return printOrder;
    }

}
