package lotto.view;

import lotto.model.LottoResult;

import java.util.List;

public class OutputView {

    public void printResult(List<LottoResult> lottoResults, int profitRate){
        System.out.println("당첨 통계");
        System.out.println("---");
        printLottoPlace(lottoResults);
        printProfitRate(profitRate);
    }

    private void printLottoPlace(List<LottoResult> lottoResults){
        for (LottoResult lottoResult : lottoResults) {
            System.out.println(lottoResult.getLottoRanking().getMessage() + " - " + lottoResult.getWinCount() + "개");
        }
    }

    private void printProfitRate(int profitRate){
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
