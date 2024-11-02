package lotto.domain;

public enum LottoRank {
    FIFTH(3, "5,000", "3개 일치 (5,000원)"),
    FOURTH(4, "50,000", "4개 일치 (50,000원)"),
    THIRD(5, "1,500,000", "5개 일치 (1,500,000원)"),
    SECOND(5, "30,000,000", "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, "2,000,000,000", "6개 일치 (2,000,000,000원)");


    private final int matchCount;
    private final String price;
    private final String match;


    LottoRank(int matchCount, String price, String match) {
        this.matchCount = matchCount;
        this.price = price;
        this.match = match;
    }

    public int getMatchCount() { return matchCount; }

    public String getPrice() {
        return price;
    }

    public String getMatch() {
        return match;
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
