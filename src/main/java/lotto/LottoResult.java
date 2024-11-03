package lotto;

import java.util.*;

public class LottoResult {
    private static final double PERCENTAGE_FACTOR = 100.0;

    public int[] calculateRank(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        int[] resultCnt = new int[LottoRank.values().length];

        for (Lotto lotto : lottos) {
            int matchCnt = lotto.checkNumbers(winningLotto);
            boolean matchBonus = lotto.checkBonus(bonusNumber);
            LottoRank rank = LottoRank.getLottoRank(matchCnt, matchBonus);

            if (rank != null) resultCnt[rank.ordinal()]++; // 랭크 인덱스에 위치한 배열 값 증가
        }

        return resultCnt;
    }

    public double calculateProfitRate(int[] resultCnt, int purchaseAmount) {
        int totalWinnings = 0;

        for (int i = 0; i < resultCnt.length; i++) {
            totalWinnings += resultCnt[i] * LottoRank.values()[i].getPrize();
        }

        return totalWinnings / (double) purchaseAmount * PERCENTAGE_FACTOR;
    }
}
