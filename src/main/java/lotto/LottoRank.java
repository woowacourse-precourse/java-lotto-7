package lotto;

public enum LottoRank {

    GRADE_1TH(2000000000, "6개 일치"),
    GRADE_2TH(30000000, "5개 일치, 보너스 볼 일치"),
    GRADE_3TH(1500000, "5개 일치"),
    GRADE_4TH(50000, "4개 일치"),
    GRADE_5TH(5000, "3개 일치"),
    NONE(0, "2개 이하 일치"),
    ;

    public static final String UNIT = "원";
    private final int prizeMoney;
    private final String winCondition;

    LottoRank(int prizeMoney, String winCondition) {
        this.prizeMoney = prizeMoney;
        this.winCondition = winCondition;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getWinCondition() {
        return winCondition;
    }
}
