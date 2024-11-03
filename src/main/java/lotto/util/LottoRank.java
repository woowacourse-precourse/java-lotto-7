package lotto.util;

import lotto.dto.Lotto;

import java.util.*;
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
    public static final LottoRank[] allLottoRank = new LottoRank[] {LottoRank.FIFTH,LottoRank.FOURTH,LottoRank.THIRD,LottoRank.SECOND,LottoRank.FIRST};

    private final int rank;
    private final int sameNumberCount;
    private final int prize;

    LottoRank(int rank, int sameNumberCount, int prize) {
        this.rank = rank;
        this.sameNumberCount = sameNumberCount;
        this.prize = prize;
    }

    public static LottoRank fromSameNumberCount(int sameNumberCount, boolean haveBonusNumber) {
        if(sameNumberCount > 6)
            throw new IllegalArgumentException("[ERROR] 로또는 번호는 최대 6개까지 같을 수 있습니다.");
        LottoRank rank = countToLottoRank.get(sameNumberCount);
        if(rank==LottoRank.THIRD && haveBonusNumber)
            rank = LottoRank.SECOND;
        return rank;
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
