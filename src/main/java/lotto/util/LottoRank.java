package lotto.util;

import lotto.dto.Lotto;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public enum LottoRank {
    FIRST(1,6,2000000000),
    SECOND(2,5,30000000),
    THIRD(3,5,1500000),
    FOURTH(4,4,50000),
    FIFTH(5,3,5000),
    NONE(6,0,0);

    private static final Map<Integer,LottoRank> countToLottoRank = new HashMap<>(7);

    static {
        countToLottoRank.put(6,FIRST);
        countToLottoRank.put(5,THIRD);
        countToLottoRank.put(4,FOURTH);
        countToLottoRank.put(3,FIFTH);
        countToLottoRank.put(2,NONE);
        countToLottoRank.put(1,NONE);
        countToLottoRank.put(0,NONE);
    }

    private final int rank;
    private final int sameNumberCount;
    private final int prize;

    LottoRank(int rank, int sameNumberCount, int prize) {
        this.rank = rank;
        this.sameNumberCount = sameNumberCount;
        this.prize = prize;
    }

    public static LottoRank fromSameNumberCount(int sameNumberCount, boolean haveBonusNumber) {
        LottoRank lottoRank = countToLottoRank.get(sameNumberCount);
        if(lottoRank==LottoRank.THIRD && haveBonusNumber)
            lottoRank = LottoRank.FIFTH;
        return lottoRank;
    }

    public int getPrize() {
        return prize;
    }

    public int getRank() {
        return rank;
    }

    public long getSameNumberCount() {
        return sameNumberCount;
    }



}
