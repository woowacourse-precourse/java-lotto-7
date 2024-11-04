package lotto;

public enum LottoRank {

    LOTTOFIRSTRANK (2000000000,"6개 일치 (2,000,000,000원)"),
    LOTTOSECONDRANK (30000000,"5개 일치, 보너스 볼 일치 (30,000,000원)"),
    LOTTOTHIRDRANK ( 1500000,"5개 일치 (1,500,000원)"),
    LOTTOFORTHRANK (50000,"4개 일치 (50,000원)"),
    LOTTOFIFTHRANK (5000,"3개 일치 (5,000원)"),
    LOTTOFAILRANK(0,"");


    private final int prizeMoney;
    private final String comment;

    LottoRank(int prizeMoney,String comment) {
        this.prizeMoney = prizeMoney;
        this.comment=comment;
    }

    public int getprizeMoney() {
        return prizeMoney;
    }

    public String getComment() {
        return comment;
    }
}
