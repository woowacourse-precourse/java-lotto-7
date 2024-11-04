package lotto;

public enum Rank {

    FIRST("6개 일치", 2000000000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    THIRD("5개 일치", 1500000),
    FOURTH("4개 일치", 50000),
    FIFTH("3개 일치", 5000),
    NONE("",0);
    private final String description;
    private final Integer prize;

    Rank(String description, Integer prize) {
        this.description = description;
        this.prize = prize;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrize() {
        return prize;
    }
}
