package lotto.domain.utils;

import lotto.domain.model.user.LottoRank;
import lotto.domain.model.lotto.result.LottoSummary;

import java.util.HashMap;

public class TestLottoSummary {

    public static LottoSummary getTestLottoSummary(Long firstCnt, Long secondCnt, Long thirdCnt, Long fourthCnt, Long fifthCnt) {
        int amount = 5000;
        LottoRank first = LottoRank.FIRST;
        LottoRank second = LottoRank.SECOND;
        LottoRank third = LottoRank.THIRD;
        LottoRank fourth = LottoRank.FOURTH;
        LottoRank fifth = LottoRank.FIFTH;
        HashMap<LottoRank, Long> resultMap = new HashMap<>();
        resultMap.put(first, firstCnt);
        resultMap.put(second, secondCnt);
        resultMap.put(third, thirdCnt);
        resultMap.put(fourth, fourthCnt);
        resultMap.put(fifth, fifthCnt);
        return LottoSummary.create(resultMap);
    }
}
