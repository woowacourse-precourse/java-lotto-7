package lotto.domain;

public enum LottoRank {
    FIFTH(3, "5,000"),
    FOURTH(4, "50,000"),
    THIRD(5, "1,500,000"),
    SECOND(5, "30,000,000"),
    FIRST(6, "2,000,000,000");


    private final int matchCount;
    private final String price;

    LottoRank(int matchCount, String price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public String getPrice() {
        return price;
    }

    public static LottoRank getRankByMatchCount(int count) {
        for (LottoRank rank : values()) {
            if (rank.getMatchCount() == count) {
                return rank;
            }
        }
        return null; // 매치되는 것이 없을 경우 null 반환
    }

}
