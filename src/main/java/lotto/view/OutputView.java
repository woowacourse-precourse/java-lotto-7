package lotto.view;

import java.util.ArrayList;
import java.util.HashMap;
import lotto.Lotto;
import lotto.util.LottoRank;

public class OutputView {

    public void printLottoInfo(ArrayList<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).toString());
        }
    }

    public void printWinningResult(HashMap<LottoRank, Integer> winningResult) {
        System.out.println("당첨 통계");
        System.out.println("---");
        StringBuilder sb = new StringBuilder();
        for (LottoRank lottoRank : LottoRank.values()){
            sb.append(lottoRank.toString()+winningResult.get(lottoRank)+"개\n");
        }
        System.out.println(sb);
    }

    public void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
