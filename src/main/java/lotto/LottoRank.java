package lotto;

import java.util.Arrays;

public enum LottoRank {

    THREE_MATCH(3,"3개 일치 (5,000원) - ",5000),
    FOUR_MATCH(4,"4개 일치 (50,000원) - ",50000),
    FIRVE_MATCH(5,"5개 일치 (1,500,000원) - ",1500000),
    FIVE_BONUS_MATCH(6,"5개 일치, 보너스 볼 일치 (30,000,000원) - ",30000000),
    SIX_MATCH(7,"6개 일치 (2,000,000,000원) - ",2000000000);

    private int key;
    private String description;
    private long prize;
    LottoRank(int key,String description,long prize) {
        this.key = key;
        this.description = description;
        this.prize = prize;
    }

    public int getKey() {
        return key;
    }

    public String getDescription() {
        return description;
    }
    public long getPrize(){
        return prize;
    }
    public static LottoRank findRankFromKey(int key) {
        for (LottoRank rank : values()) {
            if (rank.key == key) {
                return rank;
            }
        }
        return null; // 키에 해당하는 Enum이 없을 경우 null 반환
    }

}
