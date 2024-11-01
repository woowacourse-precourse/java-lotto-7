package lotto.model;

import java.util.HashMap;

public enum LottoRank {
    FIRST(6,2000000000),
    SECOND(5,30000000,true),
    THIRD(5,1500000),
    FOURTH(4,50000),
    FIFTH(3,5000),
    MISS(0,0);

    private final int hitCount;
    private final int prizeMoney;
    private final boolean hasBonus;

    private static final HashMap<Integer,LottoRank> rankMap = new HashMap<>();

    static{
        for(LottoRank lottoRank : lotto.model.LottoRank.values()){
            rankMap.put(lottoRank.hitCount, lottoRank);
        }
    }
    LottoRank(int hitCount, int prizeMoney){
        this.hitCount = hitCount;
        this.prizeMoney = prizeMoney;
        this.hasBonus = false;
    }
    LottoRank(int hitCount, int prizeMoney, boolean hasBonus){
        this.hitCount = hitCount;
        this.prizeMoney = prizeMoney;
        this.hasBonus = hasBonus;
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
