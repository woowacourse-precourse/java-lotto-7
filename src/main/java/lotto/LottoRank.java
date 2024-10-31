package lotto;

public enum LottoRank {
    three, four, five, bonus, six;
    public String getMessage(){
        if (this == three) return "3개 일치 (5,000원) - ";
        if (this == four) return "4개 일치 (10,000원) - ";
        if (this == five) return "5개 일치 (1,500,000원) - ";
        if (this == bonus) return "5개 일치, 보너스 볼 일치 (3,000,000원) - ";
        if (this == six) return "6개 일치 (2,000,000,000원) - ";
        return "";
    }
}
