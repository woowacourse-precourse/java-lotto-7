package enums;

import java.util.HashMap;

public enum LottoRank {
    FIRST(1, 2000000000, "6개 일치 (2,000,000,000원) -"),
    SECOND(2, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원) -"),
    THIRD(3, 1500000, "5개 일치 (1,500,000원) - "),
    FOURTH(4, 50000, "4개 일치 (50,000원) - "),
    FIVE(5, 5000, "3개 일치 (5,000원) - "),
    NONE(6, 0, "낙첨");

    private final int hitCount;
    private final boolean hasBonus;
    private final int prize;
    private final String message;

    LottoRank(int hitCount, int prize, String message){
        this.hitCount = hitCount;
        this.hasBonus = false;
        this.prize = prize;
        this.message = message;
    }

    LottoRank(int hitCount, boolean hasBonus, int prize, String message){
        this.hitCount = hitCount;
        this.hasBonus = hasBonus;
        this.prize = prize;
        this.message = message;
    }

    public static LottoRank getLottoRank(int hitCount, boolean hasBonus){
        if(hitCount == 5 && hasBonus){
            return SECOND;
        }
        for(LottoRank rank : LottoRank.values()){
            if(rank.getHitCount() == hitCount){
                return rank;
            }
        }
        return NONE;
    }

    public int getHitCount(){
        return hitCount;
    }

    public String getMessage(){
        return message;
    }
}
