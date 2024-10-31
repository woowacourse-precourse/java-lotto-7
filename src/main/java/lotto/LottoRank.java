package lotto;

public enum LottoRank {

    GRADE_1TH(2000000000),
    GRADE_2TH(30000000),
    GRADE_3TH(1500000),
    GRADE_4TH(50000),
    GRADE_5TH(5000),
    NONE(0),
    ;

    public static final String UNIT = "원";
    private final int prizeMoney;

    LottoRank(int prizeMoney) {
        this.prizeMoney = prizeMoney;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
