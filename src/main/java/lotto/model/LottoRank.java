package lotto.model;

import java.util.HashMap;

public enum LottoRank {
    FIRST(6,2000000000,"6개 일치 (2,000,000,000원) - "),
    SECOND(5,30000000,true,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5,1500000,"5개 일치 (1,500,000원) - "),
    FOURTH(4,50000,"4개 일치 (50,000원) - "),
    FIFTH(3,5000,"3개 일치 (5,000원) - "),
    MISS(0,0,"낙첨");

    private final int hitCount;
    private final int prizeMoney;
    private final boolean hasBonus;
    private final String message;

    private static final HashMap<Integer,LottoRank> rankMap = new HashMap<>();

    static{
        for(LottoRank lottoRank : lotto.model.LottoRank.values()){
            rankMap.put(lottoRank.hitCount, lottoRank);
        }
    }
    LottoRank(int hitCount, int prizeMoney, String message){
        this.hitCount = hitCount;
        this.prizeMoney = prizeMoney;
        this.hasBonus = false;
        this.message = message;
    }
    LottoRank(int hitCount, int prizeMoney, boolean hasBonus, String message){
        this.hitCount = hitCount;
        this.prizeMoney = prizeMoney;
        this.hasBonus = hasBonus;
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public int getHitCount(){
        return hitCount;
    }

    public int getPrizeMoney(){
        return prizeMoney;
    }
    public static LottoRank getLottoRank(int hitCount, boolean hasBonus){
        if(hitCount==5 && hasBonus){
            return SECOND;
        }
        return rankMap.getOrDefault(hitCount, MISS);
    }

}
