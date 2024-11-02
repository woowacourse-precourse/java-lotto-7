package lotto.view;

import lotto.LottoWinningRank;

import java.util.Map;

public class LottoResultView {

    public void outputLottoResult(Map<LottoWinningRank, Integer> result) {
        System.out.println("당첨 통계\n---");

        System.out.println(LottoWinningRank.FIFTH.getPrizeMent()
                + result.getOrDefault(LottoWinningRank.FIFTH,0) + "개");
        System.out.println(LottoWinningRank.FOURTH.getPrizeMent()
                + result.getOrDefault(LottoWinningRank.FOURTH,0) + "개");
        System.out.println(LottoWinningRank.THIRD.getPrizeMent()
                + result.getOrDefault(LottoWinningRank.THIRD,0)+ "개");
        System.out.println(LottoWinningRank.SECOND.getPrizeMent()
                + result.getOrDefault(LottoWinningRank.SECOND,0) + "개");
        System.out.println(LottoWinningRank.FIRST.getPrizeMent()
                + result.getOrDefault(LottoWinningRank.FIRST,0) + "개");
    }

    public void outputProfitMargin(String profitMargin) {
        System.out.println("총 수익률은 " + profitMargin + "입니다.");
    }

}
