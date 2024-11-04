package lotto;

public enum LottoEnum {
    FIRST(2000000000), 
    SECOND(30000000), 
    THIRD(1500000), 
    FOURTH(50000), 
    FIFTH(5000), 
    NONE(0);

    private final int prize;

    LottoEnum(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
