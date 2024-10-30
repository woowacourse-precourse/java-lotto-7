package lotto.domain;

/**
 * 등수
 * 일치 개수
 * 상금
 * 보너스 번호 유무
 */
public enum Rank {
    FIFTH(5,3,false,5000L,"오천"),
    FOURTH(4,4,true,50000L,"오만"),
    THIRD(3,5,false,1500000L,"백오십만"),
    SECOND(2,5,true,30000000L,"삼천만"),
    FIRST(1,6,false,2000000000L,"이십억"),
    NOTHING(-1,-1,false,0L,"영");

    private final int rank;
    private final int matchCount;
    private final boolean hasBonus;
    private final Long prizeMoney;
    private final String prizeMoneyKorean;

    Rank(int rank,int matchCount,boolean hasBonus,
         Long prizeMoney, String prizeMoneyKorean) {
        this.hasBonus = hasBonus;
        this.rank = rank;
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
        this.prizeMoneyKorean = prizeMoneyKorean;
    }

}
