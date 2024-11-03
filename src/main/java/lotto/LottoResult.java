package lotto;

import java.util.*;

public class LottoResult {
    public int[] calculateRank(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        int[] resultCnt = new int[LottoRank.values().length];

        for (Lotto lotto : lottos) {
            int matchCnt = lotto.checkNumbers(winningLotto);
            int matchBonus = lotto.checkBonus(bonusNumber);
            LottoRank rank = LottoRank.getLottoRank(matchCnt, matchBonus);

            if (rank != null) resultCnt[rank.ordinal()]++; // 랭크 인덱스에 위치한 배열 값 증가
        }
        return resultCnt;
    }

    public double calculateProfitRate(int[] resultCnt, int purchaseAmount) {
        return 0.0;
    }
}
